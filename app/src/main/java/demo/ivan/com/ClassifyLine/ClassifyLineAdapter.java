package demo.ivan.com.ClassifyLine;


import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import demo.ivan.com.LibDensityUtils;
import demo.ivan.com.autosiderecycler.R;

/**
 * Copyright (C), 2018-2018, 912租房网
 * Author: 张一帆
 * Date: 2018/5/17 0017 下午 3:48
 * Description: 分类入口某一行View的adapter
 */

public class ClassifyLineAdapter extends RecyclerView.Adapter<ClassifyLineAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<String> mRecommendItemList;

    public ClassifyLineAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list) {
        this.mRecommendItemList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_classify_line_adapter, parent, false);
        int screenWidth = LibDensityUtils.getScreenWidth();
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        params.width = (screenWidth - LibDensityUtils.dp2px(35)) / 2;
        params.height = params.width * 2 / 3;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mRecommendItemList.get(position);
        if (item == null) {
            return;
        }
        Glide.with(mContext).load(item).into(holder.mImageView);
//        LibImage.getInstance().load(mContext, holder.mImageView, item.imgUrl, R.drawable.home_page_error);
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        if (position == 0) {
            params.setMargins(LibDensityUtils.dp2px(15), 0, LibDensityUtils.dp2px(5), 0);
        } else if (position == getItemCount() - 1) {
            params.setMargins(0, 0, LibDensityUtils.dp2px(15), 0);
        } else {
            params.setMargins(0, 0, LibDensityUtils.dp2px(5), 0);
        }
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mRecommendItemList == null ? 0 : mRecommendItemList.size();
    }

    @Override
    public void onClick(View v) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item_classify);
        }
    }
}
