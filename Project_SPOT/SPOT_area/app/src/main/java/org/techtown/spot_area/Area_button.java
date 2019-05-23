package org.techtown.spot_area;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class Area_button extends AppCompatActivity {

    private  boolean isFragmentArea = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_button);

        ListView listView = (ListView)findViewById(R.id.listView);
        LinearLayout chooseKind = (LinearLayout)findViewById(R.id.chooseKind);
        Button btnselectArea = (Button)findViewById(R.id.btnSelectArea);

        chooseKind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment();
            }
        });

        btnselectArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FragmentAreaMenu.class);

            }
        });

        showlistView();
    }

    public void switchFragment(){
        Fragment fr;

        if(isFragmentArea){
            fr = new FragmentArea();
        }
    }
    public void showlistView(){
        CustomAdapter customAdapter = new CustomAdapter(this);

        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");
        customAdapter.addItem("복덕방", "마포구", "술집", "서울 마포구 망원동");

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
    }
    public void showAreaList(){
        Adapter_areaMenu adapter_areaMenu = new Adapter_areaMenu(this);

        adapter_areaMenu.addItem("가로수길");
        adapter_areaMenu.addItem("강남역");
        adapter_areaMenu.addItem("목동");
        adapter_areaMenu.addItem("사당역");
        adapter_areaMenu.addItem("삼성동");
        adapter_areaMenu.addItem("서래마을");
        adapter_areaMenu.addItem("선릉역");
        adapter_areaMenu.addItem("신논현역");
        adapter_areaMenu.addItem("신도림역");
        adapter_areaMenu.addItem("신림역");
        adapter_areaMenu.addItem("압구정역");
        adapter_areaMenu.addItem("여의도동");
        adapter_areaMenu.addItem("역삼역");
        adapter_areaMenu.addItem("영등포역");
        adapter_areaMenu.addItem("잠실동");
        adapter_areaMenu.addItem("청담동");
        adapter_areaMenu.addItem("건대입구");
        adapter_areaMenu.addItem("경리단길");
        adapter_areaMenu.addItem("광화문역");
        adapter_areaMenu.addItem("남대문시장");
        adapter_areaMenu.addItem("노원역");
        adapter_areaMenu.addItem("대학로");
        adapter_areaMenu.addItem("동대문역사공원역");
        adapter_areaMenu.addItem("명동");
        adapter_areaMenu.addItem("부암동");
        adapter_areaMenu.addItem("삼청동");
        adapter_areaMenu.addItem("서촌");
        adapter_areaMenu.addItem("성북구");
        adapter_areaMenu.addItem("성수역");
        adapter_areaMenu.addItem("수유역");
        adapter_areaMenu.addItem("신촌");
        adapter_areaMenu.addItem("연남동");
        adapter_areaMenu.addItem("이태원동");
        adapter_areaMenu.addItem("인사동");
        adapter_areaMenu.addItem("종각역");
        adapter_areaMenu.addItem("홍대입구역");
        adapter_areaMenu.addItem("회기동");

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter_areaMenu);
    }
}
