package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jfuentesa.cleanarchitecture.R;

public class CharacterDetailsActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context context){
        return new Intent(context, CharacterDetailsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
    }
}
