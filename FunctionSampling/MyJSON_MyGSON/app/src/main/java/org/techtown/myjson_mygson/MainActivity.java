package org.techtown.myjson_mygson;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Button btnRequest, btnImgRequest;
    TextView textView;
    ImageView img;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
//        img = (ImageView)findViewById(R.id.img);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        btnRequest = (Button)findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
//                img.setVisibility(View.GONE);

                sendRequest();
            }
        });

        btnImgRequest = (Button)findViewById(R.id.btnImgRequest);
        btnImgRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.GONE);
//                img.setVisibility(View.VISIBLE);


                sendImageRequest();

            }
        });
    }

    public void sendRequest(){
        String urlStr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                urlStr,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        MovieResponse movieResponse = gson.fromJson(response, MovieResponse.class);

                        if(movieResponse != null) {
                            int countMovie = movieResponse.boxOfficeResult.dailyBoxOfficeList.size();
                            println("영화 개수 : " + countMovie);

                            for (int i = 0; i < countMovie; i++) {
                                println(i+1 + "번째 영화 이름:" + movieResponse.boxOfficeResult.dailyBoxOfficeList.get(i).movieNm.toString());
                            }
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println(error+"");
                    }
                }
        );

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청보냄....");

    }

    public void sendImageRequest(){
        String urlStr = "https://movie-phinf.pstatic.net/20181031_68/1540952503496fNRsF_JPEG/movie_image.jpg?type=m427_320_2";

//        Bitmap bitmap = new Bitmap();

    }

    public void println(String data){
        textView.append(data+"\n");
    }
}
