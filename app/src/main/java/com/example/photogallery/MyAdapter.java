package com.example.photogallery;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {


    private ArrayList<ImageItem> galleryList;
    private MainActivity mMainActivity;

    public MyAdapter(MainActivity activity, ArrayList<ImageItem> list)
    {
        galleryList = list;
        mMainActivity = activity;
    }

    @NonNull
    @Override
    public  ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ItemViewHolder viewHolder, final int i)
    {
        ImageItem imageItem = galleryList.get(i);
        viewHolder.title.setText(galleryList.get(i).getTitle());
        viewHolder.img.setImageBitmap(AssistClass.getBitmapFromString(galleryList.get(i).bitMap));

    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {

        TextView title;
        ImageView img;

        public ItemViewHolder(View view)
        {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            mMainActivity.showImage(getAdapterPosition());
        }
    }
}
