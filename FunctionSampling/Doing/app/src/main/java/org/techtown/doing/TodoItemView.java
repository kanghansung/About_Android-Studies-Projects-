package org.techtown.doing;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TodoItemView extends LinearLayout{
    TextView txtDate;
    TextView txtTodo;
    TextView kindColor;
    TextView kindText;
    ImageView buttonCheck;

    public TodoItemView(Context context){
        super(context);
        init(context);
    }
    public TodoItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.todolistview_item, this, true);

        txtDate = (TextView)findViewById(R.id.txtDate);
        txtTodo = (TextView)findViewById(R.id.txtTodo);
        kindColor = (TextView)findViewById(R.id.txtKindColor);
        kindText = (TextView)findViewById(R.id.txtKindText);

        buttonCheck = (ImageView)findViewById(R.id.btnCheck);
    }

    public void setTxtDate(String date){
        txtDate.setText(date);
    }
    public void setTxtTodo(String todo){
        txtTodo.setText(todo);
    }
    //색깔 지정방식 2개로 설정해둠.
    public void setKindColor(String color){
        kindColor.setTextColor(Color.parseColor(String.valueOf(color)));
    }
    public void setKindColor(int color){
        switch (color){
            case 0:
                //수업과제
                kindColor.setTextColor(Color.parseColor("#FA7575"));
                break;
            case 1:
                //데일리
                kindColor.setTextColor(Color.parseColor("#FA7575"));
                break;
            case 2:
                //발표
                kindColor.setTextColor(Color.parseColor("#FA7575"));
                break;
            case 3:
                //이후로는 아무거나
                kindColor.setTextColor(Color.parseColor("#FA7575"));
                break;
        }
    }
    public void setKindText(String tag){
        kindText.setText(tag);
    }

    public void setButtonCheck(Boolean check){

        if(check)
            buttonCheck.setImageResource(R.drawable.check_p);
        else
            buttonCheck.setImageResource(R.drawable.uncheck_p);
    }

}
