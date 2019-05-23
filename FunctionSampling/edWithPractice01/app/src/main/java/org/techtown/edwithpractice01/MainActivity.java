package org.techtown.edwithpractice01;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtThread, txtInnerThread, txtAsyncTask;
    Button button, btnInnerThread, btnThread, btnNotice, btnAsyncTask;

    Handler handler = new Handler();
    ThreadHandler threadHandler = new ThreadHandler();

    InnerThread innerThread = new InnerThread();

    ProgressBar progressBar;

    int value_seperate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //화면 넘기는 부분
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        //스레드 내에서 핸들러 까지 처리하는 부분
        txtInnerThread = (TextView)findViewById(R.id.txtInnerThread);
        btnInnerThread = (Button)findViewById(R.id.btnInnerThread);
        btnInnerThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(innerThread == null) {
//                    innerThread = new InnerThread();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "이미 InnerThread가 있습니다.", Toast.LENGTH_SHORT).show();
//                }
//                innerThread.start();

                InnerThread thread = new InnerThread();
                thread.start();
            }
        });

        //스레드, 핸들러 구분 부분
        txtThread = (TextView)findViewById(R.id.txtThread);
        btnThread = (Button)findViewById(R.id.btnThread);
        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandlerThread thread = new HandlerThread();
                thread.start();
            }
        });
        btnNotice = (Button)findViewById(R.id.btnNotice);
//        btnNotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtThread.setText("스레드, 핸들러 진행값:" +value_thread);
//            }
//        });

        //AsyncTask 구현 부분
        txtAsyncTask = (TextView)findViewById(R.id.txtAsyncTask);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btnAsyncTask = (Button)findViewById(R.id.btnAsyncTask);
        btnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressAsyncTask asyncTask = new ProgressAsyncTask();
                asyncTask.execute();
            }
        });
    }

    //AsyncTask로 메소드로 스레드, UI 접근 및 종료 후 콜백 메소드까지 처리.
    class ProgressAsyncTask extends AsyncTask<Integer, String, String> {
        int value = 0;

        @Override
        protected String doInBackground(Integer... integers) {

            while(true){
                value += 1;

                onProgressUpdate(value+"");

                try {
                    Thread.sleep(400);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(Integer.parseInt(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(getApplicationContext(), "AsyncTask 완료. "+value+"%", Toast.LENGTH_SHORT).show();
        }

    }

    //스레드, 핸들러 구분 구현  | 주의! 구분 구현 할때 각각의 클래스에서 만든 핸들러가 접근 해야 하므로 전역변수로 핸들러를 선언 후 사용.
    class HandlerThread extends Thread{
        boolean running = false;
        int value_thread = 0;
        public void run(){
            running = true;
            while(running) {
                value_thread += 1;

                if (value_thread > 100)
                    break;
                Message msg = threadHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value_thread", value_thread);
                msg.setData(bundle);
                threadHandler.sendMessage(msg);

                try {
                    Thread.sleep(400);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    class ThreadHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value_thread = bundle.getInt("value_thread");
            txtThread.setText("스레드, 핸들러 진행값: "+ value_thread);

        }
    }

    //스레드 내에서 핸들러까지 처리한 구현
    class InnerThread extends Thread{
        boolean running = false;
        int value = 0;
        public void run(){
            running = true;
            while(running) {
                value += 1;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtInnerThread.setText("내부스레드 진행값 :" + value);
                    }
                });
                try {
                    Thread.sleep(400);
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (value >= 100)
                    break;
            }
//            Toast.makeText(getApplicationContext(), "내부 스레드 진행완료 "+ value+"%", Toast.LENGTH_SHORT).show();

        }
    }
}
