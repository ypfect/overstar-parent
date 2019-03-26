package com.overstar.elasticsearch.bean;

import org.elasticsearch.cluster.health.ClusterIndexHealth;

import java.util.Collection;

public class ClusterHealth {
	private String clusterName;
	private int numberOfDataNodes;
	private int numberOfNodes;
	private Collection<ClusterIndexHealth> indexHealths;

	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public int getNumberOfDataNodes() {
		return numberOfDataNodes;
	}
	public void setNumberOfDataNodes(int numberOfDataNodes) {
		this.numberOfDataNodes = numberOfDataNodes;
	}
	public int getNumberOfNodes() {
		return numberOfNodes;
	}
	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}
	public Collection<ClusterIndexHealth> getIndexHealths() {
		return indexHealths;
	}
	public void setIndexHealths(Collection<ClusterIndexHealth> indexHealths) {
		this.indexHealths = indexHealths;
	}
	@Override
	public String toString() {
		return "ClusterHealth [clusterName=" + clusterName + ", numberOfDataNodes=" + numberOfDataNodes + ", numberOfNodes=" + numberOfNodes + ", indexHealths="
				+ indexHealths + "]";
	}

}
