package com.marstalk.mrpc.register.zk;

import com.marstalk.mrpc.core.URL;
import com.marstalk.mrpc.register.Register;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Local registry
 *
 * @author jiacheng524@live.cn
 */
public class ZkRegister implements Register {

    private static final ZkConnection zkConnection = new ZkConnection("localhost:2181");
    private static final ZkClient zkClient = new ZkClient(zkConnection);
    private static final String ROOT_RPC = "/mrpc";
    private static final String PROVIDER = "/provider";

    static {
        boolean exists = zkClient.exists(ROOT_RPC);
        if (!exists) {
            zkClient.createPersistent(ROOT_RPC);
        }
    }

    @Override
    public void register(String serviceName, Class clazz) {
        String serviceNode = ROOT_RPC + "/" + serviceName;
        if (!zkClient.exists(serviceNode)) {
            zkClient.createPersistent(serviceNode);
        }

        String providerNode = serviceNode + PROVIDER;
        if (!zkClient.exists(providerNode)) {
            zkClient.createPersistent(providerNode);
        }
        try {
            InetAddress localHost = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String instanceNode = providerNode + "/localhost:9999";
        zkClient.createEphemeral(instanceNode);
    }

    @Override
    public List<URL> getUrls(String servicename) {
        String providerNode = ROOT_RPC + "/" + servicename + PROVIDER;
        if (!zkClient.exists(providerNode)) {
            return null;
        }
        List<String> children = zkClient.getChildren(providerNode);
        List<URL> urls = children.stream().map(s -> new URL(s)).collect(Collectors.toList());
        return urls;
    }

}
