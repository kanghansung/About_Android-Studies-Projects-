package com.example.sunghyun_dev.seoulspot.SearchAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SearchManager {

    URL url=null;
    HttpURLConnection httpURLConnection=null;
    BufferedReader bufferedReader=null;
    HashMap<String,String> myAddress=null;
    String params="";
    String data="";
    HashMap<String,String> searchItem=null;
    static final String MY_ADDRESS_URL="https://api2.sktelecom.com/tmap/geo/reversegeocoding?version=1&";

    public SearchManager(HashMap<String,String> searchItem){
        this.searchItem=searchItem;

        double lat=Double.parseDouble(searchItem.get("lat").toString());
        double lon=Double.parseDouble(searchItem.get("lon").toString());
        String coordType=searchItem.get("coordType").toString();
        String addressType=searchItem.get("addressType").toString();
        String callback=searchItem.get("callback").toString();
        String appKey=searchItem.get("appKey").toString();

        params="lat="+lat+"&lon="+lon+"&coordType="+coordType+"&addressType="+addressType+"&callback="+callback+"&appKey="+appKey;

        try {
            url=new URL(MY_ADDRESS_URL+params);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String connect(){
        String line="";

        try {
            httpURLConnection.connect();

            InputStream inputStream=httpURLConnection.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            while((line=bufferedReader.readLine())!=null){
                data+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}


/*
public LoadManager(HashMap<String, String> reqRoad) {
        this.reqRoad = reqRoad;
        double startX = Double.parseDouble(reqRoad.get("startX").toString());
        double startY = Double.parseDouble(reqRoad.get("startY").toString());
        double endX = Double.parseDouble(reqRoad.get("endX").toString());
        double endY = Double.parseDouble(reqRoad.get("endY").toString());
        String type = "WGS84GEO";
        String startName = reqRoad.get("startName").toString();
        String endName = reqRoad.get("endName").toString();

        params = "&startX="+startX+"&startY="+startY+"&endX="+endX+"&endY="+endY+"&reqCoordType="+type+"&resCoordType="+type+"&startName="+startName+"&endName="+endName;
        try {
            url = new URL(REQUEST_ROAD_URL+params);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("appKey", "162abb42-0997-3f66-bf86-402b6894c4f6");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

 */