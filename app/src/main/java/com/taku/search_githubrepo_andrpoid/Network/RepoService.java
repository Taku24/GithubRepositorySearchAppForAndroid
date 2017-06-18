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

    @GET("/search/repositories")
    Observable<RepoListResponse> fetchSortRepoList(@Query("q") String query, @Query("sort") String sort);

    @GET("/search/repositories")
    Observable<RepoListResponse> fetchOrderRepoList(@Query("q") String query, @Query("order") String order);

    @GET("/search/repositories")
    Observable<RepoListResponse> fetchBothRepoList(@Query("q") String query, @Query("sort") String sort, @Query("order") String order);

}
