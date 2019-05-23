package org.techtown.stringlistview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"망고 쥬스", "포도 쥬스", "토마토 쥬스"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView stringListView = (ListView)findViewById(R.id.stringListView);
        ListAdapter stringAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        stringListView.setAdapter(stringAdapter);

        stringListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
        //아래에서 강제종료 setCancle(false)가 뭔지 알아보기 위해서 임의로 생성
        EditText editABC = (EditText)findViewById(R.id.editABC);

        //이부분 머가 문제일까요
        ListView customListView = (ListView)findViewById(R.id.customListView);
        ListAdapter customAdapter = new CustomAdapter(this, items);
        customListView.setAdapter(customAdapter);

        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });


        Button btnExit = (Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("종료알림창")
                        .setCancelable(false)   //이게 정확히 뭔뜻 일까..?
                        .setMessage("정말로 종료하시겠습니까?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        }
}


