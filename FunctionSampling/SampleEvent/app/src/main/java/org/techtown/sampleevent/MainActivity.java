package org.techtown.sampleevent;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.DriverManager.println;
import static org.techtown.sampleevent.R.*;
import static org.techtown.sampleevent.R.id.*;

public class MainActivity extends AppCompatActivity {

    private int KeyCode;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(KeyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "시스템[BACK] 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        GestureDetector detector;

        View view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener(){
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent){
              int action = motionEvent.getAction();

              float curX = motionEvent.getX();
              float curY = motionEvent.getY();

              if(action == MotionEvent.ACTION_DOWN){
                  println("손가락 눌림: "+curX+", "+curY);
              } else if(action == MotionEvent.ACTION_MOVE){
                  println("손가락 움직임 : "+curX+", "+ curY);
              } else if(action == motionEvent.ACTION_UP){
                  println("손가락 뗌:"+curX+", "+ curY);
              }
              return true;
          }
            //책이랑 다른부분에 메소드가 추가되네?
            private void println(String s) {
                String data= s;
                textView.append(data+"\n");
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨.");

                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨.");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingTapUp() 호출됨.");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨 : "+v +", "+ v1);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨:"+v+", "+v1);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Dialog dectector = null;
                dectector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }
}
