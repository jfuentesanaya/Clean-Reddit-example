package jfuentesa.cleanarchitecture.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.Post;
import com.example.data.repository.post.PostDataStoreFactory;

import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.ui.adapter.PostAdapter;
import jfuentesa.cleanarchitecture.ui.presenter.PostListPresenter;
import jfuentesa.cleanarchitecture.ui.view.PostsListView;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public class PostListFragment extends BaseFragment implements PostsListView, SwipeRefreshLayout.OnRefreshListener{

    /**
     * Interface for listening user list events.
     */
    public interface PostListListener {
        void onPostClicked(final Post post);
    }

    @BindView(R.id.fragm_char_list_rv_postList)
    RecyclerView rv_posts;

    @BindView(R.id.fragm_char_list_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PostListPresenter postListPresenter;
    private PostAdapter postAdapter;
    private PostListListener postListListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof PostListListener) {
            this.postListListener = (PostListListener) activity;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (activity instanceof PostListListener) {
                this.postListListener = (PostListListener) activity;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.fragment_post_list, container, false);
        ButterKnife.bind(this,fragmentView);

        postListPresenter = new PostListPresenter(this,new PostDataStoreFactory(getContext()));
        setupRecyclerView();
        return fragmentView;
    }

    private void setupRecyclerView() {
        postAdapter = new PostAdapter();
        postAdapter.setOnItemClickListener(onItemClickListener);
        rv_posts.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_posts.setAdapter(postAdapter);
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.postListPresenter.initialize();
        swipeRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String message) {
        this.showDialogErrorMessage();
        if(swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
//        this.showToastMessage(message);
    }

    @Override
    public Context getContext() {
        return this.getActivity().getApplicationContext();
    }

    @Override public void onResume() {
        super.onResume();
        this.postListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.postListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        if(postListPresenter != null){
            postListPresenter.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void renderList(Collection<Post> postCollection) {
        if(postCollection != null){
            postAdapter.setPostCollection(postCollection);
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void viewPostDetails(Post post) {
        if (this.postListListener != null) {
            this.postListListener.onPostClicked(post);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_order_by_title) {
            ((PostAdapter) rv_posts.getAdapter()).orderByTitle();
            return true;
        }else if(id == R.id.action_order_by_date){
            ((PostAdapter) rv_posts.getAdapter()).orderByDate();
            return true;
        }else if(id == R.id.action_order_by_author){
            ((PostAdapter) rv_posts.getAdapter()).orderByAuthor();
            return true;
        }
        return false;
    }

    @Override
    public void onRefresh() {
        postListPresenter.initialize();
    }

    private final PostAdapter.OnItemClickListener onItemClickListener = new PostAdapter.OnItemClickListener() {
        @Override
        public void onPostItemClicked(Post post) {
            if (postListPresenter != null && post != null) {
                postListPresenter.onPostClicked(post);
            }
        }
    };
}
