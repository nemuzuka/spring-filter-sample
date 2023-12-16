package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerIntegrationTest {

  @Autowired TestRestTemplate testRestTemplate;

  @Test
  void testCallHello1() {
    var reponse = testRestTemplate.getForObject("/api1/hello1", String.class);
    log.info("response: {}", reponse);
  }

  @Test
  void testCallHello2() {
    var reponse = testRestTemplate.getForObject("/api2/hello2", String.class);
    log.info("response: {}", reponse);
  }
}
