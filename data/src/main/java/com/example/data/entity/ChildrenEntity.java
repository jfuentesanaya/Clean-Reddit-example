package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jfuentesa on 27/10/2016.
 */

public class ChildrenEntity {

    @SerializedName("kind")
    private String kind;

    @SerializedName("data")
    private PostEntity post;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}
