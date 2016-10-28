package com.example.interactor;

import com.example.Post;
import com.example.exception.BundleError;

import java.util.Collection;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public interface GetPostsListUseCase extends Interactor {

    interface GetPostsListUseCaseCallback {
        void onPostPostList(Collection<Post> postCollection);
        void onErrorPostList(BundleError bundleError);
    }

    void execute(GetPostsListUseCaseCallback callback);
}
