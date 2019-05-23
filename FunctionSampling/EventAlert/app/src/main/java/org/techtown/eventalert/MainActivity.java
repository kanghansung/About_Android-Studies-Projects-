package org.techtown.eventalert;

import android.content.DialogInterface;
import android.support.annotation.MainThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] items = {"수박", "멜론", "참외", "망고"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //MainActivity.this or getContext() or this
                                                                                                    // getApplicationConText()일 때는 안되는데, 왜 MainActivity.this를 하면 되지?
                builder.setTitle("리스트");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); //getApplicationContext는 안됨. MainActivity.this만됨.
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료알림창")
                        .setCancelable(false) //사용자가 임의적으로 종료할수 없게함
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {   //yes버튼을 눌렀을 때, 이벤트처리
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {   //No 버튼을 눌렀을 때, 이벤트처리
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("종료알림창");
                alertDialog.show();
            }
        });
    }
}
