package com.marstalk.mrpc.consumer;

import com.marstalk.mrpc.core.ProxyFactory;
import com.marstalk.mrpc.service.HelloService;

public class consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.get(HelloService.class);
        System.out.println(helloService.hi("shanzhonglaosou"));

    }
}
