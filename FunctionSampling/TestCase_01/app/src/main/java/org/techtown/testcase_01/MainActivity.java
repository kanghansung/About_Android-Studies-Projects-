package org.techtown.testcase_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button startDivision, button10, button100, button1000;
    EditText setNumberOfPerson, setTotalMoney;
    int numberOfPerson=0, totalMoney=0, naMoney=0;
    int moneyPerPerson=0, danwi=1;

    TextView showOthersMoney, showTheOherMoney;
    LinearLayout showTheOherMoney_layout, showOthersMoney_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTheOherMoney_layout = (LinearLayout) findViewById(R.id.showTheOtherMoney_layout);
        showOthersMoney_layout = (LinearLayout) findViewById(R.id.showOthersMoney_layout);

        startDivision = (Button) findViewById(R.id.startDivision);
        button10 = (Button) findViewById(R.id.button10);
        button100 = (Button) findViewById(R.id.button100);
        button1000 = (Button) findViewById(R.id.button1000);

        setNumberOfPerson = (EditText) findViewById(R.id.setNumberOfPerson);
        setTotalMoney = (EditText) findViewById(R.id.setTotalMoney);

        showOthersMoney = (TextView) findViewById(R.id.showOthersMoney);
        showTheOherMoney = (TextView) findViewById(R.id.showTheOtherMoney);

        startDivision.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                String strMoney = setTotalMoney.getText().toString();
                String strPerson = setNumberOfPerson.getText().toString();

                totalMoney = Integer.parseInt(strMoney);
                numberOfPerson = Integer.parseInt(strPerson);

                moneyPerPerson = ((totalMoney/danwi)/numberOfPerson)*danwi;
                naMoney = moneyPerPerson+((totalMoney/danwi)%numberOfPerson)*danwi;

                if(naMoney>moneyPerPerson)
                    showTheOherMoney_layout.setVisibility(View.VISIBLE);
                else
                    showTheOherMoney_layout.setVisibility(View.INVISIBLE);

                showOthersMoney_layout.setVisibility(View.VISIBLE);

                showOthersMoney.setText(""+moneyPerPerson);
                showTheOherMoney.setText(""+naMoney);

            }
        });
        button10.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                danwi = 10;
            }
        });
        button100.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                danwi = 100;
            }
        });
        button1000.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                danwi = 1000;
            }
        });
    }
}
