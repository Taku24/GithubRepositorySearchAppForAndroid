package com.taku.search_githubrepo_andrpoid.UI.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import com.taku.search_githubrepo_andrpoid.R;
import com.taku.search_githubrepo_andrpoid.UI.Adapter.ListAdapter;
import com.taku.search_githubrepo_andrpoid.ViewModel.Activity.ListViewModel;
import com.taku.search_githubrepo_andrpoid.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityListBinding binding;
    private ListViewModel viewModel;
    private String mQuery = "";
    private String mSort = "";
    private String mOrder = "";
    private boolean isSort = false;

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
        binding.sortSpinner.setOnItemSelectedListener(this);
        binding.orderSpinner.setOnItemSelectedListener(this);
        mOrder = binding.orderSpinner.getSelectedItem().toString();
        binding.searchView.addTextChangedListener(new TextWatcher() {
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
        });
        viewModel.onCreate();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long i) {
        int id = parent.getId();
        switch (id) {
            case R.id.sortSpinner:
                if (binding.sortSpinner.getSelectedItem().toString().equals(getText(R.string.select))) {
                    mSort = "";
                    isSort = false;
                } else {
                    mSort = binding.sortSpinner.getSelectedItem().toString();
                    isSort = true;
                }
                break;

            case R.id.orderSpinner:
                mOrder = binding.orderSpinner.getSelectedItem().toString();
                break;

            default:
                break;
        }
        fetchListData();
    }

    private void fetchListData() {
        if (isSort) {
            viewModel.fetchSortRepoList(mQuery, mSort, mOrder);
        } else {
            viewModel.fetchRepoList(mQuery, mOrder);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
