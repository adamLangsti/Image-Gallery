package com.example.photogallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private final String image_titles [] = {

            "img1",
            "img2",
            "img3",
            "img4",
            "img5",
            "img6",
            "img7",
            "img8",
            "img9",
            "img10"
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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), cells);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Cell> prepareData() {
        ArrayList<Cell> theimage = new ArrayList<>();
        for(int i = 0; i < image_titles.length; i++) {
            Cell cell = new Cell();
            cell.setTitle(image_titles[i]);
            cell.setImg(image_ids[i]);
            theimage.add(cell);
        }

        return theimage;
    }
}
