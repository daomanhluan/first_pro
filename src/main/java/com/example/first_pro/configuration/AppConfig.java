package com.example.first_pro.configuration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

  private final Integer POOL_SIZE = 10;

  @Bean("threadPoolJob")
  public Executor getThreadPoolJob() throws UnknownHostException {
//    int poolSize = Runtime.getRuntime().availableProcessors() * 8 * 8;
    int poolSize = 5;
    return buildTaskExecutor("Thread-pool-run-job-", poolSize);
  }

  @Bean("threadPoo2")
  public Executor getThreadPool2() throws UnknownHostException {
    return buildTaskExecutor("Thread-pool-2-", POOL_SIZE);
  }

  /*Dung cho sleuth*/
  //  @Autowired private BeanFactory beanFactory;

  public Executor buildTaskExecutor(String prefix, int poolSize) throws UnknownHostException {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    InetAddress localhost = InetAddress.getLocalHost();

    executor.initialize();
    executor.setCorePoolSize(poolSize);
    executor.setMaxPoolSize(poolSize);
    executor.setQueueCapacity(100);
    executor.setWaitForTasksToCompleteOnShutdown(true);
    executor.setAllowCoreThreadTimeOut(false);
    executor.setThreadNamePrefix(prefix + localhost.getHostName() + "-");

    return executor;
    /*Dung cho sleuth*/
    //    return new LazyTraceExecutor(beanFactory, executor);
  }
}
