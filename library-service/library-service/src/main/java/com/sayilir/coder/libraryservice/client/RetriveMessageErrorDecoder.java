package com.sayilir.coder.libraryservice.client;

import com.sayilir.coder.libraryservice.exception.BookNotFoundException;
import com.sayilir.coder.libraryservice.exception.ExceptionMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetriveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message;
        try (InputStream body = response.body().asInputStream()) {
            message = new ExceptionMessage((String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(body, StandardCharsets.UTF_8),
                    response.request().url());
        } catch (IOException exception) {
            return new Exception(exception.getMessage());
        }
        switch (response.status()) {
            case 404:
                throw new BookNotFoundException(message);
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }

    /*
    *  private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methoddKey, Response response) {
        ExceptionMessage message;
        try (InputStream body = response.body().asInputStream()) {
            message = new ExceptionMessage((String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(body, StandardCharsets.UTF_8),
                    response.request().url());
        } catch (IOException exception) {
            return new Exception(exception.getMessage());
        }
        switch (response.status()) {
            case 404:
                throw new BookNotFoundException(message);
            default:
                return errorDecoder.decode(methoddKey, response);
        }
    }
    *
    * */
}
