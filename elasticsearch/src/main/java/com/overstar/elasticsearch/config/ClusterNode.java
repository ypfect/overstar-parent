package com.overstar.elasticsearch.config;

/**
 * @Description es节点，方便配置
 * @Author stanley.yu
 * @Date 2019/3/26 23:37
 */
public class ClusterNode {
    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
