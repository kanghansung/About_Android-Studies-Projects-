package org.techtown.exercise_05;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);

        final LinearLayout container = (LinearLayout) findViewById(R.id.container);
        final LinearLayout menu_parentLayout = (LinearLayout) findViewById(R.id.menu_parentLayout);
        final LinearLayout menu_layout1 = (LinearLayout) findViewById(R.id.menu_layout1);
        final LinearLayout menu_layout2 = (LinearLayout) findViewById(R.id.menu_layout2);
        final LinearLayout menu_layout3 = (LinearLayout) findViewById(R.id.menu_layout3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.layout_user, container, true);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.layout_file, container, true);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_layout_share, container, true);

                Button btnMut = (Button)container.findViewById(R.id.btnMut);
                Button btnUSer = (Button)container.findViewById(R.id.btnUser);


                btnMut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(getApplicationContext(), "맨체스터의 주인은 맨유입니다.",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                btnUSer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(getApplicationContext(), "니 정보를 왜 공유해..?", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });
    }
}
