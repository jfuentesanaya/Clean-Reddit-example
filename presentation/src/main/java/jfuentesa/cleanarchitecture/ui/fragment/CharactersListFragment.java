package jfuentesa.cleanarchitecture.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.Character;
import com.example.data.repository.character.CharacterDataStoreFactory;

import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.ui.adapter.CharacterAdapter;
import jfuentesa.cleanarchitecture.ui.presenter.CharactersListPresenter;
import jfuentesa.cleanarchitecture.ui.view.CharactersListView;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public class CharactersListFragment extends BaseFragment implements CharactersListView{

    /**
     * Interface for listening user list events.
     */
    public interface CharacterListListener {
        void onCharacterClicked(final Character character);
    }

    @BindView(R.id.fragm_char_list_rv_CharactersList)
    RecyclerView rv_characters;

    @BindView(R.id.fragm_char_list_progressBar)
    ProgressBar progressBar;

    private CharactersListPresenter charactersListPresenter;
    private CharacterAdapter characterAdapter;

    private CharacterListListener characterListListener;

    @Override public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof CharacterListListener) {
            this.characterListListener = (CharacterListListener) activity;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (activity instanceof CharacterListListener) {
                this.characterListListener = (CharacterListListener) activity;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.fragment_character_list, container, false);
        ButterKnife.bind(this,fragmentView);

        charactersListPresenter = new CharactersListPresenter(this,new CharacterDataStoreFactory(getContext()));
        setupRecyclerView();
        return fragmentView;
    }

    private void setupRecyclerView() {
        characterAdapter = new CharacterAdapter();
        characterAdapter.setOnItemClickListener(onItemClickListener);
        rv_characters.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_characters.setAdapter(characterAdapter);
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.charactersListPresenter.initialize();
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
        this.showToastMessage(message);
    }

    @Override
    public Context getContext() {
        return this.getActivity().getApplicationContext();
    }

    @Override public void onResume() {
        super.onResume();
        this.charactersListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.charactersListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        if(charactersListPresenter != null){
            charactersListPresenter.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void renderCharacterList(Collection<Character> characterCollection) {
        if(characterCollection != null){
            characterAdapter.setCharacterCollection(characterCollection);
        }
    }

    @Override
    public void viewCharacterDetails(Character character) {
        if (this.characterListListener != null) {
            this.characterListListener.onCharacterClicked(character);
        }
    }

    private final CharacterAdapter.OnItemClickListener onItemClickListener = new CharacterAdapter.OnItemClickListener() {
        @Override
        public void onCharacterItemClicked(Character character) {
            if (charactersListPresenter != null && character != null) {
                charactersListPresenter.onCharacterClicked(character);
            }
        }
    };
}
