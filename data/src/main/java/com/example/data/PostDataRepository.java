package com.example.data;

import com.example.data.entity.PostEntity;
import com.example.data.entity.mapper.PostEntityDataMapper;
import com.example.data.exception.RepositoryErrorBundle;
import com.example.data.repository.post.PostDataStore;
import com.example.data.repository.post.PostDataStoreFactory;
import com.example.repository.PostRepository;

import java.util.List;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class PostDataRepository implements PostRepository, PostDataStore.LoadDataCallback {

    private static PostDataRepository INSTANCE;
    private PostListCallback postListCallback;

    public static synchronized PostDataRepository getInstance(PostDataStoreFactory postDataStoreFactory, PostEntityDataMapper postEntityDataMapper) {
        if(INSTANCE == null){
            INSTANCE = new PostDataRepository(postDataStoreFactory, postEntityDataMapper);
        }

        return INSTANCE;
    }

    private final PostDataStoreFactory postDataStoreFactory;
    private final PostEntityDataMapper postEntityDataMapper;

    PostDataRepository(PostDataStoreFactory postDataStoreFactory, PostEntityDataMapper postEntityDataMapper) {
        this.postDataStoreFactory = postDataStoreFactory;
        this.postEntityDataMapper = postEntityDataMapper;
    }

    @Override
    public void getPostList(final PostListCallback callback) {

        PostDataStore cloudPostDataStore = postDataStoreFactory.createCloudCountryDataStore();
        this.postListCallback = callback;

        cloudPostDataStore.loadPosts(this);

    }

    @Override
    public void onDataLoaded(List<PostEntity> postList) {
        this.postListCallback.onPostListLoaded(postEntityDataMapper.transform(postList));
    }

    @Override
    public void onError(Exception e) {
        this.postListCallback.onError(new RepositoryErrorBundle(e));
    }
}
