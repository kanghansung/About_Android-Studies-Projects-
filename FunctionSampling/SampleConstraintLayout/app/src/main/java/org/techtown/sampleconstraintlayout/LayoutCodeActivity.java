package org.techtown.sampleconstraintlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class LayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);   이부분 책에서는 없던데 왜 난 있지?

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,     //가로
                        LinearLayout.LayoutParams.WRAP_CONTENT);    //세로

        Button button01 = new Button(this);
        button01.setText("Button 01");
        button01.setLayoutParams(params);

        mainLayout.addView(button01);

        setContentView(mainLayout);
    }
}
