package com.example.executor;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface ThreadExecutor {

    void execute(final Runnable runnable);
}
