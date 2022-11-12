package com.sayilir.coder.libraryservice.client;

import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeingClientConfiguration {

 /*   private final ObjectFactory<HttpMessageConverters> messageConverterObjectFactory;

    public FeingClientConfiguration(ObjectFactory<HttpMessageConverters> messageConverterObjectFactory) {
        this.messageConverterObjectFactory = messageConverterObjectFactory;
    }

    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new RetreiveMessageErrorDecoder(
                new ResponseEntityDecoder(
                        (new SpringDecoder(messageConverterObjectFactory))));
    }
*/

}
