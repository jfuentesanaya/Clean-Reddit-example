package com.example.repository;

import com.example.Character;
import com.example.exception.BundleError;

import java.util.Collection;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface CharactersRepository {

    interface CharacterListCallback {
        void onCharacterListLoaded(Collection<Character> characterCollection);
        void onError(BundleError bundleError);
    }

    void getCharacterList(CharacterListCallback callback);
}
