package jfuentesa.cleanarchitecture.ui.fragment;

import android.content.Context;
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

    @BindView(R.id.fragm_char_list_rv_CharactersList)
    RecyclerView rv_characters;

    @BindView(R.id.fragm_char_list_progressBar)
    ProgressBar progressBar;

    private CharactersListPresenter charactersListPresenter;
    private CharacterAdapter characterAdapter;

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
}
