package org.techtown.spot_place_list;

public class CustomData {
    String shopName;
    String shopPlace_1;
    String shopPlace_2;
    String kindOfShop;

    CustomData(){

    }
    CustomData(String shopName, String shopPlace_1, String shopPlace_2, String kindOfShop){
        this.shopName = shopName;
        this.shopPlace_1 = shopPlace_1;
        this.shopPlace_2 = shopPlace_2;
        this.kindOfShop = kindOfShop;
    }
    public void setShopName(String shopName){
        this.shopName = shopName;
    }
    public void setShopPlace_1(String shopPlace_1){
        this.shopPlace_1 = shopPlace_1;
    }
    public void setShopPlace_2(String shopPlace_2){
        this.shopPlace_2 = shopPlace_2;
    }
    public void setKindOfShop(String kindOfShop){
        this.kindOfShop = kindOfShop;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopPlace_1() {
        return shopPlace_1;
    }

    public String getShopPlace_2() {
        return shopPlace_2;
    }

    public String getKindOfShop() {
        return kindOfShop;
    }
}
