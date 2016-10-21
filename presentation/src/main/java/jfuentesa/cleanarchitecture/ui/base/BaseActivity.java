package jfuentesa.cleanarchitecture.ui.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.CleanArchitectureApplication;
import jfuentesa.cleanarchitecture.di.components.ApplicationComponent;
import jfuentesa.cleanarchitecture.navigator.Navigator;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewBase {

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getApplicationComponent().inject(this);
    }

    public ApplicationComponent getApplicationComponent(){
        return ((CleanArchitectureApplication)getApplication()).getApplicationComponent();
    }

    protected void addFragment(int containerViewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId,fragment);
        fragmentTransaction.commit();
    }

}
