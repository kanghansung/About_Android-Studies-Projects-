package com.example.checkmate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TodoAdapter2 extends BaseAdapter {
    ArrayList<TodoItem2> todoItem2ArrayList = new ArrayList<>();

    @Override
    public int getCount() {
        return todoItem2ArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoItem2ArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_todo2_item, null, false);
        }

        TextView tvTodoName = (TextView)convertView.findViewById(R.id.tvTodoName);
        TextView tvDate = (TextView)convertView.findViewById(R.id.tvDate);

        TodoItem2 item = todoItem2ArrayList.get(position);
        tvTodoName.setText(item.getTodoName());
        tvDate.setText(item.getDate());

        return convertView;
    }

    public void addItem(String folderName, String todoName, String date){
        todoItem2ArrayList.add(new TodoItem2(folderName, todoName, date));
    }
    public void deleteAll(){
        todoItem2ArrayList.clear();
    }
    public void delete(String todoName){
        int index = 0;
        if(todoItem2ArrayList.size() == 0)
            return;

        for(int i=0;i<todoItem2ArrayList.size();i++) {
            if(todoItem2ArrayList.get(i).getTodoName().equals(todoName)){
                index = i;
                break;
            }

        }
        todoItem2ArrayList.remove(index);
    }
}
