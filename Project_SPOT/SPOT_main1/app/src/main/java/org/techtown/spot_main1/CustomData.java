package org.techtown.spot_main1;

public class CustomData {
    String duringdate;
    String nameHotel;
    String num;
    String money;

    CustomData(){

    }
    CustomData(String duringdate, String nameHotel, String num, String money ){
        this.duringdate = duringdate;
        this.nameHotel = nameHotel;
        this.num = num;
        this.money = money;
    }
    public void setDuringdate(String duringdate){
        this.duringdate = duringdate;
    }
    public void setNameHotel(String nameHotel){
        this.nameHotel = nameHotel;
    }
    public void setNum(String num){
        this.num = num;
    }
    public void setMoney(String money){
        this.money = money;
    }
    public String getDuringdate() {
        return duringdate;
    }
    public String getNameHotel(){
        return nameHotel;
    }
    public String getNum(){
        return num;
    }
    public String getMoney(){
        return  money;
    }
}
