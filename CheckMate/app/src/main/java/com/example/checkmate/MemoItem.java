package com.example.checkmate;

public class MemoItem {
    private String todoName;
    private String memoName;

    MemoItem(){

    }
    MemoItem(String todoName, String memoName){
        this.memoName = memoName;
    }

    public String getMemoName() {
        return memoName;
    }

    public void setMemoName(String memoName) {
        this.memoName = memoName;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }
}
