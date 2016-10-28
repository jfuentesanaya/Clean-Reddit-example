package jfuentesa.cleanarchitecture.navigator;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import jfuentesa.cleanarchitecture.model.PostModel;
import jfuentesa.cleanarchitecture.ui.activity.PostDetailsActivity;
import jfuentesa.cleanarchitecture.ui.activity.PostListActivity;

/**
 * Created by jfuentesa on 21/10/2016.
 */

@Singleton
public class Navigator {

    @Inject
    Navigator () {}

    public void navigateToList(Context context){
        if(context != null){
            context.startActivity(PostListActivity.getCallingIntent(context));
        }
    }

    public void navigateToPostDetails(Context context, PostModel postSelected){
        if(context != null){
            context.startActivity(PostDetailsActivity.getCallingIntent(context, postSelected));
        }
    }
}
