package com.lf.todo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private int code;
    private String error;
    private List<ErrorDetail> errorDetails;
    private Instant timestamp;

    public ErrorResponse(final HttpStatus httpStatus,
                         final List<ErrorDetail> errorDetails,
                         final Clock applicationClock) {
        this.code = httpStatus.value();
        this.error = httpStatus.toString();
        this.errorDetails = errorDetails;
        this.timestamp = Instant.now(applicationClock);
    }
}
