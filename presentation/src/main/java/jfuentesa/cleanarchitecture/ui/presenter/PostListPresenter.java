package jfuentesa.cleanarchitecture.ui.presenter;

import com.example.Post;
import com.example.data.PostDataRepository;
import com.example.data.entity.mapper.PostEntityDataMapper;
import com.example.data.executor.JobExecutor;
import com.example.data.repository.post.PostDataStoreFactory;
import com.example.exception.BundleError;
import com.example.interactor.GetPostsListUseCase;
import com.example.interactor.GetPostsListUseCaseImp;

import java.util.Collection;

import jfuentesa.cleanarchitecture.ui.view.PostsListView;
import timber.log.Timber;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class PostListPresenter extends PresenterBaseImp<PostsListView> implements GetPostsListUseCase.GetPostsListUseCaseCallback {

    private final GetPostsListUseCase getPostsListUseCase;

    public PostListPresenter(PostsListView mvpViewBase, PostDataStoreFactory postDataStoreFactory) {
        super(mvpViewBase);

        this.getPostsListUseCase = new GetPostsListUseCaseImp(PostDataRepository.getInstance(postDataStoreFactory, new PostEntityDataMapper()), JobExecutor.getInstance());
    }

    public void initialize() {
        this.loadPostList();
    }

    private void loadPostList() {
        this.showViewLoading();
        this.getPostList();
    }

    private void showViewLoading() {
        if(isViewAttached()){
            getView().showLoading();
        }
    }

    private void hideViewLoading() {
        if(isViewAttached()){
            getView().hideLoading();
        }
    }

    private void getPostList() {
        this.getPostsListUseCase.execute(this);
    }

    public void onPostClicked(Post post){
        if(isViewAttached()) {
            getView().viewPostDetails(post);
        }
    }


    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void destroy() { }

    @Override
    public void onPostPostList(Collection<Post> postCollection) {
        getView().renderList(postCollection);
        hideViewLoading();
    }

    @Override
    public void onErrorPostList(BundleError bundleError) {
        Timber.e(bundleError.getErrorMessage());
        hideViewLoading();
        getView().showError(bundleError.getErrorMessage());
    }
}
