package jfuentesa.cleanarchitecture.mapper;

import com.example.Post;

import jfuentesa.cleanarchitecture.model.PostModel;

/**
 * Created by jfuentesa on 25/10/2016.
 */

public class PostModelDataMapper {

    public PostModelDataMapper() {
    }

    /**
     *
     * @param post  Object to be transformed
     * @return PostModel
     */
    public PostModel transform (Post post){
        if (post == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        PostModel postModel = new PostModel();
        postModel.setAuthor(post.getAuthor());
        postModel.setTitle(post.getTitle());
        postModel.setScore(post.getScore());
        postModel.setThumbnail(post.getThumbnail());
        postModel.setDate(post.getDate());
        postModel.setNum_comments(post.getNum_comments());

        return postModel;
    }
}
