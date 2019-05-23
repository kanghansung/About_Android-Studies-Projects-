package org.techtown.myhttp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    String urlStr;
//    String line;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlStr = editText.getText().toString();
                RequestThread thread = new RequestThread();
                thread.start();
            }
        });
    }

    class RequestThread extends  Thread{
        public void run(){
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                if(conn != null){
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    int resCode = conn.getResponseCode();     //이 때 연결됨. 반환 타입은 int형으로 반환을 한다.
//                    if(resCode == HttpURLConnection.HTTP_OK)//반환하는 값을 HttpURLConnection.HTTP_OK라는 값과 같을 경우에 있으면 작동하려할때 넣고,
                                                                //우리는 단순히 작동 하는것을 원하므로 그냥 if문 없이 씀.
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    //연결한 부분에 input파이프를 얻고, 그 파이프에서 값을 얻는 객체인 InputStreamReader라는 것으로 감싸주고,
                    // 해당 얻어오는 값을 바이트단위가 아닌, 문자열 단위로 할것이므로 BufferReader라는 객체로 감싸 줌.
                    String line = null;
                    while(true){
                        line = reader.readLine();

                        if(line == null)
                            break;

                        println(line);

                        //해당 메소드(|println()|) 내에서 handler로 접근하는게 좀 더 코드가 깔끔함.
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                println(line);
//                            }
//                        });

                    }

                    reader.close();
                    conn.disconnect();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void println(final String data){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data+"\n");
            }
        });
    }
}
