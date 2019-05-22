package com.example.checkmate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class CheckMateActivity extends AppCompatActivity {

    Handler handler;
    RelativeLayout landingBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_mate);

        landingBox = (RelativeLayout)findViewById(R.id.landingBox);
        handler = new Handler();
        handler.postDelayed(new CheckMateHandler(), 1000);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class CheckMateHandler implements Runnable{

        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            CheckMateActivity.this.finish();
        }
    }
}
