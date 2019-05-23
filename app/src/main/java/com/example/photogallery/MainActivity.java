package com.example.photogallery;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;


import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    static private MyAdapter mAdapter;
    private FloatingActionButton fab;
    private JSONSerializer mSerializer;

    private static ArrayList mImageList = new ArrayList<ImageItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),AddItemActivity.class);
            startActivityForResult(intent, 1);
            }
        });

        mAdapter = new MyAdapter(this, mImageList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.getAdapter().notifyDataSetChanged();
        Log.i("Info","Images count is" + mImageList.size());


        loadData();

    }

    static void addItem(ImageItem item)
    {
        mImageList.add(item);
        Log.i("info","count is" + mImageList.size());
    }

    public void showImage(Integer index)
    {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();


    }
    public void saveData()
    {
        String filename = "SaveData.json";
        FileOutputStream outputStream;

        try
        {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            Writer writer = new OutputStreamWriter(outputStream);
            Gson gson = new Gson();
            gson.toJson(mImageList, writer);
            writer.close();
        }catch (Exception e)
        {
            Log.e("Error", "Wrong", e);
        }

    }

    private void loadData()
    {
        String filename = "SaveData.json";
        FileInputStream inputStream;
        try
        {
            inputStream = openFileInput(filename);
            Reader reader = new BufferedReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<ImageItem>>() {

            }
            .getType();
            mImageList = gson.fromJson(reader, collectionType);
            reader.close();
        }catch (Exception e)
        {
            Log.e("Error", "Wrong", e);
        }

    }

}
