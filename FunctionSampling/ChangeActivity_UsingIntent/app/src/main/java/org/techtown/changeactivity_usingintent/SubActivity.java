package org.techtown.changeactivity_usingintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView txtName = (TextView)findViewById(R.id.txtName);
        Intent intent = getIntent();

        txtName.setText(intent.getStringExtra("nameText").toString());
    }
}

