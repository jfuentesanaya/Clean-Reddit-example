package jfuentesa.cleanarchitecture.ui.presenter;

import com.example.interactor.GetCharactersListUseCase;
import com.example.interactor.GetCharactersListUseCaseImp;

import jfuentesa.cleanarchitecture.ui.view.CharactersListView;

/**
 * Created by jfuentesa on 22/10/2016.
 */

public class CharactersListPresenter extends PresenterBaseImp<CharactersListView> implements GetCharactersListUseCase.Callback{

    private final GetCharactersListUseCase getCharactersListUseCase;

    public CharactersListPresenter(CharactersListView mvpViewBase) {
        super(mvpViewBase);

        this.getCharactersListUseCase = new GetCharactersListUseCaseImp();
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


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onCompleteCharList() {

    }

    @Override
    public void onErrorCharList() {

    }
}
