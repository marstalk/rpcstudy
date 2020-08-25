package com.marstalk.mrpc.protocol.http;

import com.marstalk.mrpc.core.Invocation;
import com.marstalk.mrpc.register.LocalRegister;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpHandler {

    Object handle(Invocation invocation) {
        Class service = LocalRegister.getService(invocation.getServiceName());
        Object invoke = null;
        try {
            Method method = service.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            invoke = method.invoke(service.newInstance(), invocation.getParams());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return invoke;
    }

}
