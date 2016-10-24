package com.example.interactor;

import com.example.Character;
import com.example.exception.BundleError;
import com.example.executor.ThreadExecutor;
import com.example.repository.CharactersRepository;

import java.util.Collection;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class GetCharactersListUseCaseImp implements GetCharactersListUseCase, CharactersRepository.CharacterListCallback {

    private CharactersRepository charactersRepository;

    private GetCharactersListUseCaseCallback callback;
    private ThreadExecutor threadExecutor;

    public GetCharactersListUseCaseImp(CharactersRepository charactersRepository, ThreadExecutor threadExecutor) {
        if(charactersRepository == null){
            throw new IllegalArgumentException("Parameter can not be null");
        }


        this.threadExecutor = threadExecutor;
        this.charactersRepository = charactersRepository;
    }

    @Override
    public void execute(GetCharactersListUseCaseCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Interactor callback cannot be null");
        }
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        charactersRepository.getCharacterList(this);
    }

    @Override
    public void onCharacterListLoaded(Collection<Character> characterCollection) {
        callback.onCompleteCharList(characterCollection);
    }

    @Override
    public void onError(BundleError bundleError) {
        callback.onErrorCharList(bundleError);
    }
}
