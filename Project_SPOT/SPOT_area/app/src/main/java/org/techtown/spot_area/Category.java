package org.techtown.spot_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView listView = (ListView)findViewById(R.id.listView);
        LinearLayout chooseKind = (LinearLayout)findViewById(R.id.chooseKind);
        chooseKind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Area_button.class);
                startActivity(intent);
            }
        });

        showListView();
    }
    public void showListView(){
        CustomAdapter customAdapter = new CustomAdapter(this);

        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(customAdapter);


    }
}
