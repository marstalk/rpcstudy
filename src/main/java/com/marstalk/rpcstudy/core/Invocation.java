package com.marstalk.rpcstudy.core;

public class Invocation {
    private String serviceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

    public Invocation(String serviceName, String methodName, Class[] paramTypes, Object[] params) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
