package com.marstalk.mrpc.provider;

import com.marstalk.mrpc.protocol.http.HttpServer;
import com.marstalk.mrpc.register.LocalRegister;
import com.marstalk.mrpc.register.zk.ZkRegister;
import com.marstalk.mrpc.service.HelloService;
import com.marstalk.mrpc.service.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) {

        //本地注册
        LocalRegister localRegister = new LocalRegister();
        localRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //注册中心注册
        ZkRegister zkRegister = new ZkRegister();
        zkRegister.register(HelloService.class.getName(), HelloService.class);

        //启动服务器
        HttpServer httpServer = new HttpServer();
        httpServer.start(9999);
    }
}
