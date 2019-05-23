package org.techtown.sample_tmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("8736cbc0-8561-44a5-b960-fcf319d53b70");
        linearLayoutTmap.addView(tMapView);

        TMapPoint tmapPoint = new TMapPoint(37.358019, 126.93296899999996);
        TMapMarkerItem item = new TMapMarkerItem();
        item.setTMapPoint(tmapPoint);
        item.setName("산본역");
        item.setVisible(TMapMarkerItem.VISIBLE);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.black_marker);
        item.setIcon(bitmap);

        item.setPosition(0.5f, 1.0f);
        tMapView.addMarkerItem("우리동네",item);

        tMapView.setCenterPoint(126.93296899999996, 37.358019);
    }
}
