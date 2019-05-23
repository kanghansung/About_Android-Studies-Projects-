package org.techtown.bright;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    Button insert, delete, update, show, btnBackPage;
    TextView totalMembers;
    EditText etLevel, etName, etPhone, etAlpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final DBHelper dbHelper = new DBHelper(getApplication(), "BRIGHTENTRY.db", null,1);

        insert = (Button)findViewById(R.id.insert);
        delete = (Button)findViewById(R.id.delete);
        update = (Button)findViewById(R.id.update);
        show = (Button)findViewById(R.id.show);
        btnBackPage = (Button)findViewById(R.id.btnBackPage);

        etLevel = (EditText)findViewById(R.id.etLevel);
        etName = (EditText)findViewById(R.id.etName);
        etPhone =(EditText)findViewById(R.id.etPhone);
        etAlpa = (EditText)findViewById(R.id.etAlpa);

        totalMembers = (TextView)findViewById(R.id.totalMembers);

        totalMembers.setText(dbHelper.showData());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _level = etLevel.getText().toString();
                String _name = etName.getText().toString();
                String _phone = etPhone.getText().toString();
                String _alpa = etAlpa.getText().toString();

                dbHelper.insert(_level, _name, _phone, _alpa);
                totalMembers.setText(dbHelper.showData());
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _level = etLevel.getText().toString();
                String _name = etName.getText().toString();
                String _phone = etPhone.getText().toString();
                String _alpa = etAlpa.getText().toString();

                dbHelper.update(_name, _level, _phone, _alpa);
                totalMembers.setText(dbHelper.showData());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = etName.getText().toString();

                dbHelper.delete(_name);
                totalMembers.setText(dbHelper.showData());
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalMembers.setText(dbHelper.showData());
            }
        });
        btnBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}