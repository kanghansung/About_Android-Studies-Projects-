package org.techtown.swipemenulistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeMenuListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (SwipeMenuListView)findViewById(R.id.listview);
        ArrayList<String> list = new ArrayList<>();
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");
        list.add("mitch");

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                //create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
                //set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9,0xC9,0xCE)));
                //set item width
                openItem.setWidth(500);
                //set item title
                openItem.setTitle("Open");
                //set item title fontSize
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                //add to menu
                menu.addMenuItem(openItem);

                //create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F,0x25)));
                deleteItem.setWidth(170);
                deleteItem.setIcon(R.drawable.ic_action_call);
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index){
                    case 0:
                        Toast.makeText(getApplicationContext(), "삭제아이콘 눌림", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
    class TodoAdapter extends BaseAdapter {
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
//            TodoItemView v = null;
//            if (view == null)
//                v = new TodoItemView()
        }
    }
}
