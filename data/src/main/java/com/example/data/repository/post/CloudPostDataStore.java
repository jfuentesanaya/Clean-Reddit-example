package com.example.data.repository.post;

import com.example.data.entity.ListEntity;
import com.example.data.net.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jfuentesa on 24/10/2016.
 */

class CloudPostDataStore implements PostDataStore {

    private RestApi restApi;

    CloudPostDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void loadPosts(final LoadDataCallback callback) {
        restApi.getPostList().enqueue(new Callback<ListEntity>() {
            @Override
            public void onResponse(Call<ListEntity> call, Response<ListEntity> response) {
                ListEntity dataEntity = response.body();

                callback.onDataLoaded(dataEntity.parseListToPostList());
            }

            @Override
            public void onFailure(Call<ListEntity> call, Throwable t) {
                callback.onError((Exception)t);
            }
        });
    }
}
