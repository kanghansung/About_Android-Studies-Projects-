package org.techtown.bright;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Button btnEnroll, btnShow, makeTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplication(), "BRIGHTENTRY.db",null,1);
        //온크리에이트 밖에 부분에 final로 지정하면안되나? dbhelper를?
        btnEnroll = (Button)findViewById(R.id.btnEnroll);
        btnShow = (Button)findViewById(R.id.btnShow);
        makeTeam = (Button)findViewById(R.id.makeTeam);

        final TextView managers =(TextView)findViewById(R.id.managers);
        final TextView members = (TextView)findViewById(R.id.members);

        final TextView team1 = (TextView)findViewById(R.id.team1);
        final TextView team2 = (TextView)findViewById(R.id.team2);
        final TextView team3 = (TextView)findViewById(R.id.team3);
        final TextView team4 = (TextView)findViewById(R.id.team4);

        managers.setText(dbHelper.showManagersName("O","o"));
        members.setText(dbHelper.showMembersName("X","x"));

        btnEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            int O = 46;
            int o = 78;
            int x = 120;
            int X = 88;
            @Override
            public void onClick(View view) {
                managers.setText(dbHelper.showManagersName("O", "o")); //아스키 코드로 대소문자 비교안하기
                members.setText(dbHelper.showMembersName("X", "x"));
            }
        });
//        String[] exam = new String[50];
//        int k=0;
//        exam = dbHelper.mixPersons();
//        for(int i=0;i<50;i++)
//            exam[i]="";
//        for (int i=0;i<50;i++)
//        {
//            if(exam[i]!="")
//            {
//                k++;
//            }
//        }
//        Toast.makeText(this, k, Toast.LENGTH_SHORT).show();
//        makeTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String[] persons = new String[50];
//                int num =0;
//                int limit1,limit2, limit3;
//                String teamMember1="", teamMember2="", teamMember3="", teamMember4="";
//                persons = dbHelper.mixPersons();
//                for(int i=0;i<persons.length;i++)
//                {
//                    if(persons[i]!="")
//                        num++;
//                    else
//                        break;
//                }
//                limit1 = num/4;
//                limit2 = num/2;
//                limit3 = num/(3/4);
//                //1조
//                for(int i=0;i<limit1/4;i++)
//                {
//                    teamMember1 +=""+persons[i]+"\n";
//                }
//                team1.setText(teamMember1);
//                //2조
//                for(int i=limit1/4;i<limit2/2;i++)
//                {
//                    teamMember2 += ""+persons[i]+"\n";
//                }
//                team2.setText(teamMember2);
//                //3조
//                for(int i=limit2;i<limit3;i++)
//                {
//                    teamMember3 += ""+persons[i]+"\n";
//                }
//                team3.setText(teamMember3);
//                //4조
//                for(int i=limit3;i<=num;i++)
//                {
//                    teamMember4 += ""+persons[i]+"\n";
//                }
//                team4.setText(teamMember4);
//            }
//        });
    }
}