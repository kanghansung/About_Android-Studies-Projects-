package org.techtown.spot_area_category;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentCategoryMenuBar extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentCategoryMenuBar = inflater.inflate(R.layout.fragment_menubar_category, container,false);

        LinearLayout cafe = (LinearLayout)fragmentCategoryMenuBar.findViewById(R.id.cafe);
        LinearLayout foodStore =( LinearLayout)fragmentCategoryMenuBar.findViewById(R.id.foodStore);
        LinearLayout place1 = (LinearLayout)fragmentCategoryMenuBar.findViewById(R.id.place1);
        LinearLayout place2 = (LinearLayout)fragmentCategoryMenuBar.findViewById(R.id.place2);
        LinearLayout tema = (LinearLayout)fragmentCategoryMenuBar.findViewById(R.id.tema);
        LinearLayout shopping = (LinearLayout) fragmentCategoryMenuBar.findViewById(R.id.shopping);

        final TextView txtCafe =(TextView)fragmentCategoryMenuBar.findViewById(R.id.txtCafe);
        final TextView txtFoodStore = (TextView)fragmentCategoryMenuBar.findViewById(R.id.txtFoodStore);
        final TextView txtPlace1 = (TextView)fragmentCategoryMenuBar.findViewById(R.id.txtPlace1);
        final TextView txtPlace2 = (TextView)fragmentCategoryMenuBar.findViewById(R.id.txtPlace2);
        final TextView txtTema = (TextView)fragmentCategoryMenuBar.findViewById(R.id.txtTema);
        final TextView txtShopping = (TextView)fragmentCategoryMenuBar.findViewById(R.id.txtShopping);

        final ImageView imgCafe = (ImageView)fragmentCategoryMenuBar.findViewById(R.id.imgCafe);
        final ImageView imgFoodStore = (ImageView)fragmentCategoryMenuBar.findViewById(R.id.imgFoodStore);
        final ImageView imgPlace1 = (ImageView)fragmentCategoryMenuBar.findViewById(R.id.imgPlace1);
        final ImageView imgPlace2 = (ImageView)fragmentCategoryMenuBar.findViewById(R.id.imgPlace2);


        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_white_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place2));

                txtCafe.setTextColor(Color.parseColor("#FFFFFF"));
                txtFoodStore.setTextColor(Color.parseColor("#000000"));
                txtPlace1.setTextColor(Color.parseColor("#000000"));
                txtPlace2.setTextColor(Color.parseColor("#000000"));
                txtTema.setTextColor(Color.parseColor("#000000"));
                txtShopping.setTextColor(Color.parseColor("#000000"));
            }
        });
        foodStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_white_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place2));

                txtCafe.setTextColor(Color.parseColor("#000000"));
                txtFoodStore.setTextColor(Color.parseColor("#ffffff"));
                txtPlace1.setTextColor(Color.parseColor("#000000"));
                txtPlace2.setTextColor(Color.parseColor("#000000"));
                txtTema.setTextColor(Color.parseColor("#000000"));
                txtShopping.setTextColor(Color.parseColor("#000000"));
            }
        });
        place1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_white_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place2));

                txtCafe.setTextColor(Color.parseColor("#000000"));
                txtFoodStore.setTextColor(Color.parseColor("#000000"));
                txtPlace1.setTextColor(Color.parseColor("#ffffff"));
                txtPlace2.setTextColor(Color.parseColor("#000000"));
                txtTema.setTextColor(Color.parseColor("#000000"));
                txtShopping.setTextColor(Color.parseColor("#000000"));

            }
        });
        place2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_white_place2));

                txtCafe.setTextColor(Color.parseColor("#000000"));
                txtFoodStore.setTextColor(Color.parseColor("#000000"));
                txtPlace1.setTextColor(Color.parseColor("#000000"));
                txtPlace2.setTextColor(Color.parseColor("#ffffff"));
                txtTema.setTextColor(Color.parseColor("#000000"));
                txtShopping.setTextColor(Color.parseColor("#000000"));
            }
        });
        tema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place2));

                txtCafe.setTextColor(Color.parseColor("#000000"));
                txtFoodStore.setTextColor(Color.parseColor("#000000"));
                txtPlace1.setTextColor(Color.parseColor("#000000"));
                txtPlace2.setTextColor(Color.parseColor("#000000"));
                txtTema.setTextColor(Color.parseColor("#ffffff"));
                txtShopping.setTextColor(Color.parseColor("#000000"));
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCafe.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_cafe));
                imgFoodStore.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_food));
                imgPlace1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place));
                imgPlace2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.icon_sky_place2));

                txtCafe.setTextColor(Color.parseColor("#000000"));
                txtFoodStore.setTextColor(Color.parseColor("#000000"));
                txtPlace1.setTextColor(Color.parseColor("#000000"));
                txtPlace2.setTextColor(Color.parseColor("#000000"));
                txtTema.setTextColor(Color.parseColor("#000000"));
                txtShopping.setTextColor(Color.parseColor("#ffffff"));
            }
        });


        return fragmentCategoryMenuBar;
    }
}
