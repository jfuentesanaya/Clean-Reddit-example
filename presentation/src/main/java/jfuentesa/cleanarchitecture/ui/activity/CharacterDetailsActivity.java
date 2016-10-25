package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.model.CharacterModel;
import jfuentesa.cleanarchitecture.ui.fragment.CharacterDetailFragment;

public class CharacterDetailsActivity extends BaseActivity {

    private static final String INTENT_EXTRA_PARAM_ID = "EXTRA_INTENT_ID";
    private static final String INTENT_STATE_PARAM_ID = "STATE_INTEND_ID";

    private CharacterModel characterSelected;

    public static Intent getCallingIntent(Context context, CharacterModel characterSelected){

        Intent callingIntent = new Intent(context, CharacterDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_ID, characterSelected);

        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        initializeActivity(savedInstanceState);

    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putParcelable(INTENT_STATE_PARAM_ID, this.characterSelected);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.characterSelected = getIntent().getParcelableExtra(INTENT_EXTRA_PARAM_ID);
            addFragment(R.id.char_details_fragment, CharacterDetailFragment.newInstance(this.characterSelected));
        } else {
            this.characterSelected = savedInstanceState.getParcelable(INTENT_STATE_PARAM_ID);
        }
    }

}
