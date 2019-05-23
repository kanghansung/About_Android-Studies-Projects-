package com.example.sunghyun_dev.seoulspot.SearchAddress;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sunghyun_dev.seoulspot.SelectHotelsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SearchItemAsyncTask extends AsyncTask<String,Integer,String> {
    SearchManager searchManager=null;
    String myLocation=null;
    int jsonCount=0;
    SelectHotelsActivity selectHotelsActivity=null;

    public SearchItemAsyncTask(HashMap<String,String> location, SelectHotelsActivity selectHotelsActivity){
        searchManager=new SearchManager(location);
        this.selectHotelsActivity=selectHotelsActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... strings) {
        myLocation=searchManager.connect();
        Log.i("json 결과",""+myLocation);
        return myLocation;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        JSONArray jsonArray=null;
        try {
            JSONObject total=new JSONObject(s);
            Log.i("결과체크",""+total);
            System.out.print(total);
            JSONObject jsonObject=new JSONObject(String.valueOf(total.get("addressInfo")));
            Log.i("결과체크",""+jsonObject);

            selectHotelsActivity.setLocation(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
