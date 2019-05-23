package org.techtown.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText number1 = findViewById(R.id.number1);
        final EditText number2 = findViewById(R.id.number2);
        final TextView txtResult = findViewById(R.id.txtResult);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());

                txtResult.setText(Integer.toString(n1+n2));
            }
        });
        Button btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());

                txtResult.setText(Integer.toString(n1*n2));
            }
        });
        Button btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());

                txtResult.setText(Integer.toString(n1/n2));
            }
        });
        Button btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());

                txtResult.setText(Integer.toString(n1-n2));
            }
        });
    }
}
