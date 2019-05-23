package org.techtown.myasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressTask progressTask = new ProgressTask();
                progressTask.execute("시작"); //안에 전달하는 파라미터값은 doInBackground 메서드로 전달됨.
            }
        });
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer>{

        @Override   //스레드에서 하는 일처리를 doInBackground에서 처리
        protected Integer doInBackground(String... strings) {
            int value = 0;
            while (true){
                if(value>=100)
                    break;

                value += 1;
                publishProgress(value);

//                int sleep = Double.valueOf((Math.random()*10000)%500).intValue();
                try{
                    Thread.sleep(200);
                } catch (Exception e){

                }
            }
            return null;
        }

        @Override   //doInBackground 메소드내에서 publishProgress()라는 메소드를 호출해서 onPostExecute에서 UI를 처리
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int value  = values[0].intValue();
            progressBar.setProgress(value);
            textView.setText(value+"%");
        }

        @Override   //스레드의 일이 끝났을 때 즉, doInBackground를 끝냈을 때 호출되는 메소드.
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(MainActivity.this, "AsyncTask 완료됨.", Toast.LENGTH_SHORT).show();
        }
    }
}
