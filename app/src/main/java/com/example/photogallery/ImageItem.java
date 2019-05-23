package com.example.photogallery;


import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageItem {

    private String mTitle;
    private Uri mImg;
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
    private static final String JSON_TITLE = "title";
    public String bitMap;


    public ImageItem(String bitMap, String mTitle)
    {
        this.mTitle = mTitle;
        this.bitMap = bitMap;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public Uri getImg() {
        return mImg;
    }

    public void setImg(Uri img) {
        this.mImg = img;
    }



    public ImageItem(JSONObject jo) throws JSONException {
        mTitle = jo.getString(JSON_TITLE);
    }

    public ImageItem(){}

    public JSONObject convertToJSON() throws JSONException {

        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, mTitle);

        return jo;
    }

}
