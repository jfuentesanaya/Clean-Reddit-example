package com.example.data.exception;

import com.example.exception.BundleError;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class RepositoryErrorBundle implements BundleError {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if(this.exception != null){
            message = this.exception.getMessage();
        }
        return message;
    }
}
