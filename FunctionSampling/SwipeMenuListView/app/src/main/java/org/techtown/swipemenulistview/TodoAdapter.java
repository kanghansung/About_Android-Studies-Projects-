package org.techtown.swipemenulistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class TodoAdapter extends BaseAdapter {
    private ArrayList<TodoItemView> todoList = new ArrayList<>();
    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int i) {
        return todoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
//        TodoItemView v = null;
//        if(view == null)
//            v = new TodoItemView()
    }
}
