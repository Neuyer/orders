package com.neuyer.orders.core.usecase;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldUseCase {

    public String execute() {
        return "Hello world!";
    }
}
