package com.example.data.repository.character;

import com.example.data.entity.CharacterEntity;

import java.util.Collection;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public interface CharacterDataStore {

    interface LoadCharactersCallback{
        void onCharactersLoaded(Collection<CharacterEntity> characters);
        void onError(Exception e);
    }

    void loadCharacters(LoadCharactersCallback callback);
}
