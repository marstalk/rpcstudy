package com.marstalk.rpcstudy.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalRegister implements Register {
    private static Map<String, Class> registry = new ConcurrentHashMap<>();

    @Override
    public void register(String serviceName, Class clazz) {
        registry.put(serviceName, clazz);
    }

    public static Class getService(String serviceName){
        return registry.get(serviceName);
    }

}
