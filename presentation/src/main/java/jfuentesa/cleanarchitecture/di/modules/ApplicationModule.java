package jfuentesa.cleanarchitecture.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jfuentesa.cleanarchitecture.CleanArchitectureApplication;

/**
 * Created by jfuentesa on 21/10/2016.
 */

@Module
public class ApplicationModule {

    private final CleanArchitectureApplication cleanArchitectureApplication;

    public ApplicationModule(CleanArchitectureApplication cleanArchitectureApplication) {
        this.cleanArchitectureApplication = cleanArchitectureApplication;
    }

    @Provides
    @Singleton
    Context provideContest(){
        return cleanArchitectureApplication.getApplicationContext();
    }
}
