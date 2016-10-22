package com.example.interactor;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class GetCharactersListUseCaseImp implements GetCharactersListUseCase {


    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null");
        }
    }

    @Override
    public void run() {

    }
}
