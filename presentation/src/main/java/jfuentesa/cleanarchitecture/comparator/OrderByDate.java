package jfuentesa.cleanarchitecture.comparator;

import com.example.Post;

import java.util.Comparator;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class OrderByDate implements Comparator<Post> {
    @Override
    public int compare(Post o1, Post o2) {
        return (int)(o2.getDate() - o1.getDate());
    }
}
