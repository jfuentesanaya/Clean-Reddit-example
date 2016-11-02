package jfuentesa.cleanarchitecture.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.comparator.OrderByAuthor;
import jfuentesa.cleanarchitecture.comparator.OrderByDate;
import jfuentesa.cleanarchitecture.comparator.OrderByTitle;
import jfuentesa.cleanarchitecture.utils.DateParse;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {


    public interface OnItemClickListener{
        void onPostItemClicked(Post post);
    }

    private OnItemClickListener onItemClickListener;
    private List<Post> listPosts;

    public PostAdapter() {
        listPosts = Collections.EMPTY_LIST;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = listPosts.get(position);
        holder.bindPost(holder.itemView.getContext(), post);
    }

    @Override
    public int getItemCount() {
        return listPosts.size();
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.validatePostCollection(postCollection);
        this.listPosts = (ArrayList<Post>)postCollection;
        this.notifyDataSetChanged();
    }

    private void validatePostCollection(Collection<Post> postCollection){
        if(postCollection == null){
            throw new IllegalArgumentException("list cannot be null");
        }
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void orderByTitle(){
        Collections.sort(listPosts, new OrderByTitle());

        notifyDataSetChanged();
    }

    public void orderByDate(){
        Collections.sort(listPosts, new OrderByDate());
        notifyDataSetChanged();
    }

    public void orderByAuthor(){
        Collections.sort(listPosts, new OrderByAuthor());
        notifyDataSetChanged();
    }


    class PostViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_txt_title)TextView txtTitle;
        @BindView(R.id.item_txt_author) TextView txtAuthor;
        @BindView(R.id.item_txt_comments) TextView txtComments;
        @BindView(R.id.item_txt_score) TextView txtScore;
        @BindView(R.id.item_txt_date) TextView txtDate;
        @BindView(R.id.item_list_img_photo) ImageView imgPhoto;

        private void bindPost(Context ctx, final Post post){
            txtTitle.setText(post.getTitle());
            txtAuthor.setText(ctx.getString(R.string.author, post.getAuthor()));
            txtComments.setText(ctx.getString(R.string.comments, String.valueOf(post.getNum_comments())));
            txtScore.setText(ctx.getString(R.string.score, String.valueOf(post.getScore())));


            String date_ago = DateParse.createDate(ctx, post.getDate());
            txtDate.setText(ctx.getString(R.string.date, date_ago));

            if(!post.getThumbnail().isEmpty()) {
                Picasso.with(ctx).load(post.getThumbnail()).into(imgPhoto);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onPostItemClicked(post);
                    }
                }
            });
        }

        PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
