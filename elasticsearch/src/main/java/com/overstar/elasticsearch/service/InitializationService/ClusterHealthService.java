package com.overstar.elasticsearch.service.InitializationService;

import com.overstar.elasticsearch.bean.ClusterHealth;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 健康监测
 */
@Service
public class ClusterHealthService {

	@Autowired
	private TransportClient transportClient;

	public ClusterHealth clusterHealth() {
		ClusterHealth result = new ClusterHealth();
		ClusterHealthResponse healths = transportClient.admin().cluster().prepareHealth().get();
		result.setClusterName(healths.getClusterName());
		result.setNumberOfDataNodes(healths.getNumberOfDataNodes());
		result.setNumberOfNodes(healths.getNumberOfNodes());
		result.setIndexHealths(healths.getIndices().values());
		return result;
	}

}
