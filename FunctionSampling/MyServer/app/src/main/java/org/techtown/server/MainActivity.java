package org.techtown.server;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //액티비티에서 돌리는 부분
//                ServerThread thread = new ServerThread();
//                thread.start();

                //서비스로 돌리는부분
                Intent intent = new Intent(getApplicationContext(), ChatService.class);
                startService(intent);

            }
        });
    }
    /*
    class ServerThread extends Thread {
        public void run(){
            int port = 5001;
            try {
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread", "서버가 실행됨.");

                while(true){    //서버는 값을 받고, 값을 클라이언트로 보냄.
                    Socket socket = server.accept();    //이 메소드(.accept)가 호출 되는 시점에 서버가 대기상태가 됨. 클라이언트가 접속을 하면 대응해주는게 Socket 객체이다.
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());            //들어오는 데이터를 처리하는것이 Stream이다 (=파이프)
                    Object input = inputStream.readObject();
                    Log.d("ServerThread", "input:"+input);

                    //클라이언트 쪽으로도 데이터를 보내는 부분.
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(input + "from Server");
                    outputStream.flush();                           //버퍼에 남아있을 수도 있으니 flush() 처리를 해줘야함.
                    Log.d("ServerThread", "output 보냄.");

                    socket.close();
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    */

}
