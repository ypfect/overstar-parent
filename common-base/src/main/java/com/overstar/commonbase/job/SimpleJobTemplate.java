package com.overstar.commonbase.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 23:24
 */
public abstract class SimpleJobTemplate implements SimpleJob {
    Logger LOG = LoggerFactory.getLogger("job");
    /** 任务执行时间表达式 */
    private String cron;
    /** 任务分片总数 */
    private Integer shardingTotalCount;
    /** 任务分片参数 */
    private String shardingItemParameters;
    /** 任务参数 */
    private String jobParameter;
    /** 是否已经启动 */
    private boolean started = false;

    public SimpleJobTemplate(String cron, Integer shardingTotalCount, String shardingItemParameters, String jobParameter) {
        super();
        this.cron = cron;
        this.shardingTotalCount = shardingTotalCount;
        this.shardingItemParameters = shardingItemParameters;
        this.jobParameter = jobParameter;
    }

    /**
     * 启动任务,调用此方法，将启动任务调度
     * @param zookeeperRegistryCenter 任务注册中心
     */
    protected synchronized void start(ZookeeperRegistryCenter zookeeperRegistryCenter) {
        // 保证一个任务只执行一次start
        if (this.started){
            return;
        }
        this.started = true;
        SpringJobScheduler s = new SpringJobScheduler(this,
                zookeeperRegistryCenter, getLiteJobConfiguration());
        s.init();
    }

    protected  abstract void executeJob(Integer shardingTotalCount,
                                              Integer shardingItem, String itemParameter, String jobParameter);

    @Override
    public void execute(ShardingContext shardingContext) {
        LOG.info(String.format("Thread ID :%s,shardTotal :%s," + "current shard:%s,current params:%s,"
                        + "current job name:%s,current job param:%s", Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(), shardingContext.getJobParameter()));
        executeJob(shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobParameter());
    }

    /**
     * 获取任务配置
     * @return
     */
    protected LiteJobConfiguration getLiteJobConfiguration() {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(
                this.getClass().getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build(),
                this.getClass().getCanonicalName())).overwrite(true).build();
    }


    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Integer getShardingTotalCount() {
        return shardingTotalCount;
    }

    public void setShardingTotalCount(Integer shardingTotalCount) {
        this.shardingTotalCount = shardingTotalCount;
    }

    public String getShardingItemParameters() {
        return shardingItemParameters;
    }

    public void setShardingItemParameters(String shardingItemParameters) {
        this.shardingItemParameters = shardingItemParameters;
    }

    public String getJobParameter() {
        return jobParameter;
    }

    public void setJobParameter(String jobParameter) {
        this.jobParameter = jobParameter;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

}
