package org.techtown.exercise6;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    //onCreate내에서 final EditText editText = (EditText)findViewById(R.id.editText);를 하면 에러가 나는데 이렇게, 이방식으로하면 왜에러가 안나지?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);
        Button btnpage = (Button) findViewById(R.id.btnpage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+data));
                startActivity(intent);
            }
        });

        btnpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}