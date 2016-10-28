package com.example.interactor;

import com.example.Post;
import com.example.exception.BundleError;
import com.example.executor.ThreadExecutor;
import com.example.repository.PostRepository;

import java.util.Collection;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class GetPostsListUseCaseImp implements GetPostsListUseCase, PostRepository.PostListCallback {

    private PostRepository postRepository;

    private GetPostsListUseCaseCallback callback;
    private ThreadExecutor threadExecutor;

    public GetPostsListUseCaseImp(PostRepository postRepository, ThreadExecutor threadExecutor) {
        if(postRepository == null){
            throw new IllegalArgumentException("Parameter can not be null");
        }


        this.threadExecutor = threadExecutor;
        this.postRepository = postRepository;
    }

    @Override
    public void execute(GetPostsListUseCaseCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null");
        }
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        postRepository.getPostList(this);
    }

    @Override
    public void onPostListLoaded(Collection<Post> postCollection) {
        callback.onPostPostList(postCollection);
    }

    @Override
    public void onError(BundleError bundleError) {
        callback.onErrorPostList(bundleError);
    }
}
