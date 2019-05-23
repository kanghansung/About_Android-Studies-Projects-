package org.techtown.exampledb_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplication(), "BRIGHTENTRY.db", null, 1);

        final TextView result = (TextView) findViewById(R.id.result);

        final EditText level = (EditText)findViewById(R.id.level);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText phone = (EditText)findViewById(R.id.phone);
        final EditText alpa = (EditText)findViewById(R.id.alpa);

        //DB에 데이터 추가한 후, 총 데이터 뿌려주기
        Button insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _level = level.getText().toString();
                String _name = name.getText().toString();
                String _phone = phone.getText().toString();
                String _alpa = alpa.getText().toString();

                dbHelper.insert(_level, _name, _phone, _alpa);
                result.setText(dbHelper.getResult());
            }
        });
        // 이름과 해당업무의 값을 받은 뒤, 이름에 해당하는 해당업무를 조정.
        Button update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name= name.getText().toString();
                String _level = level.getText().toString();
                String _alpa= alpa.getText().toString();

                dbHelper.update(_name, _level, _alpa);
                result.setText(dbHelper.getResult());
            }
        });

        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = name.getText().toString();

                dbHelper.delete(_name);
                result.setText(dbHelper.getResult());
            }
        });

        Button select = (Button)findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(dbHelper.getResult());
            }
        });
    }
}
