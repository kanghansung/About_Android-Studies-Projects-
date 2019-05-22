package com.example.checkmate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class TodoAdapter extends BaseAdapter {

    ArrayList<TodoItem> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_todo_item, null, false);
        }

        TextView tvTodoName = (TextView)convertView.findViewById(R.id.tvTodoName);
        TextView tvDate = (TextView)convertView.findViewById(R.id.tvDate);
        TodoItem todoItem = items.get(position);
        tvTodoName.setText(todoItem.getTodoName());
        tvDate.setText(todoItem.getDate());


        return convertView;
    }

    public void addItem(String folderName, String todoName, String date){
        TodoItem item = new TodoItem(folderName, todoName, date);
        items.add(item);
    }

    public void deleteAll(){
        items.clear();
    }
}
