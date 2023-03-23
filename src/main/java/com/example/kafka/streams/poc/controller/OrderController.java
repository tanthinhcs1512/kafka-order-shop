package com.example.kafka.streams.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/create")
    public void createOrder(@RequestParam Integer orderCount) {

    }
}
