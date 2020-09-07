package com.cos.review.service;

import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/searchKeyword")
    Call<List<SearchKeyword>> callKeywords();

    @GET("/product")
    Call<List<Product>> callProducts();

    @GET("/product/{keyword}")
    Call<List<Product>> callProductByKeywordId(@Path("keyword") int keywordId);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.26:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
