package jfuentesa.cleanarchitecture.ui.fragment;

import android.app.Fragment;
import android.support.annotation.StringRes;
import android.widget.Toast;


/**
 * Created by jfuentesa on 21/10/2016.
 */

public class BaseFragment extends Fragment {

    protected void showToastMessage(@StringRes int message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}