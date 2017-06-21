package com.taku.search_githubrepo_andrpoid.ViewModel.Activity;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Switch;

import com.taku.search_githubrepo_andrpoid.Model.Repo;
import com.taku.search_githubrepo_andrpoid.Network.RepoAPI;
import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.ViewModel.ViewModel;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by TAKU on 2017/06/17.
 */

public class ListViewModel extends ViewModel {

    public ObservableArrayList<Repo> mRepoList = new ObservableArrayList<>();
    private Context mContext;
    private String mQuery = "";
    private String mSort = "";
    private String mOrder = "";
    private boolean isSort = false;

    public ListViewModel(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    public AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long i) {
            int id = parent.getId();
            String select = mContext.getResources().getText(R.string.select).toString();
            switch (id) {
                case R.id.sortSpinner:
                    if (!select.equals(parent.getItemAtPosition(position).toString())) {
                        mSort = parent.getItemAtPosition(position).toString();
                        isSort = true;
                    }
                    break;

                case R.id.orderSpinner:
                    mOrder = parent.getItemAtPosition(position).toString();
                    break;

                default:
                    break;
            }
            fetchListData();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mQuery = s.toString();
            fetchListData();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void fetchListData() {
        if (isSort) {
            fetchSortRepoList();
        } else {
            fetchRepoList();
        }
    }

    private void fetchRepoList() {
        compositeSubscription.add(RepoAPI
                .fetchRepoList(mQuery, mOrder)
                .debounce(1, TimeUnit.SECONDS)
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

    private void fetchSortRepoList() {
        compositeSubscription.add(RepoAPI
                .fetchSortRepoList(mQuery, mSort, mOrder)
                .debounce(1, TimeUnit.SECONDS)
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
