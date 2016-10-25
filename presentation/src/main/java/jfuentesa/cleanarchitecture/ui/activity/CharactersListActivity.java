package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.Character;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.mapper.CharacterModelDataMapper;
import jfuentesa.cleanarchitecture.ui.fragment.CharactersListFragment;

public class CharactersListActivity extends BaseActivity implements CharactersListFragment.CharacterListListener {

    public static Intent getCallingIntent(Context context){
        return new Intent(context, CharactersListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_list);

        addFragment(R.id.char_list_layoutFragmentContainer, new CharactersListFragment());
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
    public void onCharacterClicked(Character character) {
        navigator.navigateToDetailsCharacter(this, new CharacterModelDataMapper().transform(character));
    }
}
