package com.taku.search_githubrepo_andrpoid.ViewModel.Activity;

import android.content.Context;
import android.databinding.ObservableArrayList;

import com.taku.search_githubrepo_andrpoid.Model.Repo;
import com.taku.search_githubrepo_andrpoid.Network.RepoAPI;
import com.taku.search_githubrepo_andrpoid.ViewModel.ViewModel;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by TAKU on 2017/06/17.
 */

public class MainViewModel extends ViewModel{

    public ObservableArrayList<Repo> mRepoList = new ObservableArrayList<>();

    public MainViewModel(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {

    }

    public void fetchRepoList(String query){
        compositeSubscription.add(RepoAPI
                .fetchRepoList(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Repo> repoList) {
                        mRepoList.clear();
                        mRepoList.addAll(repoList);
                    }
                })
        );
    }

    @Override
    public void onResume() {

    }
}
