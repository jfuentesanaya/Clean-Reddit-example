package com.example.repository;

import com.example.Post;
import com.example.exception.BundleError;

import java.util.Collection;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface PostRepository {

    interface PostListCallback {
        void onPostListLoaded(Collection<Post> postCollection);
        void onError(BundleError bundleError);
    }

    void getPostList(PostListCallback callback);
}
