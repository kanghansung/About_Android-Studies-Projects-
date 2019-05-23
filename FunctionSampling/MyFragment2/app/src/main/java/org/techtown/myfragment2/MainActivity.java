package org.techtown.myfragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment;
    ViewrFragment viewrFragment;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        listFragment = (ListFragment)manager.findFragmentById(R.id.listFragment);
        viewrFragment = (ViewrFragment)manager.findFragmentById(R.id.viewrFragment);


    }

    public void ChangeImage(int index){
        viewrFragment.setImage(index);
    }
}
