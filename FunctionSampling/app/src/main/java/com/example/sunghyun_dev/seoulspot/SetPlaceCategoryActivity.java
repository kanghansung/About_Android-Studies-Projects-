package com.example.sunghyun_dev.seoulspot;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SetPlaceCategoryActivity extends AppCompatActivity {
    Spinner spSetCatList;
    ArrayList<String> catList;
    ArrayAdapter spinnerAdapter;
    ImageView ivCafeTab;
    ImageView ivFoodTab;
    ImageView ivPlaceTab;
    ImageView ivThemeTab;
    ImageView ivShoppingTab;
    ImageView ivMuseumTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_place_category);

        spSetCatList=(Spinner)findViewById(R.id.spSetCatIist);
        ivCafeTab=(ImageView)findViewById(R.id.ivCafeTab);
        ivFoodTab=(ImageView)findViewById(R.id.ivFoodTab);
        ivMuseumTab=(ImageView)findViewById(R.id.ivMuseumTab);
        ivPlaceTab=(ImageView)findViewById(R.id.ivPlaceTab);
        ivThemeTab=(ImageView)findViewById(R.id.ivThemeTab);
        ivShoppingTab=(ImageView)findViewById(R.id.ivShoppingTab);


        catList=new ArrayList<String>();
        catList.add("카테고리 검색");
        catList.add("지역별 검색");

        setTab();

        spinnerAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, catList);
        spSetCatList.setAdapter(spinnerAdapter);
        spSetCatList.setSelection(0);

        spSetCatList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.WHITE);

                출처: http://es1015.tistory.com/205 [개발 / 폰꾸미기]
                Log.i("선택된아이템",""+spSetCatList.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void setTab(){
        ivCafeTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe1);
                ivFoodTab.setImageResource(R.drawable.menu_food0);
                ivMuseumTab.setImageResource(R.drawable.menu_museum0);
                ivPlaceTab.setImageResource(R.drawable.menu_place0);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping0);
                ivThemeTab.setImageResource(R.drawable.menu_theme0);
            }
        });

        ivFoodTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe0);
                ivFoodTab.setImageResource(R.drawable.menu_food1);
                ivMuseumTab.setImageResource(R.drawable.menu_museum0);
                ivPlaceTab.setImageResource(R.drawable.menu_place0);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping0);
                ivThemeTab.setImageResource(R.drawable.menu_theme0);
            }
        });
        ivMuseumTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe0);
                ivFoodTab.setImageResource(R.drawable.menu_food0);
                ivMuseumTab.setImageResource(R.drawable.menu_museum1);
                ivPlaceTab.setImageResource(R.drawable.menu_place0);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping0);
                ivThemeTab.setImageResource(R.drawable.menu_theme0);
            }
        });
        ivPlaceTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe0);
                ivFoodTab.setImageResource(R.drawable.menu_food0);
                ivMuseumTab.setImageResource(R.drawable.menu_museum0);
                ivPlaceTab.setImageResource(R.drawable.menu_place1);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping0);
                ivThemeTab.setImageResource(R.drawable.menu_theme0);
            }
        });
        ivShoppingTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe0);
                ivFoodTab.setImageResource(R.drawable.menu_food0);
                ivMuseumTab.setImageResource(R.drawable.menu_museum0);
                ivPlaceTab.setImageResource(R.drawable.menu_place0);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping1);
                ivThemeTab.setImageResource(R.drawable.menu_theme0);
            }
        });
        ivThemeTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCafeTab.setImageResource(R.drawable.menu_cafe0);
                ivFoodTab.setImageResource(R.drawable.menu_food0);
                ivMuseumTab.setImageResource(R.drawable.menu_museum0);
                ivPlaceTab.setImageResource(R.drawable.menu_place0);
                ivShoppingTab.setImageResource(R.drawable.menu_shopping0);
                ivThemeTab.setImageResource(R.drawable.menu_theme1);
            }
        });

    }
}
