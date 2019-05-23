package org.techtown.bright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    LinearLayout adminLayout;
    Button noticeButton, manageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminLayout = (LinearLayout)findViewById(R.id.adminLayout);
        noticeButton = (Button)findViewById(R.id.noticeButton);
        manageButton = (Button)findViewById(R.id.manageButton);


    }
}
