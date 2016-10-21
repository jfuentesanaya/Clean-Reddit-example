package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.ui.base.BaseActivity;

public class CharactersListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public static Intent getCallingIntent(Context context){
        return new Intent(context, CharactersListActivity.class);
    }
}
