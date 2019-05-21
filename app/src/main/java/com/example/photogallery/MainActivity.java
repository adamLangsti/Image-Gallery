package com.example.photogallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ImageItem> imageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    private final String image_titles [] = {
            "Ocean",
            "Waterfall",
            "Lake",
            "Path",
            "Sunshine",
            "Forest",
            "D man",
            "Gandalf",
            "Meme 1",
            "Meme 2"
    };

    private final Integer image_ids [] = {

            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        prepareData();
        mAdapter = new MyAdapter(this, imageList);
        recyclerView.setAdapter(mAdapter);
    }

    private void prepareData() {
        for(int i = 0; i < image_titles.length; i++) {
            ImageItem imageItem = new ImageItem(image_titles[i],image_ids[i]);
            imageList.add(imageItem);
        }
    }

    public void showImage(Integer index) {

        Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
        int imageUrl = image_ids[index];
        intent.putExtra("IMAGE", imageUrl);
        String imageTitle = image_titles[index];
        intent.putExtra("TITLE",imageTitle);

        startActivity(intent);
    }
}
