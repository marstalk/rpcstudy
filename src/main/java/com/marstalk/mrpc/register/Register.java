package com.marstalk.mrpc.register;

import com.marstalk.mrpc.core.URL;

import java.util.List;

/**
 * @author jiacheng524@live.cn
 */
public interface Register {
    void register(String serviceName, Class clazz);

    List<URL> getUrls(String servicename);
}
