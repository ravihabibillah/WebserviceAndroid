package com.example.webservice.Network;

import com.example.webservice.Model.ArtikelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v2/top-headlines")
    Call<ArtikelResponse> getArtikel(@Query("country") String country,
                                     @Query("category") String category,
                                     @Query("apiKey") String apiKey);
}
