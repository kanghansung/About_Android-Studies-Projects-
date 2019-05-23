package org.techtown.listview_makedata_by_dynamic;

import android.widget.ListView;

public class ListViewData {
    String name;
    String phoneNumber;

    ListViewData(){

    }
    ListViewData(String name, String phoneNumber){
        setName(name);
        setPhoneNumber(phoneNumber);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber =phoneNumber;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
