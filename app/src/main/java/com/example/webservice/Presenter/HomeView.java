package com.example.webservice.Presenter;

import com.example.webservice.Model.Articles;

import java.util.List;

public interface HomeView {
    void onSucces(List<Articles> articlesList);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}
