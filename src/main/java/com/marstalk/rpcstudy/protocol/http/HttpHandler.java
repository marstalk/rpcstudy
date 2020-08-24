package com.marstalk.rpcstudy.protocol.http;

import com.marstalk.rpcstudy.core.Invocation;
import com.marstalk.rpcstudy.register.LocalRegister;

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
