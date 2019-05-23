package org.techtown.listview_customlistview;

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

        for(int i=0; i<10; i++){
            customAdapter.addItem(String.valueOf(i), String.valueOf(i+1));
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
    }
}
