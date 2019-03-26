///**
// * 创建日期 2018年6月14日 下午4:19:36
// *
// * 成都澳乐科技有限公司
// * 电话：028-85253121
// * 传真：028-85253121
// * 邮编：610041
// * 地址：成都市武侯区航空路6号丰德国际C3
// * 版权所有
// */
//package com.overstar.commonbase.job;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 抽象的任务
// *
// * 抽象任务定义结构。各类自定义自己的实现。启动的时候调用分类的公共方法
// *
// * @author Sean.Yang
// *
// */
//public abstract class DataFlowJobTemplate<T> implements DataflowJob {
//
//	/** 任务执行时间表达式 */
//	private String cron;
//	/** 任务分片总数 */
//	private Integer shardingTotalCount;
//	/** 任务分片参数 */
//	private String shardingItemParameters;
//	/** 任务参数 */
//	private String jobParameter;
//	/** 是否已经启动 */
//	private boolean started = false;
//
//	public DataFlowJobTemplate() {
//		super();
//	}
//
//	/**
//	 * 构造函数
//	 *
//	 * @param cron
//	 * @param shardingTotalCount
//	 * @param shardingItemParameters
//	 * @param jobParameter
//	 */
//	public DataFlowJobTemplate(String cron, Integer shardingTotalCount,
//							   String shardingItemParameters, String jobParameter) {
//		super();
//		this.cron = cron;
//		this.shardingTotalCount = shardingTotalCount;
//		this.shardingItemParameters = shardingItemParameters;
//		this.jobParameter = jobParameter;
//	}
//
//	/**
//	 * 启动任务,调用此方法，将启动任务调度
//	 * @param zookeeperRegistryCenter 任务注册中心
//	 */
//	protected synchronized void start(ZookeeperRegistryCenter zookeeperRegistryCenter) {
//		// 保证一个任务只执行一次start
//		if (this.started){
//			return;
//		}
//		this.started = true;
//		SpringJobScheduler s = new SpringJobScheduler(this,
//				zookeeperRegistryCenter, getLiteJobConfiguration());
//		s.init();
//	}
//
//
//	@Override
//	public List fetchData(ShardingContext shardingContext) {
//		List<Object> list = new ArrayList<>();
//		LoggerFactory.getLogger(DataFlowJobTemplate.class).info(String.format("Thread ID:%s,任务总片数:%s," + "当前分片项:%s,当前参数:%s,"
//						+ "当前任务名称:%s,当前任务参数:%s", Thread.currentThread().getId(),
//				shardingContext.getShardingTotalCount(),
//				shardingContext.getShardingItem(),
//				shardingContext.getShardingParameter(),
//				shardingContext.getJobName(), shardingContext.getJobParameter()));
//		try {
//			 list = findTodoJobList(shardingContext);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	@Override
//	public void processData(ShardingContext shardingContext, List list) {
//		setCompleted(shardingContext,list);
//	}
//
//
//	public abstract List findTodoJobList(ShardingContext shardingContext) throws InterruptedException;
//
//	public abstract void setCompleted(ShardingContext shardingContext, List<Object> list);
//
//	/**
//	 * 获取任务配置
//	 * @return
//	 */
//	protected LiteJobConfiguration getLiteJobConfiguration() {
//		return LiteJobConfiguration.newBuilder(new DataflowJobConfiguration(JobCoreConfiguration.newBuilder(
//				this.getClass().getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build(),
//				this.getClass().getCanonicalName(), true)).overwrite(true).build();
//	}
//
//	public String getCron() {
//		return cron;
//	}
//
//	public void setCron(String cron) {
//		this.cron = cron;
//	}
//
//	public Integer getShardingTotalCount() {
//		return shardingTotalCount;
//	}
//
//	public void setShardingTotalCount(Integer shardingTotalCount) {
//		this.shardingTotalCount = shardingTotalCount;
//	}
//
//	public String getShardingItemParameters() {
//		return shardingItemParameters;
//	}
//
//	public void setShardingItemParameters(String shardingItemParameters) {
//		this.shardingItemParameters = shardingItemParameters;
//	}
//
//	/**
//	 * @return the jobParameter
//	 */
//	public String getJobParameter() {
//		return jobParameter;
//	}
//
//	/**
//	 * @param jobParameter
//	 *            the jobParameter to set
//	 */
//	public void setJobParameter(String jobParameter) {
//		this.jobParameter = jobParameter;
//	}
//}
