package com.taku.search_githubrepo_andrpoid.Screens.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.ViewModel.Activity.MainViewModel;
import com.taku.search_githubrepo_andrpoid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        super.onCreate(savedInstanceState);
        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
        viewModel.onCreate();
        viewModel.fetchRepoList("Test");
    }
}
