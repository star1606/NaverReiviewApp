package com.cos.review.model;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cos.review.R;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private int id;
    private String blogUrl;
    private String title;
    private String thumnail;
    private String day;
    private SearchKeyword keywords;
    private Timestamp createDate;

    @BindingAdapter({"thumnail"})
    public static void loadImage(ImageView view, String thumnail){
        Glide.with(view.getContext())
                .load(thumnail)
                .error(R.drawable.ic_default)
                .placeholder(R.drawable.ic_load)
                .into(view);
    }
}
