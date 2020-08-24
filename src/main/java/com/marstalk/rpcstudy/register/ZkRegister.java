package com.marstalk.rpcstudy.register;

import org.I0Itec.zkclient.ZkClient;

/**
 * Local registry
 *
 * @author jiacheng524@live.cn
 */
public class ZkRegister implements Register {


    @Override
    public void register(String serviceName, Class clazz) {
        ZkClient zkClient = new ZkClient("localhost:2183");
        zkClient.createEphemeral("/rpcstudy/" + serviceName + "/provider" + "/localhost:9999");
    }
}
