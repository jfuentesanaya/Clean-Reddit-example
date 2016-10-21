package jfuentesa.cleanarchitecture.ui.activity;

import android.os.Bundle;

import butterknife.OnClick;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.main_btn_enter)
    void navigateToList(){
        navigator.navigateToCharactersList(this);
    }
}
