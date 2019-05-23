package org.techtown.stringlistview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] items){
        super(context, R.layout.customlistviewitem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.customlistviewitem, parent, false);

        String item = getItem(position);
        TextView textView = (TextView)view.findViewById(R.id.customListView_TextView);
        ImageView imageView = (ImageView)view.findViewById(R.id.customListView_ImageView);

        textView.setText(item);
        imageView.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
}
