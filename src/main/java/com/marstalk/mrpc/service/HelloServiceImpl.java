package com.marstalk.mrpc.service;

public class HelloServiceImpl implements HelloService {

    @Override
    public String hi(String name) {
        return "Hello " + name;
    }

}
