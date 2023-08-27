package com.example.first_pro.jobs;

import com.example.first_pro.util.CompletableFutureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Component
@Slf4j
public class TestJob implements JobTemplate {

  @Qualifier("threadPoolJob")
  @Autowired
  private Executor executor;

  @Autowired private CompletableFutureUtil completableFutureUtil;

  @Scheduled(cron = "0/10 * * * * *", zone = "Asia/Saigon")
  @Override
  public void process() throws InterruptedException {

    List<CompletableFuture<Integer>> allCompleteFuture = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      int temp = i;
      CompletableFuture<Integer> res =
          CompletableFuture.supplyAsync(() -> runThisLogic(temp, LocalTime.now()), executor);
      allCompleteFuture.add(res);
    }
    List<Integer> res = completableFutureUtil.getAllCompleted(allCompleteFuture);
    log.info(res.toString());
  }

  public int runThisLogic(int stt, LocalTime localTime) {
    try {
      log.info("{} Start job {}: {}", Thread.currentThread().getName(), stt, localTime);
      Thread.sleep(5000);
      log.info("{} End job {}: {}", Thread.currentThread().getName(), stt, LocalTime.now());
    } catch (Exception e) {
    }
    return stt * stt;
  }
}
