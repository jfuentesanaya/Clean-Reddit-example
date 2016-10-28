package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jfuentesa on 27/10/2016.
 */

public class ListEntity {

    @SerializedName("data")
    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public List<PostEntity> parseListToPostList(){
        List<PostEntity> lists = Collections.emptyList();

        ArrayList<ChildrenEntity> children  = getData().getChildren();

        if(children!= null){
            lists = new ArrayList<>();
            for(ChildrenEntity dataChildrenEntity: children){
                lists.add(dataChildrenEntity.getPost());
            }
        }
        return lists;
    }
}
