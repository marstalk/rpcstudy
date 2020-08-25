package com.marstalk.mrpc.protocol.http;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class HttpServer {

    public void start(int port) {
        Tomcat tomcat = new Tomcat();
        Context context = tomcat.addContext("", new File(".").getAbsolutePath());
        Tomcat.addServlet(context, "dispatcherServlet", new DispatcherServlet());
        context.addServletMappingDecoded("/*", "dispatcherServlet");

        tomcat.setPort(port);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
