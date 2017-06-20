package com.taku.search_githubrepo_andrpoid.UI.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.UI.Adapter.ListAdapter;
import com.taku.search_githubrepo_andrpoid.ViewModel.Activity.ListViewModel;
import com.taku.search_githubrepo_andrpoid.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private ListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        super.onCreate(savedInstanceState);
        viewModel = new ListViewModel(this);
        binding.setViewModel(viewModel);

        ListAdapter adapter = new ListAdapter(this, viewModel.mRepoList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
        viewModel.onCreate();

    }

}
