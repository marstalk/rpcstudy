package com.marstalk.mrpc.protocol.http;

import com.marstalk.mrpc.core.Invocation;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpHandler handler = new HttpHandler();
        ServletInputStream inputStream = req.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            Invocation invocation = (Invocation) objectInputStream.readObject();
            Object result = handler.handle(invocation);
            ServletOutputStream outputStream = resp.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

            outputStream.close();
            objectOutputStream.close();

            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        super.service(req, resp);
    }
}
