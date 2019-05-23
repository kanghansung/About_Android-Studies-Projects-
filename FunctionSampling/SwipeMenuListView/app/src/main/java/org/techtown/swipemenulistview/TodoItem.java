package org.techtown.swipemenulistview;

public class TodoItem {
    private String txtDate, txtTodo, kindColor, kindText;

    public TodoItem(String txtDate, String txtTodo, String kindColor, String kindText) {
        this.txtDate = txtDate;
        this.txtTodo = txtTodo;
        this.kindColor = kindColor;
        this.kindText = kindText;
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

    public void setKindText(String kindText) {
        this.kindText = kindText;
    }
}
