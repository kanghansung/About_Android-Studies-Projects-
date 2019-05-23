package org.techtown.examplefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private boolean isFragmentB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment();
            }
        });
        //JAVA코드에서 Fragment를 다룰 때는 FragmentManager와 FragmentTransanction클래스를 사용.

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentBorC, new FragmentB());
        fragmentTransaction.commit();
    }

    public void  switchFragment(){
        Fragment fr;

        if(isFragmentB){
            fr = new FragmentB();
        }
        else{
            fr = new FragmentC();
        }
        isFragmentB = (isFragmentB) ? false : true; //isFragment가 true면 false, false면 후자인 true로

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }
}
