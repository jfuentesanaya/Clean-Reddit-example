package com.example.data;

import com.example.data.entity.CharacterEntity;
import com.example.data.entity.mapper.CharactersEntityDataMapper;
import com.example.data.exception.RepositoryErrorBundle;
import com.example.data.repository.character.CharacterDataStore;
import com.example.data.repository.character.CharacterDataStoreFactory;
import com.example.repository.CharactersRepository;

import java.util.Collection;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class CharacterDataRepository implements CharactersRepository, CharacterDataStore.LoadCharactersCallback {

    private static CharacterDataRepository INSTANCE;
    private CharacterListCallback characterListCallback;

    public static synchronized CharacterDataRepository getInstance(CharacterDataStoreFactory characterDataStoreFactory, CharactersEntityDataMapper charactersEntityDataMapper) {
        if(INSTANCE == null){
            INSTANCE = new CharacterDataRepository(characterDataStoreFactory, charactersEntityDataMapper);
        }

        return INSTANCE;
    }

    private final CharacterDataStoreFactory characterDataStoreFactory;
    private final CharactersEntityDataMapper charactersEntityDataMapper;

    CharacterDataRepository(CharacterDataStoreFactory characterDataStoreFactory, CharactersEntityDataMapper charactersEntityDataMapper) {
        this.characterDataStoreFactory = characterDataStoreFactory;
        this.charactersEntityDataMapper = charactersEntityDataMapper;
    }

    @Override
    public void getCharacterList(final CharacterListCallback callback) {

        CharacterDataStore cloudCharacterDataStore = characterDataStoreFactory.createCloudCountryDataStore();
        this.characterListCallback = callback;

        cloudCharacterDataStore.loadCharacters(this);

    }

    @Override
    public void onCharactersLoaded(Collection<CharacterEntity> characters) {
        this.characterListCallback.onCharacterListLoaded(charactersEntityDataMapper.transform(characters));
    }

    @Override
    public void onError(Exception e) {
        this.characterListCallback.onError(new RepositoryErrorBundle(e));
    }
}
