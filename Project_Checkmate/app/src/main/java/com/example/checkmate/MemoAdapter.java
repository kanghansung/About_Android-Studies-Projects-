package com.example.checkmate;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MemoAdapter extends BaseAdapter {
    ArrayList<MemoItem> memoItemArrayList = new ArrayList<>();

    @Override
    public int getCount() {
        return memoItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return memoItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, false);
        }

        TextView memoName = (TextView)convertView.findViewById(R.id.tvListItem);
        MemoItem memoItem = memoItemArrayList.get(position);
        memoName.setText(memoItem.getMemoName());


        return convertView;
    }

    public void addItem(String folderName, String memoName)
    {
        MemoItem memoItem = new MemoItem(folderName, memoName);
        memoItemArrayList.add(memoItem);
    }


    public void deleteAll(){
        memoItemArrayList.clear();
    }
}
