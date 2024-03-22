package com.demo.hanbaguni.loginManageTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class GetValueFromPropertiesTest {
    @Value("${jasypt.encryptor.secretKey}")
    private String secretKey;


    @Test
    public void getTestKeyTest() {
        Assertions.assertThat(secretKey).isNotNull();
        Assertions.assertThat(secretKey).isEqualTo("isthisjwt");
    }
}
