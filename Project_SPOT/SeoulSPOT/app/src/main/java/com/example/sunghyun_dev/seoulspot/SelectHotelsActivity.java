package com.example.sunghyun_dev.seoulspot;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunghyun_dev.seoulspot.SearchAddress.SearchItemAsyncTask;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectHotelsActivity extends AppCompatActivity {
    LinearLayout linHotelMapView;
    TextView tvSetHotel;
    TMapView tMapView;
    TMapData tMapData;
    String hotelName="";
    TMapPOIItem item;
    HashMap<String,String> location=null;

    JSONObject myLocation=null;
    SearchItemAsyncTask searchItemAsyncTask=null;

    TextView tvHotelName;
    TextView tvHotelAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hotels);

        linHotelMapView=(LinearLayout)findViewById(R.id.linHotelMapView);
        tvHotelName=(TextView)findViewById(R.id.tvHotelName);
        tvHotelAddress=(TextView)findViewById(R.id.tvHotelAddress);
        tvSetHotel=(TextView)findViewById(R.id.tvSetHotel);
        tMapData=new TMapData();

        tMapView=new TMapView(this);
        tMapView.setSKTMapApiKey("8c01e13b-978f-41bc-8629-b223245f9203");
        linHotelMapView.addView(tMapView);


        Intent intent=getIntent();
        hotelName=intent.getStringExtra("hotelName");

        tMapData.findAllPOI(hotelName, 1, new TMapData.FindAllPOIListenerCallback() {
            @Override
            public void onFindAllPOI(ArrayList<TMapPOIItem> arrayList) {
                item=arrayList.get(0);
                Log.i("POI Name: ", item.getPOIName().toString() + ", " +
                        "Address: " + item.getPOIAddress().replace("null", "")  + ", " +
                        "Point: " + item.getPOIPoint().toString());

                hotelName=item.getPOIName();
                TMapPoint tMapPoint= item.getPOIPoint();
                TMapMarkerItem tMapMarkerItem=new TMapMarkerItem();
                tMapMarkerItem.setTMapPoint(tMapPoint);
                tMapView.addMarkerItem(hotelName,tMapMarkerItem);
                tMapView.setCenterPoint(tMapPoint.getLongitude(),tMapPoint.getLatitude());

                location=new HashMap<String,String>();

                location.put("lat",""+tMapPoint.getLatitude());
                location.put("lon",""+tMapPoint.getLongitude());
                location.put("coordType","WGS84GEO");
                location.put("addressType","A02");
                location.put("callback","json");
                location.put("appKey","8c01e13b-978f-41bc-8629-b223245f9203");

                connectCheck(location);

            }
        });

        tvSetHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("hotelName",""+hotelName);
                setResult(RESULT_OK,intent);
                finish();
            }
        });



    }

    public void setLocation(JSONObject myLocation){
        this.myLocation=myLocation;

        tvHotelName.setText(""+hotelName);
        try {
            tvHotelAddress.setText(""+myLocation.getString("fullAddress"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void connectCheck(HashMap<String,String> location){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if((networkInfo!=null)&&networkInfo.isConnected()){
            searchItemAsyncTask=new SearchItemAsyncTask(location,this);
            searchItemAsyncTask.execute("");
        }else {
            Toast.makeText(getBaseContext(), "인터넷 연결상태를 확인해주세요", Toast.LENGTH_LONG).show();
        }
    }
}
