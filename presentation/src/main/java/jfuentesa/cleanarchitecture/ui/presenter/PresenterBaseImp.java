package jfuentesa.cleanarchitecture.ui.presenter;

import jfuentesa.cleanarchitecture.ui.view.ViewBase;

/**
 * Created by jfuentesa on 21/10/2016.
 */
public abstract class PresenterBaseImp<V extends ViewBase> implements Presenter  {

    private V mvpViewBase;

    public PresenterBaseImp(V mvpViewBase) {
        this.mvpViewBase = mvpViewBase;
    }

    protected V getView(){
        if (!isViewAttached()) throw new MvpViewNotAttachedException();

        return mvpViewBase;
    }

    @Override
    public void destroy() {
        mvpViewBase = null;
    }

    boolean isViewAttached() {
        return mvpViewBase != null;
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting data to the Presenter");
        }
    }
}
