package org.techtown.spot_place_list;

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

    private  void setListView(){
        CustomAdapter customAdapter = new CustomAdapter(this);

        customAdapter.addItem("복덕방", "마포구", "서울마포구망월동","술집");
        customAdapter.addItem("복덕방", "마포구", "서울마포구망월동","술집");
        customAdapter.addItem("복덕방", "마포구", "서울마포구망월동","술집");
        customAdapter.addItem("복덕방", "마포구", "서울마포구망월동","술집");
        customAdapter.addItem("복덕방", "마포구", "서울마포구망월동","술집");


        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
    }
}
