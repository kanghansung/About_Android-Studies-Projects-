package org.techtown.socket;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }

    class ClientThread extends Thread{      //원래는 액티비티는 종료될 가능성이 있기 때문에 Thread가 아닌 Service를 사용하여 Background에서 돌리는 것이 안전함.
        public void run(){
            String host = "localhost";      //자기 자신을 나타냄.   어떤 컴퓨터로 들어가는지 IP를 지정해야 하는데 공부차원에서 내 컴퓨터이니 localhost로 한 것.
            int port = 5001;
            try {
                Socket socket = new Socket(host, port);         //서버로 접속하기 위해서는 Socket을 만들어야 함.

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());       //ouPutStream은 보내기 위한 통로를 만드는 것과 같음.
                outputStream.writeObject("안녕!");
                outputStream.flush();
                Log.d("ClientThread", "서버로 보냄.");

                //받는 부분이니 inputStream을 쓰는 것임.
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                final Object input = inputStream.readObject();
                Log.d("ClientThread", "받은 데이터: "+input);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("받은 데이: "+ input);
                    }
                });


            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
