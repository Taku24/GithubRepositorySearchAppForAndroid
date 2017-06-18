package com.taku.search_githubrepo_andrpoid.Network;


import com.taku.search_githubrepo_andrpoid.Model.Repo;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by TAKU on 2017/06/17.
 */

public class RepoAPI {

    public static Observable<List<Repo>> fetchRepoList(String query) {
        return RestClient.getRetrofit().create(RepoService.class)
                .fetchRepoList(query)
                .map(new Func1<RepoListResponse, List<Repo>>() {
                    @Override
                    public List<Repo> call(RepoListResponse repoListResponse) {
                        return repoListResponse.repoList;
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    public static Observable<List<Repo>> fetchSortRepoList(String query, String sort) {
        return RestClient.getRetrofit().create(RepoService.class)
                .fetchSortRepoList(query, sort)
                .map(new Func1<RepoListResponse, List<Repo>>() {
                    @Override
                    public List<Repo> call(RepoListResponse repoListResponse) {
                        return repoListResponse.repoList;
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    public static Observable<List<Repo>> fetchOrderRepoList(String query, String order) {
        return RestClient.getRetrofit().create(RepoService.class)
                .fetchOrderRepoList(query, order)
                .map(new Func1<RepoListResponse, List<Repo>>() {
                    @Override
                    public List<Repo> call(RepoListResponse repoListResponse) {
                        return repoListResponse.repoList;
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    public static Observable<List<Repo>> fetchBothRepoList(String query, String sort, String order) {
        return RestClient.getRetrofit().create(RepoService.class)
                .fetchBothRepoList(query, sort, order)
                .map(new Func1<RepoListResponse, List<Repo>>() {
                    @Override
                    public List<Repo> call(RepoListResponse repoListResponse) {
                        return repoListResponse.repoList;
                    }
                })
                .subscribeOn(Schedulers.io());
    }

}
