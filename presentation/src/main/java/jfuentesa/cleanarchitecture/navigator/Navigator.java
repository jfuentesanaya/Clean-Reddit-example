package jfuentesa.cleanarchitecture.navigator;

import android.content.Context;

import jfuentesa.cleanarchitecture.model.PostModel;
import jfuentesa.cleanarchitecture.ui.activity.PostDetailsActivity;
import jfuentesa.cleanarchitecture.ui.activity.PostListActivity;

/**
 * Created by jfuentesa on 21/10/2016.
 */


public class Navigator {
    private static Navigator navigator;

    private Navigator () {}


    public static synchronized Navigator getInstance() {
        if (navigator == null) {
            navigator = new Navigator();
        }
        return navigator;
    }


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
