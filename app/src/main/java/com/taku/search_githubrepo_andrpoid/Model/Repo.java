package com.taku.search_githubrepo_andrpoid.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by TAKU on 2017/06/17.
 */

public class Repo implements Serializable {

    @SerializedName("full_name")
    public String repoName;

    @SerializedName("stargazers_count")
    public String starCount;

    @SerializedName("language")
    public String lang;

    @SerializedName("owner")
    public Owner owner;

}
