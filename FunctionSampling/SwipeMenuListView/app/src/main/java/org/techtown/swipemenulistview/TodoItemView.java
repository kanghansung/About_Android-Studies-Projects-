package org.techtown.swipemenulistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.Nullable;

public class TodoItemView extends LinearLayout{
    TextView txtDate, txtTodo, kindColor, kindText;

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
        inflater.inflate(R.layout.listitem, this, true);

        txtDate = (TextView)findViewById(R.id.txtDate);
        txtTodo = (TextView)findViewById(R.id.txtTodo);
        kindColor = (TextView)findViewById(R.id.txtKindColor);
        kindText = (TextView)findViewById(R.id.txtKindText);
    }

    public void setTxtDate(TextView txtDate) {
        this.txtDate = txtDate;
    }

    public void setTxtTodo(TextView txtTodo) {
        this.txtTodo = txtTodo;
    }

    public void setKindColor(TextView kindColor) {
        this.kindColor = kindColor;
    }

    public void setKindText(TextView kindText) {
        this.kindText = kindText;
    }

    public TextView getTxtDate() {
        return txtDate;
    }

    public TextView getTxtTodo() {
        return txtTodo;
    }

    public TextView getKindColor() {
        return kindColor;
    }

    public TextView getKindText() {
        return kindText;
    }
}
