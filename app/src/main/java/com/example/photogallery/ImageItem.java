package com.example.photogallery;


public class ImageItem {

    private String mTitle;
    private Integer mImg;

    public ImageItem(String title, Integer image) {
        mTitle = title;
        mImg = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public Integer getImg() {
        return mImg;
    }

    public void setImg(Integer img) {
        this.mImg = img;
    }
}
