package com.shopion.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class indexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void indexLoad() {
        String body = restTemplate.getForObject("/", String.class);

        assertThat(body).contains("Spring Boot Web Service");
    }
}
