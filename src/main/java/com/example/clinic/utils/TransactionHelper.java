package com.example.clinic.utils;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionHelper {

    //TODO need consider about Isolation level or Lock
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void withTransaction(Runnable runnable) {
        runnable.run();
    }
}
