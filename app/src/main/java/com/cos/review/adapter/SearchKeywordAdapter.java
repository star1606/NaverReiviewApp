package com.cos.review.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.review.R;
import com.cos.review.databinding.MenuItemBinding;
import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;
import com.cos.review.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchKeywordAdapter extends RecyclerView.Adapter<SearchKeywordAdapter.SearchKeywordHolder> {

    private static final String TAG = "SearchKeywordAdapter";
    
    private ProductViewModel productViewModel;
    private List<SearchKeyword> searchKeywords = new ArrayList<>();
    public SearchKeywordAdapter() { }
    public SearchKeywordAdapter(ProductViewModel productViewModel) {
        this.productViewModel = productViewModel;
    }

    public void setSearchKeywords(List<SearchKeyword> searchKeywords){
        this.searchKeywords = searchKeywords;
    }

    class SearchKeywordHolder extends RecyclerView.ViewHolder {

        private MenuItemBinding menuItemBinding;

        public SearchKeywordHolder(@NonNull MenuItemBinding menuItemBinding) {
            super(menuItemBinding.getRoot());
            this.menuItemBinding = menuItemBinding;
        }
    }

    @NonNull
    @Override
    public SearchKeywordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding menuItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.menu_item,
                parent,
                false
        );

        return new SearchKeywordHolder(menuItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchKeywordHolder holder, int position) {
        SearchKeyword searchKeyword = searchKeywords.get(position);
        holder.menuItemBinding.setSearchKeyword(searchKeyword);
        holder.menuItemBinding.setProductViewModel(productViewModel);
    }

    @Override
    public int getItemCount() {
        return searchKeywords.size();
    }
}
