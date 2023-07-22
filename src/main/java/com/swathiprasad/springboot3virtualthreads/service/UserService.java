package com.swathiprasad.springboot3virtualthreads.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public void updateUsers() {
        //try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                try {
                    executorService.submit(() -> {
                        try {
                            log.info("Update user {} using thread {}", finalI, Thread.currentThread().toString());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            log.error(e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

}
