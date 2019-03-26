package com.overstar.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Description elasticsearch 核心配置，集群配置
 * @Author stanley.yu
 * @Date 2019/3/26 23:35
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch.conf")
public class ElasticCoreConfig {

    private String clusterName;
    private List<ClusterNode> nodes;

    @Bean(destroyMethod = "close")
    public TransportClient esClusterConfig() throws UnknownHostException {
        Settings settings = Settings.builder().put("client.transport.sniff", true).put("cluster.name", clusterName).build();
        TransportClient transportClient = new PreBuiltTransportClient(settings);
        for (final ClusterNode node : nodes) {
            transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(node.getHost()),node.getPort()));
        }
        return transportClient;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public List<ClusterNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ClusterNode> nodes) {
        this.nodes = nodes;
    }
}
