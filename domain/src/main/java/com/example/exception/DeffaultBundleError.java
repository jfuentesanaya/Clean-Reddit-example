package com.example.exception;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class DeffaultBundleError implements BundleError {

    private static final String DEFAULT_ERROR_MSG = "Unknown Error";
    private final Exception exception;

    public DeffaultBundleError(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception != null) ? exception.getMessage() : DEFAULT_ERROR_MSG;
    }
}
