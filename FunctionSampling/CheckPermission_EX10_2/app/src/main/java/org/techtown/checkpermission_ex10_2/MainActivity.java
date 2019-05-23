package org.techtown.checkpermission_ex10_2;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDirectCall = (Button) findViewById(R.id.btnDirectCall);
        Button btnIndirectCall = (Button) findViewById(R.id.btnIndirectCall);

        final EditText etPhone = (EditText) findViewById(R.id.etPhone);

        final int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        btnDirectCall.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    //Manifest.permission.CaLL_PHONE이 접근 승낙 상태일 때
                    String phoneNumber = "tel:"+etPhone.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
                    startActivity(intent);
                }
                else
                {
                    //Manifest.permission.CALL_PHONE이 접근 거절 상태일 때
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                }

            }
        });
        btnIndirectCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber ="";

                phoneNumber = "tel:"+etPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                startActivity(intent);

            }
        });


    }
}
