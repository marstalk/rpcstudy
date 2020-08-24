package com.marstalk.rpcstudy.provider;

import com.marstalk.rpcstudy.protocol.http.HttpServer;
import com.marstalk.rpcstudy.register.LocalRegister;
import com.marstalk.rpcstudy.register.ZkRegister;
import com.marstalk.rpcstudy.service.HelloService;

public class Provider {
    public static void main(String[] args) {

        //本地注册
        LocalRegister localRegister = new LocalRegister();
        localRegister.register(HelloService.class.getName(), HelloService.class);

        //注册中心注册
        ZkRegister zkRegister = new ZkRegister();
        zkRegister.register(HelloService.class.getName(), HelloService.class);

        //启动服务器

        HttpServer httpServer = new HttpServer();
        httpServer.start(9999);
    }
}
