package jfuentesa.cleanarchitecture.ui.fragment;

import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import jfuentesa.cleanarchitecture.R;


/**
 * Created by jfuentesa on 21/10/2016.
 */

public class BaseFragment extends Fragment {

    protected void showToastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showDialogErrorMessage (){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.information))
                .setMessage(getString(R.string.network_error))
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
