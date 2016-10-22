package jfuentesa.cleanarchitecture.di.components;

import javax.inject.Singleton;

import dagger.Component;
import jfuentesa.cleanarchitecture.di.modules.ApplicationModule;
import jfuentesa.cleanarchitecture.ui.activity.BaseActivity;

/**
 * Created by jfuentesa on 21/10/2016.
 */

@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity activity);
}
