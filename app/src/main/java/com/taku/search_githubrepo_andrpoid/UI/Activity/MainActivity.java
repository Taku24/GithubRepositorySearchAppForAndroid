package com.taku.search_githubrepo_andrpoid.UI.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;

import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.UI.Adapter.MainAdapter;
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

        MainAdapter adapter = new MainAdapter(this, viewModel.mRepoList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.fetchRepoList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewModel.onCreate();

    }
}
