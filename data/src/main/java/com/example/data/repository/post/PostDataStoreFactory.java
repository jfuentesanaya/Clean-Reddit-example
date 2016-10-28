package com.example.data.repository.post;

import android.content.Context;

import com.example.data.net.RestApi;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class PostDataStoreFactory {

    private final Context context;

    public PostDataStoreFactory(Context context) {
        this.context = context;
    }

    public PostDataStore createCloudCountryDataStore(){
        RestApi restApi = RestApi.Creator.restApiImpl(context);
        return new CloudPostDataStore(restApi);
    }
}
