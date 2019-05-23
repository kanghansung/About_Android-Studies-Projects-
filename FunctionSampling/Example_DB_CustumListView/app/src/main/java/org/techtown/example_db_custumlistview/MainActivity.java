package org.techtown.example_db_custumlistview;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "SHOP.db", null, 1);

        final EditText edtNameShop = (EditText)findViewById(R.id.edtNameShop);
        final EditText edtPlace1 = (EditText)findViewById(R.id.edtPlace1);
        final EditText edtKindOfShop = (EditText)findViewById(R.id.edtkindOfShop);
        final EditText edtPlace2 = (EditText)findViewById(R.id.edtPlace2);

        final ListView listView = (ListView)findViewById(R.id.listView);


        Button btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nameShop = edtNameShop.getText().toString();
                String _place1 = edtPlace1.getText().toString();
                String _kindOfShop = edtKindOfShop.getText().toString();
                String _place2 = edtPlace2.getText().toString();

                dbHelper.insert(_nameShop, _place1, _kindOfShop, _place2);
            }
        });


        Button btnShow = (Button)findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext());

                List<String> names = new ArrayList<>();
                names = dbHelper.getNameShop();
                List<String> places1 = new ArrayList<>();
                places1 = dbHelper.getPlace1();
                List<String> kindOfShops = new ArrayList<>();
                kindOfShops = dbHelper.getKindOfShop();
                List<String> places2 = new ArrayList<>();
                places2 = dbHelper.getPlace2();

                for(int i=0;i<dbHelper.getSize();i++)
                {
//                    customAdapter.addItem(dbHelper.getNameShop(i), dbHelper.getPlace1(i), dbHelper.getKindOfShop(i),dbHelper.getPlace2(i));
//                    CustomData customData = new CustomData(names.get(i), places1.get(i), kindOfShops.get(i), places2.get(i);
                    customAdapter.addItem(names.get(i), places1.get(i), kindOfShops.get(i), places2.get(i));
                }
                listView.setAdapter(customAdapter);
            }
        });

        Button btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameShop = edtNameShop.getText().toString();
                dbHelper.delete(nameShop);

            }
        });
        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameShop = edtNameShop.getText().toString();
                String place1 = edtPlace1.getText().toString();
                String kindOfShop = edtKindOfShop.getText().toString();
                String place2 = edtPlace2.getText().toString();

                dbHelper.update(nameShop, place1, kindOfShop, place2);
            }
        });

//        Button btnDataSize = (Button)findViewById(R.id.btnDataSize);
//        btnDataSize.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int size = dbHelper.getSize();
//
//                Toast.makeText(MainActivity.this, ""+size+"개", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
