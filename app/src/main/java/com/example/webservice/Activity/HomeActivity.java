package com.example.webservice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.webservice.Adapter.ArtikelAdapter;
import com.example.webservice.Model.Articles;
import com.example.webservice.Presenter.*;
import com.example.webservice.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private RecyclerView recyclerViewArtikel;
    private ArtikelAdapter artikelAdapter;
    private List<Articles> articlesList;
    private LinearLayoutManager linearLayoutManager;
    private HomePresenter homePresenter;
    private String API_KEY = "b44949351df04b8289cec4b998ab50b5";
    private String category = "business";
    private String country = "us";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        articlesList = new ArrayList<>();
        artikelAdapter = new ArtikelAdapter(getApplicationContext(), articlesList);
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewArtikel = findViewById(R.id.rec_artikel);
        recyclerViewArtikel.setLayoutManager(linearLayoutManager);
        recyclerViewArtikel.setAdapter(artikelAdapter);

        homePresenter = new HomePresenter(getApplicationContext(), this);
        homePresenter.loadArtikel(country, category, API_KEY);
    }


    @Override
    public void onSucces(List<Articles> articlesList) {
        this.articlesList.addAll(articlesList);
        artikelAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
