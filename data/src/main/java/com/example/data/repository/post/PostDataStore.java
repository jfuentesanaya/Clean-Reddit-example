package com.example.data.repository.post;

import com.example.data.entity.PostEntity;

import java.util.List;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface PostDataStore {

    interface LoadDataCallback {
        void onDataLoaded(List<PostEntity> postList);
        void onError(Exception e);
    }

    void loadPosts(LoadDataCallback callback);
}
