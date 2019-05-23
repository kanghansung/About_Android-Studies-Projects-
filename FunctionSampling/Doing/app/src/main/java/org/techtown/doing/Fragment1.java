package org.techtown.doing;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

import static com.baoyz.swipemenulistview.SwipeMenuListView.*;

public class Fragment1 extends Fragment {
    SwipeMenuListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        listView = (SwipeMenuListView)root.findViewById(R.id.todoListview);

        ArrayList<TodoItem> todoItemArrayList = new ArrayList<>();

        Adapter adapter = new Adapter();
        adapter.addItem(new TodoItem("오늘", "글영 발표 준비","#FA7575", "수업과제", false));
        adapter.addItem((new TodoItem("내일", "글영 발표 준비", "#FAB375", "데일리", false)));
        adapter.addItem(new TodoItem("12.15일", "글영 발표 준비", "#FAB375", "데일리", false));
        adapter.addItem(new TodoItem("12.16일", "글영 발표 준비", "#FA7575", "수업과제", false));
        adapter.addItem(new TodoItem("12.1일", "글영 발표 준비", "#CA75FA", "발표", false));
        listView.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity().getApplicationContext());
                deleteItem.setWidth(dp2px(90));
                deleteItem.setIcon(R.drawable.ic_action_delete);
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F,0x25)));
//                deleteItem.set
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                switch (index){
                    case 0:
                        Toast.makeText(getActivity().getApplicationContext(),"삭제아이콘이 눌렸습니다.", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

        return root;
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    //inner 클래스로 정의
    class Adapter extends BaseAdapter{
        ArrayList<TodoItem> list = new ArrayList<>();

        public Adapter(){

        }

        public void addItem(TodoItem item){
            list.add(item);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        TodoItemView v = null;

        @Override
        public View getView(int i, View view, final ViewGroup viewGroup) {
//            return null;
            if(view == null){
                final Context context = getActivity().getApplicationContext();
                v = new TodoItemView(context);
            } else {
                v = (TodoItemView)view;
            }

            final ImageView buttonCheck = (ImageView)v.findViewById(R.id.btnCheck);
            buttonCheck.setOnClickListener(new OnClickListener() {
                int buttonState = 0;
                @Override
                public void onClick(View view) {

                    if(buttonState == 0) {
                        buttonCheck.setImageResource(R.drawable.check_p);
//                        buttonCheck.setSelected(true);
                        buttonState = 1;
                    } else if(buttonState == 1){
//                        buttonCheck.setSelected(false);
                        buttonCheck.setImageResource(R.drawable.uncheck_p);
                        v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        buttonState = 0;
                    }
                }
            });

            TodoItem item = list.get(i);
            v.setTxtTodo(item.getTxtTodo());
            v.setTxtDate(item.getTxtDate());
            v.setKindText(item.getKindText());
            v.setKindColor(item.getKindColor());
            v.setButtonCheck(item.getCheck());
            //리스트 뷰내의 아이템 뷰 내의 xml에 인덱스붙이기(tag붙이기)
            v.buttonCheck.setTag("1");

            //리스트 뷰내의 아이템 인덱스붙이기(tag붙이기)
            v.setTag(""+i);

            return v;
        }
    }
}