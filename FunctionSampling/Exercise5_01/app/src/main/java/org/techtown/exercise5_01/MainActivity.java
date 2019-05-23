package org.techtown.exercise5_01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static org.techtown.exercise5_01.R.*;
import static org.techtown.exercise5_01.R.layout;
import static org.techtown.exercise5_01.R.layout;
import static org.techtown.exercise5_01.R.layout.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);

        final LinearLayout container = (LinearLayout) findViewById(id.container);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.layout, container,true);

                Button buttonToast = (Button) container.findViewById(id.buttonToast);
                buttonToast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "inflation 과제 완료!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}