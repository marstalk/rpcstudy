package com.marstalk.mrpc.core;

public class URL {

    private String hostAndPort;

    public URL(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public String getHostAndPort() {
        return hostAndPort;
    }

    public void setHostAndPort(String hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

}
