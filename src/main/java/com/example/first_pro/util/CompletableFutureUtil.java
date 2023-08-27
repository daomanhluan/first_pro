package com.example.first_pro.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CompletableFutureUtil {

  private int TIME_OUT = 5000;

  public <T> List<T> getAllCompleted(List<CompletableFuture<T>> futuresList) {

    CompletableFuture<Void> allFuturesResult =
        CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
    try {
      allFuturesResult.get(TIME_OUT, TimeUnit.SECONDS);
    } catch (Exception e) {
      log.error("CompletableFutureUtils", e);
    }
    return futuresList.stream()
        .filter(future -> future.isDone() && !future.isCompletedExceptionally())
        .map(CompletableFuture::join)
        .collect(Collectors.<T>toList());
  }
}
