package jfuentesa.cleanarchitecture.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.model.CharacterModel;
import jfuentesa.cleanarchitecture.ui.view.CharactersDetailView;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class CharacterDetailFragment extends BaseFragment implements CharactersDetailView {

    private static final String CHARACTER_SELECTED = "CHARACTER_SELECTED";
    private CharacterModel characterSelected;

    @BindView(R.id.fragm_char_detail_txt_name)
    TextView txtName;
    @BindView(R.id.fragm_char_detail_txt_age)
    TextView txtAge;
    @BindView(R.id.fragm_char_detail_iv_photo)
    ImageView imgPhoto;
    @BindView(R.id.fragm_char_detail_txt_haircolor)
    TextView txtHairColor;
    @BindView(R.id.fragm_char_detail_txt_height)
    TextView txtHeight;
    @BindView(R.id.fragm_char_detail_txt_weight)
    TextView txtWeight;
    @BindView(R.id.fragm_char_detail_txt_friends)
    TextView txtFriends;
    @BindView(R.id.fragm_char_detail_txt_professions)
    TextView txtProfessions;

    public CharacterDetailFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.characterSelected = getArguments().getParcelable(CHARACTER_SELECTED);
    }

    public static CharacterDetailFragment newInstance(CharacterModel characterSelected) {
        CharacterDetailFragment userDetailsFragment = new CharacterDetailFragment();

        Bundle argumentsBundle = new Bundle();
        argumentsBundle.putParcelable(CHARACTER_SELECTED, characterSelected);
        userDetailsFragment.setArguments(argumentsBundle);

        return userDetailsFragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadCharacterData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
        ButterKnife.bind(this,fragmentView);
        return fragmentView;
    }


    @Override
    public void loadCharacterData() {
        txtName.setText(characterSelected.getName());
        txtAge.setText(getString(R.string.age, characterSelected.getAge()));
        txtHairColor.setText(getString(R.string.hair_color, characterSelected.getHair_color()));
        txtHeight.setText(getString(R.string.height, characterSelected.getHeight()));
        txtWeight.setText(getString(R.string.weight, characterSelected.getWeight()));

        if(characterSelected.getFriends().length != 0){
            txtFriends.setText(getString(R.string.friends, getFriends(characterSelected.getFriends())));
        }else{
            txtFriends.setVisibility(View.INVISIBLE);
        }

        if(characterSelected.getProfessions().length != 0){
            txtProfessions.setText(getString(R.string.professions, getProfessions(characterSelected.getProfessions())));
        }else{
            txtProfessions.setVisibility(View.INVISIBLE);
        }


        Picasso.with(getActivity()).load(characterSelected.getThumbnail()).into(imgPhoto);
    }


    private String getFriends(String[] friendsArray) {
        String friends = "";
        for (int i=0; i<friendsArray.length; i++){
            if(i != (friendsArray.length-1)){
                friends = friends.concat(friendsArray[i] + ", ");
            }else{
                friends = friends.concat(friendsArray[i]);
            }
        }
        return friends;
    }

    private String getProfessions(String[] professionsArray) {
        String professions = "";
        for (int i=0; i<professionsArray.length; i++){
            if(i != (professionsArray.length-1)){
                professions = professions.concat(professionsArray[i] + ", ");
            }else{
                professions = professions.concat(professionsArray[i]);
            }
        }
        return professions;
    }
}
