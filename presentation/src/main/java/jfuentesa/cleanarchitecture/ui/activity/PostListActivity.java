package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.Post;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.mapper.PostModelDataMapper;
import jfuentesa.cleanarchitecture.ui.fragment.PostListFragment;

public class PostListActivity extends BaseActivity implements PostListFragment.PostListListener {

    public static Intent getCallingIntent(Context context){
        return new Intent(context, PostListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        addFragment(R.id.post_list_layoutFragmentContainer, new PostListFragment());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.order_by, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onPostClicked(Post post) {
        navigator.navigateToPostDetails(this, new PostModelDataMapper().transform(post));
    }
}
