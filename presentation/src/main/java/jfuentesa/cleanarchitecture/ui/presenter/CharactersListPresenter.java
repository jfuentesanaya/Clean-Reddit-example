package jfuentesa.cleanarchitecture.ui.presenter;

import com.example.Character;
import com.example.data.CharacterDataRepository;
import com.example.data.entity.mapper.CharactersEntityDataMapper;
import com.example.data.executor.JobExecutor;
import com.example.data.repository.character.CharacterDataStoreFactory;
import com.example.exception.BundleError;
import com.example.interactor.GetCharactersListUseCase;
import com.example.interactor.GetCharactersListUseCaseImp;

import java.util.Collection;

import jfuentesa.cleanarchitecture.ui.view.CharactersListView;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class CharactersListPresenter extends PresenterBaseImp<CharactersListView> implements GetCharactersListUseCase.GetCharactersListUseCaseCallback{

    private final GetCharactersListUseCase getCharactersListUseCase;

    public CharactersListPresenter(CharactersListView mvpViewBase, CharacterDataStoreFactory characterDataStoreFactory) {
        super(mvpViewBase);

        this.getCharactersListUseCase = new GetCharactersListUseCaseImp(CharacterDataRepository.getInstance(characterDataStoreFactory, new CharactersEntityDataMapper()), JobExecutor.getInstance());
    }

    public void initialize() {
        this.loadUserList();
    }

    private void loadUserList() {
        this.showViewLoading();
        this.getUserList();
    }

    private void showViewLoading() {
        if(isViewAttached()){
            getView().showLoading();
        }
    }

    private void hideViewLoading() {
        if(isViewAttached()){
            getView().hideLoading();
        }
    }

    private void getUserList() {
        this.getCharactersListUseCase.execute(this);
    }

    public void onCharacterClicked(Character character){
        if(isViewAttached()) {
            getView().viewCharacterDetails(character);
        }
    }


    @Override
    public void resume() { }

    @Override
    public void pause() { }

    @Override
    public void destroy() { }

    @Override
    public void onCompleteCharList(Collection<Character> characterCollection) {
        getView().renderCharacterList(characterCollection);
        hideViewLoading();
    }

    @Override
    public void onErrorCharList(BundleError bundleError) {
        hideViewLoading();
        getView().showError(bundleError.getErrorMessage());
    }
}
