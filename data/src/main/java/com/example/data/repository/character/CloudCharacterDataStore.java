package com.example.data.repository.character;

import com.example.data.entity.CharacterEntity;
import com.example.data.net.RestApi;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jfuentesa on 24/10/2016.
 */

class CloudCharacterDataStore implements CharacterDataStore {

    private RestApi restApi;

    CloudCharacterDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void loadCharacters(final LoadCharactersCallback callback) {
        restApi.getCountryList().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject characterEntities = response.body();

                Type listType = new TypeToken<List<CharacterEntity>>() {}.getType();
                Collection<CharacterEntity> characterEntityList = new Gson().fromJson(characterEntities.get("Brastlewark"), listType);

                callback.onCharactersLoaded(characterEntityList);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                callback.onError((Exception)t);
            }
        });
    }
}
