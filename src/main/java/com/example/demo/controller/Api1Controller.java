package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Api1Controller {

  @GetMapping("/api1/hello1")
  public String hello1() {
    log.info("called Api1Controller.");
    return "ok";
  }
}
