package com.example.checkmate;

import android.widget.ImageView;

public class FolderItem {
    private String folderName;
    private boolean isPressed = false;

    public FolderItem(){

    }
    public FolderItem(String folderName){
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void setIsPressed(){
        isPressed = !isPressed;
    }
}
