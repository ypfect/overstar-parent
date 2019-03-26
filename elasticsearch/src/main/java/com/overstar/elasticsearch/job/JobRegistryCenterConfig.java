/**
 * 创建日期 2018年6月14日 上午11:44:47 
 *
 * 成都澳乐科技有限公司
 * 电话：028-85253121 
 * 传真：028-85253121
 * 邮编：610041 
 * 地址：成都市武侯区航空路6号丰德国际C3
 * 版权所有
 */
package com.overstar.elasticsearch.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.lite.lifecycle.api.JobAPIFactory;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobSettingsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ServerStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ShardingOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ShardingStatisticsAPI;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.google.common.base.Optional;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:29
 */
@Configuration
public class JobRegistryCenterConfig {
	
	@Value("${job.registry.center.address}")
	private String connectString;
	@Value("${job.registry.center.namespace}")
	private String namespace;

	/**
	 * 任务注册中心
	 * @return
	 */
	@Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter() {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(connectString, namespace));
    }
	
	/**
	 * 操作作业API
	 * @return
	 */
	@Bean
	public JobOperateAPI jobOperateAPI(){
		return JobAPIFactory.createJobOperateAPI(connectString, namespace, Optional.<String>absent());
	}
	
	/**
	 * 作业配置API
	 * @return
	 */
	@Bean
	public JobSettingsAPI jobSettingsAPI(){
		return JobAPIFactory.createJobSettingsAPI(connectString, namespace, Optional.<String>absent());
	}
	
	/**
	 * 作业状态展示API
	 * @return
	 */
	@Bean
	public JobStatisticsAPI jobStatisticsAPI(){
		return JobAPIFactory.createJobStatisticsAPI(connectString, namespace, Optional.<String>absent());
	}
	
	/**
	 * 服务器状态展示API
	 * @return
	 */
	@Bean
	public ServerStatisticsAPI serverStatisticsAPI(){
		return JobAPIFactory.createServerStatisticsAPI(connectString, namespace, Optional.<String>absent());
	}
	
	/**
	 * 操作分片API
	 * @return
	 */
	@Bean
	public ShardingOperateAPI shardingOperateAPI(){
		return JobAPIFactory.createShardingOperateAPI(connectString, namespace, Optional.<String>absent());
	}
	
	/**
	 * 作业分片状态展示API
	 * @return
	 */
	@Bean
	public ShardingStatisticsAPI shardingStatisticsAPI(){
		return JobAPIFactory.createShardingStatisticsAPI(connectString, namespace, Optional.<String>absent());
	}
}
