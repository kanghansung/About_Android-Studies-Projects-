package org.techtown.stringlistview;

import android.widget.ImageView;

public class CustomData {
    String text;
    CustomData(){

    }
    CustomData(ImageView imgeView, String text){
//        setImageView(imgeView);
        setText(text);
    }

//    public void setImageView(ImageView imageView) {
//        this.imageView = imageView;
//    }

    public void setText(String text) {
        this.text = text;
    }

//    public ImageView getImageView() {
//        return imageView;
//    }

    public String getText() {
        return text;
    }
}
