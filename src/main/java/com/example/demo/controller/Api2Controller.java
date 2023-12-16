package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Api2Controller {

  @GetMapping("/api2/hello2")
  public String hello2() {
    log.info("called Api2Controller.");
    return "ok";
  }
}
