package com.marstalk.rpcstudy.protocol.http;

import com.marstalk.rpcstudy.core.Invocation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {
    public Object send(String host, int port, Invocation invocation){
        try {
            URL url = new URL("http", host, port, new File(".").getAbsolutePath());
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            OutputStream outputStream = urlConnection.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();

            InputStream inputStream = urlConnection.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object o = objectInputStream.readObject();

            outputStream.close();
            objectOutputStream.close();
            inputStream.close();
            objectInputStream.close();

            return o;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
