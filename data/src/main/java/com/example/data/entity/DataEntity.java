package com.example.data.entity;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataEntity {

    @SerializedName("modhash")
    private String modHash;

    @SerializedName("children")
    private ArrayList<ChildrenEntity> children;

    public String getModHash() {
        return modHash;
    }

    public void setModHash(String modHash) {
        this.modHash = modHash;
    }

    public ArrayList<ChildrenEntity> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildrenEntity> children) {
        this.children = children;
    }
}
