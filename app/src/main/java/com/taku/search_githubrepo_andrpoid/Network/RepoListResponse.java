package com.taku.search_githubrepo_andrpoid.Network;

import com.google.gson.annotations.SerializedName;
import com.taku.search_githubrepo_andrpoid.Model.Repo;

import java.util.List;

/**
 * Created by TAKU on 2017/06/17.
 */

public class RepoListResponse {

    @SerializedName("items")
    public List<Repo> repoList;

}
