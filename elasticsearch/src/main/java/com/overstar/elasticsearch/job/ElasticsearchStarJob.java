package com.overstar.elasticsearch.job;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.overstar.commonbase.job.SimpleJobTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:29
 */
@Component
public class ElasticsearchStarJob extends SimpleJobTemplate {

	private static final Logger log = LoggerFactory.getLogger("job");

	@Autowired
	private ZookeeperRegistryCenter zookeeperRegistryCenter;

	public ElasticsearchStarJob(
			@Value("${job.es.goods.cron}") String cron,
			@Value("${job.es.goods.shardingTotalCount}") Integer shardingTotalCount,
			@Value("${job.es.goods.shardingItemParameters}") String shardingItemParameters,
			@Value("${job.es.goods.jobParameter}") String jobParameter) {
		super(cron, shardingTotalCount, shardingItemParameters, jobParameter);
	}

	@PostConstruct
	public void init() {
		start(zookeeperRegistryCenter);
	}

	@Override
	public void executeJob(Integer shardingTotalCount, Integer shardingItem,
			String itemParameter, String jobParameter) {
		log.info("起价任务执行开始，计算全平台所有产品起价");
		System.out.println("***************************************************");
		log.info("起价任务执行结束，计算全平台所有产品起价");
	}

}
