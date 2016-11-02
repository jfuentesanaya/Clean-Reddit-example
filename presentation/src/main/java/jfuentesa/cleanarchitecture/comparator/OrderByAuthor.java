package jfuentesa.cleanarchitecture.comparator;

import com.example.Post;

import java.util.Comparator;

/**
 * Created by jfuentesa on 28/10/2016.
 */

public class OrderByAuthor implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
