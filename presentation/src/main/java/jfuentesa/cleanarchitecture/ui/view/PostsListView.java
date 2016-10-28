package jfuentesa.cleanarchitecture.ui.view;

import com.example.Post;

import java.util.Collection;

/**
 * Created by jfuentesa on 21/10/2016.
 */

public interface PostsListView extends LoadDataView {
    void renderList(Collection<Post> postCollection);

    void viewPostDetails(Post post);

}
