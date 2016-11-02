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
import jfuentesa.cleanarchitecture.model.PostModel;
import jfuentesa.cleanarchitecture.ui.view.PostsDetailView;
import jfuentesa.cleanarchitecture.utils.DateParse;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class PostDetailFragment extends BaseFragment implements PostsDetailView {

    private static final String TAG_SELECTED = "TAG_SELECTED";
    private PostModel postSelected;

    @BindView(R.id.fragm_post_detail_txt_title)
    TextView txtTitle;
    @BindView(R.id.fragm_post_detail_txt_author)
    TextView txtAuthor;
    @BindView(R.id.fragm_post_detail_iv_photo)
    ImageView imgPhoto;
    @BindView(R.id.fragm_post_detail_txt_score)
    TextView txtScore;
    @BindView(R.id.fragm_post_detail_txt_date)
    TextView txtDate;
    @BindView(R.id.fragm_post_detail_txt_comments)
    TextView txtComments;

    public PostDetailFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.postSelected = getArguments().getParcelable(TAG_SELECTED);
    }

    public static PostDetailFragment newInstance(PostModel postSelected) {
        PostDetailFragment postDetailFragment = new PostDetailFragment();

        Bundle argumentsBundle = new Bundle();
        argumentsBundle.putParcelable(TAG_SELECTED, postSelected);
        postDetailFragment.setArguments(argumentsBundle);

        return postDetailFragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadPostData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_post_details, container, false);
        ButterKnife.bind(this,fragmentView);
        return fragmentView;
    }


    @Override
    public void loadPostData() {
        txtTitle.setText(postSelected.getTitle());
        txtAuthor.setText(getString(R.string.author, postSelected.getAuthor()));
        txtScore.setText(getString(R.string.score, String.valueOf(postSelected.getScore())));
        txtComments.setText(getString(R.string.comments, String.valueOf(postSelected.getNum_comments())));
        txtDate.setText(getString(R.string.date, DateParse.createDate(getActivity(), postSelected.getDate())));

        if(!postSelected.getThumbnail().isEmpty()) {
            Picasso.with(getActivity()).load(postSelected.getThumbnail()).into(imgPhoto);
        }
    }
}
