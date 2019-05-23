package org.techtown.exercise7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "onCreate() Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(), "onStart() Call", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume() Call", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause() Call", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop() Call", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestory() Call", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
