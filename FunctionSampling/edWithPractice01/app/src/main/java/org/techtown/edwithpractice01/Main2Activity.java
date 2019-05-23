package org.techtown.edwithpractice01;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class Main2Activity extends AppCompatActivity {

    EditText editUrl;
    TextView txtContent;
    Button btnToVolley, btnRequest;

    String address;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editUrl = (EditText)findViewById(R.id.editUrl);
        txtContent = (TextView)findViewById(R.id.txtContent);
        btnToVolley = (Button)findViewById(R.id.btnToVolley);
        btnToVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                Main2Activity.this.startActivity(intent);
            }
        });

        btnRequest = (Button)findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = editUrl.getText().toString();
                RequestThread thread = new RequestThread();
                thread.start();
            }
        });
    }

    class RequestThread extends Thread {
//        boolean running = false;

        public void run(){
            try {
                URL url = new URL(address);

                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if(con != null){
                    con.setConnectTimeout(10000);
                    con.setRequestMethod("GET");
                    con.setDoInput(true);
                    con.setDoOutput(true);

                    int resCode = con.getResponseCode();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line = null;
                    while(true){
                        line = reader.readLine();

                        if(line == null)
                            break;

                        println(line);
                    }

                    reader.close();
                    con.disconnect();
//                    if(resCode == HttpURLConnection.HTTP_OK){
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                        String line = null;
//
//                        while(true){
//                            line = reader.readLine();
//
//                            if(line == null)
//                                break;
//
//                            println(line);
//                        }
//
//                        reader.close();
//                        con.disconnect();
//                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void println(final String data){
//        txtContent.append(data+"\n");
        handler.post(new Runnable() {
            @Override
            public void run() {
                txtContent.append(data+"\n");
            }
        });
    }
}
