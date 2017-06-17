package com.taku.search_githubrepo_andrpoid.Network;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by TAKU on 2017/06/17.
 */

public interface RepoService {

    @GET("/search/repositories")
    Observable<RepoListResponse> fetchRepoList(@Query("q") String query);

}
