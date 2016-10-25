package jfuentesa.cleanarchitecture.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.Character;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class CharacterModel extends Character implements Parcelable {

    public CharacterModel(int characterId){
        setId(characterId);
    }

    private CharacterModel(Parcel in) {
        setId(in.readInt());
        setName(in.readString());
        setAge(in.readInt());
        setHair_color(in.readString());
        setThumbnail(in.readString());
        setWeight(in.readFloat());
        setHeight(in.readFloat());
        setFriends(in.createStringArray());
        setProfessions(in.createStringArray());
    }

    public static final Creator<CharacterModel> CREATOR = new Creator<CharacterModel>() {
        @Override
        public CharacterModel createFromParcel(Parcel in) {
            return new CharacterModel(in);
        }

        @Override
        public CharacterModel[] newArray(int size) {
            return new CharacterModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getName());
        dest.writeInt(getAge());
        dest.writeString(getHair_color());
        dest.writeString(getThumbnail());
        dest.writeFloat(getWeight());
        dest.writeFloat(getHeight());
        dest.writeStringArray(getFriends());
        dest.writeStringArray(getProfessions());
    }
}
