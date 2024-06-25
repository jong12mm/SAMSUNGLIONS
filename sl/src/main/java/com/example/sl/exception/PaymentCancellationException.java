package com.example.sl.exception;

public class PaymentCancellationException extends RuntimeException {
    public PaymentCancellationException(String message, Exception cause) {
        super(message, cause);
    }

}
