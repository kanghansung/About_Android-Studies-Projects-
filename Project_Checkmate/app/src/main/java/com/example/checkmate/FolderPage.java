package com.example.checkmate;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FolderPage extends AppCompatActivity {


    TextView tvSelectedFolderName;
    TextView tvNewFolder;
    TextView tvEdit;
    ListView listView;
    ListView listView2;

    ImageView imgTopLogo;

    TodoAdapter todoAdapter;
    TodoAdapter2 todoAdapter2;

    DBHepler dbHepler = new DBHepler(this, "todoTable.db", null, 1);
    ArrayList<TodoItem> todoItemArrayList = new ArrayList<>();

    Date date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");       // y=년도, M=월, d=일, m=분, s=초, h=시

    boolean isTvEditPressed = false;
    String selectedFolder = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_page);

        initView();
        initState();

        imgTopLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FolderPage.this, InformationActivity.class);
                startActivity(intent);
            }
        });

        tvNewFolder.setOnClickListener(btnListener);
        tvEdit.setOnClickListener(btnListener);
    }

    private void initView(){
        //메인 페이지에 폴더 리스트의 이름을 받아서 세팅
        tvSelectedFolderName = (TextView)findViewById(R.id.tvSelectedFolderName);
        tvSelectedFolderName.setText(getIntent().getStringExtra("selectedFolder"));
        //
        tvNewFolder = (TextView)findViewById(R.id.tvNewFolder);
        tvNewFolder.setText("작성");
        tvEdit = (TextView)findViewById(R.id.tvEdit);
        //리스트뷰 세팅
        listView = (ListView)findViewById(R.id.listView);
        todoAdapter = new TodoAdapter();
        listView.setAdapter(todoAdapter);

        listView2 = (ListView)findViewById(R.id.listView2);
        todoAdapter2 = new TodoAdapter2();
        listView2.setAdapter(todoAdapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FolderPage.this, MemoActivity.class);
                TodoItem2 selectedTodoItem = (TodoItem2)todoAdapter2.getItem(position);
                intent.putExtra("selectedTodoItem", selectedTodoItem.getTodoName());
                intent.putExtra("todoDate", selectedTodoItem.getDate());
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 3001);
            }
        });

        imgTopLogo = (ImageView)findViewById(R.id.imgTopLogo);
    }

    private void initState(){
        if(dbHepler.getTodoItemArrayListResult().size() != 0) {
            todoItemArrayList = (ArrayList<TodoItem>) dbHepler.getTodoItemArrayListResult().clone();
        }
        showTodoItem();
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.tvNewFolder:
                    if(!isTvEditPressed) {
                        CsDialog dialog = new CsDialog(FolderPage.this);
                        dialog.setDialogListener(new CsDialog.CustomDialogListener() {
                            @Override
                            public void onPositiveClicked(String newFolderName) {
                                date = new Date(System.currentTimeMillis());
                                String mDate = dateFormat.format(date);
                                dbHepler.insertTodo(newFolderName, getIntent().getStringExtra("selectedFolder"), mDate + "");     //형식만 newFolderName이지 투두 목록이름 넣는것
                                showTodoItem();
                            }

                            @Override
                            public void onNegativeClicked() {

                            }
                        });
                        dialog.show();
                    } else {
                        isTvEditPressed = !isTvEditPressed;
                        listView.setVisibility(View.GONE);
                        listView2.setVisibility(View.VISIBLE);
                        tvNewFolder.setText("새폴더");
                        tvEdit.setText("편집");
                        tvEdit.setTextColor(Color.parseColor("#262626"));
                        showTodoItem();
                    }
                    break;

                case R.id.tvEdit:
//                    Toast.makeText(getApplicationContext(), "편집 눌림", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
//                    startActivity(intent);
                    if(!isTvEditPressed)
                        isTvEditPressed = !isTvEditPressed;

                    if(isTvEditPressed){
                        listView2.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        tvEdit.setText("모두 삭제");
                        tvEdit.setTextColor(Color.parseColor("#FF7C7C"));
                        tvNewFolder.setText("취소");
                        showTodoItem();
                    }

                    break;

                default:
                    break;
            }
        }
    };

    private void showTodoItem(){
        todoAdapter.deleteAll();
        todoItemArrayList.clear();
        todoItemArrayList = (ArrayList<TodoItem>) dbHepler.getTodoItemArrayListResult(getIntent().getStringExtra("selectedFolder")).clone();

        todoAdapter2.deleteAll();

        Toast.makeText(FolderPage.this, getIntent().getStringExtra(selectedFolder), Toast.LENGTH_SHORT).show();

        if(todoItemArrayList.size() == 0) {
            todoAdapter.notifyDataSetChanged();
            todoAdapter2.notifyDataSetChanged();
            return;
        }

        for(int i=0; i<todoItemArrayList.size();i++){
            TodoItem selectedTodoItem = todoItemArrayList.get(i);
            todoAdapter.addItem(selectedTodoItem.getFolderName(), selectedTodoItem.getTodoName(), selectedTodoItem.getDate());
            todoAdapter2.addItem(selectedTodoItem.getFolderName(), selectedTodoItem.getTodoName(), selectedTodoItem.getDate());
            todoAdapter.notifyDataSetChanged();
            todoAdapter2.notifyDataSetChanged();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            switch (resultCode)
            {
                case 3000:
                    selectedFolder = getIntent().getStringExtra("selectedFolder");
                    tvSelectedFolderName.setText(selectedFolder);
                    break;
                default:
                    break;
            }
        }
    }
}
