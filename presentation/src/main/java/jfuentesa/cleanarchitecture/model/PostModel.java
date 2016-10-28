package jfuentesa.cleanarchitecture.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.Post;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class PostModel extends Post implements Parcelable {


    public PostModel() { }

    private PostModel(Parcel in) {
        setAuthor(in.readString());
        setTitle(in.readString());
        setThumbnail(in.readString());
        setScore(in.readInt());
        setNum_comments(in.readInt());
        setDate(in.readLong());
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getAuthor());
        dest.writeString(getTitle());
        dest.writeString(getThumbnail());
        dest.writeInt(getScore());
        dest.writeInt(getNum_comments());
        dest.writeLong(getDate());
    }
}
