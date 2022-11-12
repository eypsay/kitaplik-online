package com.sayilir.coder.libraryservice;

import com.sayilir.coder.libraryservice.client.RetriveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryServiceApplication.class, args);
    }
/*
    // bURASI FALLBACK SENARYASU
    // FEIGN CLİENT ERROR NANDLING
    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetriveMessageErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
*/

    //BURASI FAULTTOLARANCE SENARYASU




}
