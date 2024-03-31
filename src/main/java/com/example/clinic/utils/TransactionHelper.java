package com.example.clinic.utils;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionHelper {

    @Transactional()
    public void withTransaction(Runnable runnable) {
        runnable.run();
    }
}
