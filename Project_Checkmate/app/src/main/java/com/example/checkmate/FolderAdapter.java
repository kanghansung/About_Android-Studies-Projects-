package com.example.checkmate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FolderAdapter extends BaseAdapter{

    private ArrayList<FolderItem> folderList = new ArrayList<FolderItem>();

    @Override
    public int getCount() {
        return folderList.size();
    }

    @Override
    public Object getItem(int position) {
        return folderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_folder_item, null, false);

        }
        TextView tvFolderName = (TextView)convertView.findViewById(R.id.tvFolderName);
        ImageView imgIcon = (ImageView)convertView.findViewById(R.id.imgIcon);
        FolderItem folderItem = folderList.get(position);

        tvFolderName.setText(folderItem.getFolderName());


        return convertView;
    }

    public void addItem(String folderName){
        FolderItem item = new FolderItem(folderName);
        folderList.add(item);
    }

    public void deleteAll(){
        folderList.clear();
    }
}