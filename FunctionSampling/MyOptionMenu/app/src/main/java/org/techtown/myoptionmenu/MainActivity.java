package org.techtown.myoptionmenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //안드로이드의 기본 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        ActionBar abar = getSupportActionBar();
        abar.hide();

        return true;
    }

    //콜백메서드 ? 눌렷을때 호출되는 메서드이다.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int currentId = item.getItemId();

        switch (currentId){
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴 클릭 됨.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴 클릭 됨.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, "설정 메뉴 클릭 됨.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}