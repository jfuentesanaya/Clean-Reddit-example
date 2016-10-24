package com.example.interactor;

import com.example.Character;
import com.example.exception.BundleError;

import java.util.Collection;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public interface GetCharactersListUseCase extends Interactor {

    interface GetCharactersListUseCaseCallback {
        void onCompleteCharList(Collection<Character> characterCollection);
        void onErrorCharList(BundleError bundleError);
    }

    void execute(GetCharactersListUseCaseCallback callback);
}
