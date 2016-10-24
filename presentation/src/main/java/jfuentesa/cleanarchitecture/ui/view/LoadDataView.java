package jfuentesa.cleanarchitecture.ui.view;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public interface LoadDataView extends ViewBase {

    void showLoading();

    void hideLoading();

    void showError(String message);

    Context getContext();
}
