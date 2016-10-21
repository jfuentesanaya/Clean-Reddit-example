package jfuentesa.cleanarchitecture.navigator;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import jfuentesa.cleanarchitecture.ui.activity.CharactersListActivity;

/**
 * Created by jfuentesa on 21/10/2016.
 */

@Singleton
public class Navigator {

    @Inject
    Navigator () {}

    public void navigateToCharactersList(Context context){
        if(context != null){
            context.startActivity(CharactersListActivity.getCallingIntent(context));
        }
    }
}
