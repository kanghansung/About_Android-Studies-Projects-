package org.techtown.listview_ex_10;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView)findViewById(R.id.listView);
        final TextView selected_item_textView = (TextView)findViewById(R.id.selected_item_textView);
        Button btnResult = (Button)findViewById(R.id.btnResult);

        //데이터를 저장하게 되는 리스트.     ArrayList로 지정해서 내가 원하는 형태를 뿌려줄 수 도 있음.
        List<String> list = new ArrayList<>();
        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        //리스트뷰의 어댑터를 지정해준다.
        listView.setAdapter(adapter);

        //리스트뷰의 아이템을 클릭시 해당 아이템의 문자열을 가져오기 위한 처리.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //클릭한 아이템의 문자열을 가져옴.  파라미터값으로 int형 'i'가 들어감!
                String selected_item = (String)adapterView.getItemAtPosition(i);

                //텍스트뷰에 출력.
                selected_item_textView.setText(selected_item);
            }
        });

        //리스트뷰에 보여질 아이템을 추가
        list.add("강한성");
        list.add("김성현");
        list.add("고진우");
        list.add("이승희");
        list.add("김혜연");
        list.add("김세희");

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<String> selectedItems = new ArrayList<>();
                
                //리스트뷰에서 선택된 아이템의 목록을 가져온다.
                SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
                for(int i=0; i<checkedItemPositions.size();i++)
                {
                    int pos = checkedItemPositions.keyAt(i);

                    if(checkedItemPositions.valueAt(i))
                        selectedItems.add(listView.getItemAtPosition(pos).toString());
                }

                final CharSequence[] items = selectedItems.toArray(new String[selectedItems.size()]);
                
                //다이얼 로그에 가져온 목록을 보여준다.
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);     //다이얼로그(창띄우기)를 화면 MainActivity에 생성.
                dialogBuilder.setTitle("선택한 항목");
                dialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selectedText = items[i].toString();

                        Toast.makeText(MainActivity.this, selectedText, Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialogObject = dialogBuilder.create();
                alertDialogObject.show();
            }
        });
    }
}
