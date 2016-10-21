package jfuentesa.cleanarchitecture;

import android.app.Application;

import jfuentesa.cleanarchitecture.di.components.ApplicationComponent;
import jfuentesa.cleanarchitecture.di.components.DaggerApplicationComponent;
import jfuentesa.cleanarchitecture.di.modules.ApplicationModule;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public class CleanArchitectureApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
