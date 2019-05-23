package org.techtown.example_db_custumlistview;

public class CustomData {
    String nameShop;
    String place1;
    String kindOfShop;
    String place2;

    CustomData(){

    }
    CustomData(String nameShop, String place1, String kindOfShop, String place2){
        setKindOfShop(kindOfShop);
        setNameShop(nameShop);
        setPlace1(place1);
        setPlace2(place2);
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public void setKindOfShop(String kindOfShop) {
        this.kindOfShop = kindOfShop;
    }
    public void setPlace2(String place2){
        this.place2 = place2;
    }

    public String getNameShop() {
        return nameShop;
    }

    public String getKindOfShop() {
        return kindOfShop;
    }

    public String getPlace1() {
        return place1;
    }

    public String getPlace2() {
        return place2;
    }
}
