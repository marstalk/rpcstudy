package com.marstalk.mrpc.register;

import com.marstalk.mrpc.core.URL;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalRegister implements Register {

    private static Map<String, Class> registry = new ConcurrentHashMap<>();

    @Override
    public void register(String serviceName, Class clazz) {
        registry.put(serviceName, clazz);
    }

    @Override
    public List<URL> getUrls(String servicename) {
        return null;
    }

    public static Class getService(String serviceName) {
        return registry.get(serviceName);
    }

}
