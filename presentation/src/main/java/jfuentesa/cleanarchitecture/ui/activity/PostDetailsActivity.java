package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.model.PostModel;
import jfuentesa.cleanarchitecture.ui.fragment.PostDetailFragment;

public class PostDetailsActivity extends BaseActivity {

    private static final String INTENT_EXTRA_PARAM_ID = "EXTRA_INTENT_ID";
    private static final String INTENT_STATE_PARAM_ID = "STATE_INTEND_ID";

    private PostModel postSelected;

    public static Intent getCallingIntent(Context context, PostModel postSelected){

        Intent callingIntent = new Intent(context, PostDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_ID, postSelected);

        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        initializeActivity(savedInstanceState);

    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putParcelable(INTENT_STATE_PARAM_ID, this.postSelected);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.postSelected = getIntent().getParcelableExtra(INTENT_EXTRA_PARAM_ID);
            addFragment(R.id.post_details_fragment, PostDetailFragment.newInstance(this.postSelected));
        } else {
            this.postSelected = savedInstanceState.getParcelable(INTENT_STATE_PARAM_ID);
        }
    }

}
