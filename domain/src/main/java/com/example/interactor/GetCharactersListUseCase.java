package com.example.interactor;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public interface GetCharactersListUseCase extends Interactor {

    interface Callback {
        void onCompleteCharList();
        void onErrorCharList();
    }

    void execute(Callback callback);
}
