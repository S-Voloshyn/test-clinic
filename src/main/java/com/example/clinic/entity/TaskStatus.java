package com.example.clinic.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TaskStatus {

    ACTIVE("Active"), COMPLETED("Completed");

    final String name;
}
