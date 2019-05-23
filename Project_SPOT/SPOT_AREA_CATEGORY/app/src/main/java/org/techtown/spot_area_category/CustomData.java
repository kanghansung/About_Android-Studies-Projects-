package org.techtown.spot_area_category;

import android.graphics.drawable.Drawable;

public class CustomData {
    private Drawable iconDrawable;
    private String nameShop;
    private String place1Shop;
    private String place2Shop;
    private String kindOfShop;

    CustomData(){

    }
    CustomData(Drawable iconDrawable, String nameShop, String place1Shop, String kindOfShop, String place2Shop){
        this.iconDrawable = iconDrawable;
        this.nameShop = nameShop;
        this.place1Shop = place1Shop;
        this.kindOfShop = kindOfShop;
        this.place2Shop = place2Shop;
    }

    public void setIconDrawable(Drawable iconDrawable){
        this.iconDrawable = iconDrawable;
    }
    public void setNameShop(String nameShop){this.nameShop = nameShop;}
    public void setPlace1Shop(String place1Shop){this.place1Shop = place1Shop;}
    public void setKindOfShop(String kindOfShop){this.kindOfShop = kindOfShop;}
    public void setPlace2Shop(String place2Shop){this.place2Shop = place2Shop;}

    public Drawable getIconDrawable(){return iconDrawable;}
    public String getNameShop(){return  nameShop;}
    public String getPlace1Shop(){return place1Shop;}
    public String getKindOfShop(){
        return kindOfShop;
    }
    public String getPlace2Shop(){return  place2Shop;}
}
