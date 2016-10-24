package com.example.exception;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface BundleError {
    Exception getException();
    String getErrorMessage();
}
