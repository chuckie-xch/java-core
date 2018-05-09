package com.bestcode.source.dubbo.common;

import java.util.Map;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class URL {

    private final String protocol;
    private final String username;
    private final String password;
    private final String host;
    private final int port;
    private final String path;
    private final Map<String,String> parameters;

    public URL(String protocol, String username, String password, String host, int port, String path, Map<String,
            String> parameters) {
        this.protocol = protocol;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.path = path;
        this.parameters = parameters;
    }

    public String getMethodParameter(String methodName, String key, String defaultValue) {
        String value = getMethodParameter(methodName,key);
        if (value == null || value.length() == 0) {
            return defaultValue;
        }
        return value;
    }

    public String getMethodParameter(String methodName, String key) {
        String value = parameters.get(methodName + "." + key);
        if (value == null || value.length() == 0) {
            return getParameter(key);
        }
        return value;
    }


    public String getParameter(String key) {
        String value = parameters.get(key);
        if (value == null || value.length() == 0) {
            return parameters.get(Constants.DEFAULT_PREFIX_KEY + key);
        }
        return value;
    }
}
