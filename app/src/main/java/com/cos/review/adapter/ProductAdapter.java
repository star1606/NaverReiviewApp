package com.cos.review.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.review.MainActivity;
import com.cos.review.R;
import com.cos.review.databinding.ContainerItemBinding;
import com.cos.review.databinding.MenuItemBinding;
import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;
import com.cos.review.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{

    private static final String TAG = "ProductAdapter";
    private List<Product> products = new ArrayList<>();
    private MainActivity mContext;

    public ProductAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    class ProductHolder extends RecyclerView.ViewHolder {

        private ContainerItemBinding containerItemBinding;

        public ProductHolder(@NonNull ContainerItemBinding containerItemBinding) {
            super(containerItemBinding.getRoot());
            this.containerItemBinding = containerItemBinding;
        }
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContainerItemBinding containerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.container_item,
                parent,
                false
        );
        return new ProductHolder(containerItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.containerItemBinding.setProduct(product); // 레이아웃 xml에 오브젝트 주입
        holder.containerItemBinding.setMainActivity(mContext);
    }

    
    @Override
    public int getItemCount() {
        return products.size();
    }


}
