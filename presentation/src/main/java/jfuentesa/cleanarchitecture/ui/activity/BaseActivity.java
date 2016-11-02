package jfuentesa.cleanarchitecture.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.navigator.Navigator;
import jfuentesa.cleanarchitecture.ui.view.ViewBase;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewBase {

    protected Navigator navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getApplicationComponent().inject(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        navigator = Navigator.getInstance();
    }

//    public ApplicationComponent getApplicationComponent(){
//        return ((CleanArchitectureApplication)getApplication()).getApplicationComponent();
//    }

    protected void addFragment(int containerViewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId,fragment);
        fragmentTransaction.commit();
    }
}
