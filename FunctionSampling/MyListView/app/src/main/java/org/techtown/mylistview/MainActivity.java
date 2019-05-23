package org.techtown.mylistview;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText nameText, mobileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        final CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);
        adapter.addItem(new Singer("소녀시대", "010-1000-1000"));
        adapter.addItem(new Singer("걸스데이", "010-2000-2000"));
        adapter.addItem(new Singer("티아라", "010-3000-3000"));
        adapter.addItem(new Singer("여자친구", "010-4000-4000"));
        adapter.addItem(new Singer("애프터스쿨", "010-5000-5000"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), i+"번째 아이템이 눌림", Toast.LENGTH_SHORT).show();

                //클릭하면 전화거는 기능 구현 어떻게하지?
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("전화를 걸으시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phoneNumber = mobileText.getText().toString();
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                MainActivity.this.startActivity(intent);
                            }
                        });
            }
        });

        nameText = (EditText)findViewById(R.id.nameText);
        mobileText = (EditText)findViewById(R.id.mobileText);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String mobile = mobileText.getText().toString();
                mobile = mobile.substring(0,3)+"-"+mobile.substring(3,7)+"-"+mobile.substring(7);
                adapter.addItem(new Singer(name, mobile));
                adapter.notifyDataSetChanged();
            }
        });

    }

    class CustomAdapter extends BaseAdapter{
        ArrayList<Singer> list = new ArrayList<Singer>();

        public CustomAdapter() {
            super();
        }

        public void addItem(Singer item){
            list.add(item);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
//            SingerItemView v = new SingerItemView(getApplicationContext());
            //실무에서는 아래와 같이 쓰임.
            SingerItemView v = null;
            if(view == null){
                v = new SingerItemView(getApplicationContext());
            } else{
                v = (SingerItemView)view;
            }

            Singer item = list.get(i);
            v.setName(item.getName());
            v.setMobile(item.getMobile());

            return v;
        }
    }
}
