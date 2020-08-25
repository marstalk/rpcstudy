package com.marstalk.mrpc.core;

import com.marstalk.mrpc.protocol.http.HttpClient;
import com.marstalk.mrpc.register.zk.ZkRegister;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

    public static <T> T get(Class clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            HttpClient httpClient = new HttpClient();
            Invocation invocation = new Invocation(clazz.getName(), method.getName(), new Class[]{String.class}, args);
            //get URL from registry.
            ZkRegister zkRegister = new ZkRegister();
            //TODO optimize: read provider once only, then watch the provider node.
            List<URL> urls = zkRegister.getUrls(clazz.getName());
            if (CollectionUtils.isEmpty(urls)) {
                System.out.println("Can't get any provider from registry");
                return null;
            }
            //TODO optimize: loadBalance
            String[] hostAndPort = urls.get(0).getHostAndPort().split(":");
            Object result = httpClient.send(hostAndPort[0], Integer.parseInt(hostAndPort[1]), invocation);
            return result;
        });
    }

}
