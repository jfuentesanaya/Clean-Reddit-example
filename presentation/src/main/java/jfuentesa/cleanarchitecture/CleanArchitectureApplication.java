package jfuentesa.cleanarchitecture;

import android.app.Application;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public class CleanArchitectureApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initializeTimber();
        initializeStetho();
    }

    private void initializeTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeStetho(){
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
