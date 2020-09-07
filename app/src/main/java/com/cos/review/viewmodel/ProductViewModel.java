package com.cos.review.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;
import com.cos.review.service.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends AndroidViewModel {

    private static final String TAG = "ProductViewModel";

    private MutableLiveData<List<Product>> mtProduct
            = new MutableLiveData<>();


    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    // 데이터 변경 감지
    public MutableLiveData<List<Product>> 구독(){
        return mtProduct;
    }

    public void changeData(int keywordId){
        Log.d(TAG, "changeData: changeData 실행됨");
        Call<List<Product>> call =
                RetrofitService.retrofit.create(RetrofitService.class).callProductByKeywordId(keywordId);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d(TAG, "ProductViewModel: 통신성공");
                List<Product> products = response.body();
                mtProduct.setValue(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d(TAG, "ProductViewModel: 통신 실패");
            }
        });
    }

    public void 데이터등록(){
        Call<List<Product>> call =
                RetrofitService.retrofit.create(RetrofitService.class).callProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d(TAG, "ProductViewModel: 통신성공");
                List<Product> products = response.body();
                mtProduct.setValue(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d(TAG, "ProductViewModel: 통신 실패");
            }
        });

    }
}
