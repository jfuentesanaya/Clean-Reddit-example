package com.example.data.repository.character;

import android.content.Context;

import com.example.data.net.RestApi;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class CharacterDataStoreFactory {

    private final Context context;

    public CharacterDataStoreFactory(Context context) {
        this.context = context;
    }

    public CharacterDataStore createCloudCountryDataStore(){
        RestApi restCountriesApi = RestApi.Creator.restCharactersApiImpl(context);
        return new CloudCharacterDataStore(restCountriesApi);
    }
}
