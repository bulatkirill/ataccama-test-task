package com.ataccama.test.testtask.model.exception;

public class UnsupportedProviderException extends Exception {

    private static final String DEFAULT_MESSAGE = "Specified database provider is unsupported.";

    public UnsupportedProviderException() {
        super(DEFAULT_MESSAGE);
    }

    public UnsupportedProviderException(String message) {
        super(message == null ? DEFAULT_MESSAGE : message);
    }
}
