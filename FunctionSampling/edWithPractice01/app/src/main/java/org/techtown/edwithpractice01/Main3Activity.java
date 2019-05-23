package org.techtown.edwithpractice01;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    Button btnA;
    TextView txtA;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtA = (TextView)findViewById(R.id.txtA);
        btnA = (Button)findViewById(R.id.btnA);

        queue = Volley.newRequestQueue(getApplicationContext());

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.google.co.kr";
                StringRequest request = new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                println("요청 됨 -> " + response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                println("에러 발생 -> " + error);
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters  = new HashMap<String, String>();

                        return parameters;
                    }
                };

                request.setShouldCache(false);
                queue.add(request);
                println("요청 보냄....");

                //아래는 메소드 호출로 외부 메소드에서 위에 내용을 정리.
//                sendRequest();

            }
        });
    }

    public void sendRequest(){
        String url = "http://www.google.co.kr";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("요청 됨 -> " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 발생 -> " + error);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameter = new HashMap<>();

                return parameter;
            }
        };

        request.setShouldCache(false);
        queue.add(request);
        println("요청 보냄....");

    }

    public void println(String data){
        txtA.append(data+"\n");
    }
}
