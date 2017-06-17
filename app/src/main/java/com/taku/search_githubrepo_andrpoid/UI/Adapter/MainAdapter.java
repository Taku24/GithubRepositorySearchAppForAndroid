package com.taku.search_githubrepo_andrpoid.UI.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taku.search_githubrepo_andrpoid.Model.API.Repo;
import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.databinding.ItemRepoBinding;

/**
 * Created by TAKU on 2017/06/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ObservableList<Repo> mRepoList;

    public MainAdapter(ObservableList<Repo> repoList) {
        mRepoList = repoList;
        mRepoList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Repo>>() {
            @Override
            public void onChanged(ObservableList<Repo> repos) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Repo> repoList, int i, int i1) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeInserted(ObservableList<Repo> repoList, int i, int i1) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeMoved(ObservableList<Repo> repoList, int i, int i1, int i2) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Repo> repoList, int i, int i1) {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        final Repo repo = mRepoList.get(position);
        holder.getBinding().repoTitle.setText(repo.repoName);
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        private final ItemRepoBinding binding;

        MainViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        ItemRepoBinding getBinding(){
            return binding;
        }
    }
}