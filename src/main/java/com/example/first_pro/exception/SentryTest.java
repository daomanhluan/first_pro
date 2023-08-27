package com.example.first_pro.exception;

import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class SentryTest {

  @PostConstruct
  public void init() {
    try {
      log.info("Init sentry");
      throw new Exception("This is a test Sentry.");
    } catch (Exception e) {
      Sentry.captureException(e);
    }
  }
}
