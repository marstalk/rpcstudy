package com.marstalk.rpcstudy.consumer;

import com.marstalk.rpcstudy.core.Invocation;
import com.marstalk.rpcstudy.protocol.http.HttpClient;
import com.marstalk.rpcstudy.service.HelloService;

public class consumer {
    public static void main(String[] args) {
        Invocation invocation = new Invocation(HelloService.class.getName(), "hi", new Class[]{String.class}, new Object[]{"shanzhonglaosou"});
        HttpClient httpClient = new HttpClient();
        Object localhost = httpClient.send("localhost", 9999, invocation);
        System.out.println(localhost);

    }
}
