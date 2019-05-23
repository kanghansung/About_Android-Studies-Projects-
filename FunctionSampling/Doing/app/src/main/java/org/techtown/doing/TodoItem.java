package org.techtown.doing;

import android.graphics.Color;
import android.view.View;

public class TodoItem {
    String txtDate;
    String txtTodo;
    String kindColor;
    String kindText;
    Boolean check;

    //해당 아이템의 리스너를 사용하려고 등록
    public View.OnClickListener todoItemListener;

    public TodoItem(String txtDate, String txtTodo, String kindColor, String kindText,Boolean check) {
        this.txtDate = txtDate;
        this.txtTodo = txtTodo;
        this.kindColor = kindColor;
        this.kindText = kindText;
        this.check = check;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public String getTxtTodo() {
        return txtTodo;
    }

    public void setTxtTodo(String txtTodo) {
        this.txtTodo = txtTodo;
    }

    public String getKindColor() {
        return kindColor;
    }

    public void setKindColor(String kindColor) {
        this.kindColor = kindColor;
    }

    public String getKindText() {
        return kindText;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public void setKindText(String kindText) {
        this.kindText = kindText;

    }
}
