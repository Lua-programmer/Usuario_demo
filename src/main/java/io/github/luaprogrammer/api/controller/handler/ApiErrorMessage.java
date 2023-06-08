package io.github.luaprogrammer.api.controller.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
public class ApiErrorMessage {

    private HttpStatusCode status;

    private List<String> errors;

    public ApiErrorMessage(HttpStatusCode status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatusCode status, String error) {
        this.status = status;
        this.errors = List.of(error);
    }
}
