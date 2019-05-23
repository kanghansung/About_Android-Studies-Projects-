package org.techtown.mythread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button, button2;
    TextView textView2;
    Button button3;
    TextView textView3;
    Button button4;

    int value_thread = 0;
    ValueHandler handler = new ValueHandler();

    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        //스레드 시작시키는 버튼
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
        //스레드 진행값 보여주는 버튼
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("현재 값:"+value_thread);
            }
        });

        textView2 = (TextView)findViewById(R.id.textView2);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundHandlerThread backgroundHandlerThread = new BackgroundHandlerThread();
                backgroundHandlerThread.start();
            }
        });
        textView3 = (TextView)findViewById(R.id.textView3);
        button4 = (Button)findViewById(R.id.button4);
        button4 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    boolean running = false;
                    int value = 0;
                    public void run() {
                        running = true;
                        while(running){
                            value += 1;

                            handler2.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView3.setText("내부스레드 진행값:"+value);
                                }
                            });

                            try{
                                Thread.sleep(1000);
                            } catch (Exception e){

                            }

                        }
                    }
                }).start();
            }
        });

    }

    class ValueHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value_handler = bundle.getInt("value_handler");
            textView2.setText("핸들러진행값:"+value_handler);

        }
    }
    class BackgroundHandlerThread extends Thread{
        int value_handler = 0;
        boolean running= false;
        public void run(){
            running = true;
            while (running){

                value_handler += 1;

                Message message = handler.obtainMessage();      //2     message 객체 생성 부분
                Bundle bundle = new Bundle();                   //4     Bundle 객체 생성 -> 스레드값을 UI로 다루기 위해서는 handler로 값을 보내서 handler에서 UI를 접근 해야하기 때문에.
                bundle.putInt("value_handler", value_handler);  //5     bundle은 HashMap 같이 <키값, 데이터값>형식으로 담음.
                message.setData(bundle);                        //3     메세지로 데이터를 담을 때는, Bundle 객체로 담을수 있으며 setData()형식으로 bundle을 담음.
                handler.sendMessage(message);                   //1     전역 변수로 상단에서 ValueHandler handler = new ValueHandler();를 선언 되어 있음.

                try{
                    Thread.sleep(1000);
                } catch(Exception e){

                }
            }

        }
    }

    class BackgroundThread extends Thread{
        boolean running = false;
        public void run(){
            running = true;
            while(running)
            {
                value_thread += 1;

                try{
                    Thread.sleep(1000);
                } catch (Exception e){

                }

                if(value_thread == 100)
                    break;

            }
            Toast.makeText(getApplicationContext(), "BackgroundThread가 종료되었습니다. value_thread:"+value_thread, Toast.LENGTH_SHORT).show();
        }
    }
}
