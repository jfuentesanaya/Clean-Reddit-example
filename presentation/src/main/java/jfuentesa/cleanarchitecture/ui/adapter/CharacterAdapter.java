package jfuentesa.cleanarchitecture.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jfuentesa.cleanarchitecture.R;
import jfuentesa.cleanarchitecture.comparator.OrderByAge;
import jfuentesa.cleanarchitecture.comparator.OrderByName;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {


    public interface OnItemClickListener{
        void onCharacterItemClicked(Character character);
    }

    private OnItemClickListener onItemClickListener;
    private List<Character> listCharacters;

    public CharacterAdapter() {
        listCharacters = Collections.EMPTY_LIST;
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        Character charact = listCharacters.get(position);
        holder.bindCharacter(holder.itemView.getContext(), charact);
    }

    @Override
    public int getItemCount() {
        return listCharacters.size();
    }

    public void setCharacterCollection(Collection<Character> countryCollection) {
        this.validateCharacterCollection(countryCollection);
        this.listCharacters = (ArrayList<Character>)countryCollection;
        this.notifyDataSetChanged();
    }

    private void validateCharacterCollection(Collection<Character> countryCollection){
        if(countryCollection == null){
            throw new IllegalArgumentException("list cannot be null");
        }
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void orderByName(){
        Collections.sort(listCharacters, new OrderByName());

        notifyDataSetChanged();
    }

    public void orderByAge(){
        Collections.sort(listCharacters, new OrderByAge());
        notifyDataSetChanged();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_list_txt_name)
        TextView txtName;

        @BindView(R.id.item_list_img_photo)
        ImageView imgPhoto;

        @BindView(R.id.item_list_txt_age) TextView txtAge;


        private void bindCharacter(Context ctx, final Character character){
            txtName.setText(character.getName());
            txtAge.setText(ctx.getString(R.string.age, character.getAge()));

            Picasso.with(ctx).load(character.getThumbnail()).into(imgPhoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onCharacterItemClicked(character);
                    }
                }
            });
        }

        CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
