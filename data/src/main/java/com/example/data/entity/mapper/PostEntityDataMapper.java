package com.example.data.entity.mapper;

import com.example.Post;
import com.example.data.entity.PostEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jfuentesa on 24/10/2016.
 */

public class PostEntityDataMapper {

    public PostEntityDataMapper() {
    }

    public List<Post> transform(List<PostEntity> dataEntityList){
        List<Post> postList = new ArrayList<>();

        if(dataEntityList != null){
            for(PostEntity postEntity : dataEntityList){
                postList.add(transform(postEntity));
            }
        }else{
            postList = Collections.emptyList();
        }
        return postList;
    }

    private Post transform(PostEntity postEntity){
        Post post = null;
        if(postEntity != null){
            post = new Post();
            post.setTitle(postEntity.getTitle());
            post.setAuthor(postEntity.getAuthor());
            post.setDate(postEntity.getDate());
            post.setThumbnail(postEntity.getThumbnail());
            post.setNum_comments(postEntity.getNum_comments());
            post.setScore(postEntity.getScore());
        }
        return post;
    }
}
