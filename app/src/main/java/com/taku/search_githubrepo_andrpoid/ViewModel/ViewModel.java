package com.taku.search_githubrepo_andrpoid.ViewModel;

import android.content.Context;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by TAKU on 2017/06/17.
 */

public abstract class ViewModel {

    protected Context context;

    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    public ViewModel(Context context) {
        this.context = context;
    }

    public void onDestroy() {
        context = null;
        compositeSubscription.unsubscribe();
    }

    abstract public void onCreate();

    abstract public void onResume();

}
