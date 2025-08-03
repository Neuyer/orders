package com.neuyer.orders.infra.controller;

import com.neuyer.orders.core.usecase.HelloWorldUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orders/v1/hello-world")
public class HelloWorldController {

    private final HelloWorldUseCase helloWorldUseCase;

    public HelloWorldController(HelloWorldUseCase helloWorldUseCase) {
        this.helloWorldUseCase = helloWorldUseCase;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(helloWorldUseCase.execute());
    }
}
