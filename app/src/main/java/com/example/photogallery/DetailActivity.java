package com.example.photogallery;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;




public class DetailActivity extends AppCompatActivity {

    private String mTitle;
    //private Image mImage;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("TITLE");
        int imgUrl = intent.getIntExtra("IMAGE", 0);
        textView.setText(name);

        imageView.setImageResource(imgUrl);
    }
}
