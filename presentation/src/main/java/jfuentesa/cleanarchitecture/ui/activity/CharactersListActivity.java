package jfuentesa.cleanarchitecture.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.Character;

import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.mapper.CharacterModelDataMapper;
import jfuentesa.cleanarchitecture.model.CharacterModel;
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
    public void onCharacterClicked(Character character) {
        navigator.navigateToDetailsCharacter(this, new CharacterModelDataMapper().transform(character));
    }
}
