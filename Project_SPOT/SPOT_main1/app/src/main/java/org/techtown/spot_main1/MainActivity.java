package org.techtown.spot_main1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListView();
    }
    private void setListView(){
        CustomAdapter customAdapter = new CustomAdapter(this);

        customAdapter.addItem("08.21-08.24", "서울 하얏트 호텔", "3", "32.0");
        customAdapter.addItem("08.21-08.24", "서울 하얏트 호텔", "3", "32.0");

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

    }
}
