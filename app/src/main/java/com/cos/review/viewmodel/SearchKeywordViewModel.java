package com.cos.review.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.review.model.SearchKeyword;
import com.cos.review.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchKeywordViewModel extends AndroidViewModel {

    private static final String TAG = "SearchKeywordViewModel";

    private MutableLiveData<List<SearchKeyword>> mtSearchKeywords
            = new MutableLiveData<>();

    public SearchKeywordViewModel(@NonNull Application application) {
        super(application);
    }

    // 데이터 변경 감지
    public MutableLiveData<List<SearchKeyword>> 구독(){
        return mtSearchKeywords;
    }

    public void 데이터등록(){
        Call<List<SearchKeyword>> call =
                RetrofitService.retrofit.create(RetrofitService.class).callKeywords();
        call.enqueue(new Callback<List<SearchKeyword>>() {
            @Override
            public void onResponse(Call<List<SearchKeyword>> call, Response<List<SearchKeyword>> response) {
                Log.d(TAG, "SearchKeywordViewModel: 통신성공");
                List<SearchKeyword> searchKeywords = response.body();
                mtSearchKeywords.setValue(searchKeywords);
            }

            @Override
            public void onFailure(Call<List<SearchKeyword>> call, Throwable t) {
                Log.d(TAG, "SearchKeywordViewModel: 통신 실패");
            }
        });

    }
}
