package org.techtown.exampleservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("서비스로 백그라운드에서 노래재생");

        final Intent intent = new Intent(getApplicationContext(), BackgroundMusic.class);
        final Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        final Button buttonStop = (Button)findViewById(R.id.buttonStop);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }
}
