package com.example.webservice.Presenter;

import android.content.Context;

import com.example.webservice.Model.ArtikelResponse;
import com.example.webservice.Network.BaseApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeInterface {
    private Context context;
    private HomeView homeView;

    public HomePresenter(Context context, HomeView homeView) {
        this.context = context;
        this.homeView = homeView;
    }

    @Override
    public void loadArtikel(String country, String category, String apiKey) {
        BaseApp.service.getArtikel(country, category, apiKey).enqueue(new Callback<ArtikelResponse>() {
            @Override
            public void onResponse(Call<ArtikelResponse> call, Response<ArtikelResponse> response) {
                if (response.isSuccessful()) {
                    homeView.onSucces(response.body().getArticles());
                } else {
                    homeView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ArtikelResponse> call, Throwable t) {
                homeView.onFailure(t.getMessage());
            }
        });
    }
}
