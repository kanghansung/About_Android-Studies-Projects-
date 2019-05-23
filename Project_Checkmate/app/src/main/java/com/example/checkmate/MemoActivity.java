package com.example.checkmate;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemoActivity extends AppCompatActivity {
    ImageView imgSettingFont;
    ImageView imgSettingCheck;
    ImageView imgSettingAlign;
    ImageView imgSettingSave;
    TextView tvFont;
    TextView tvCheck;
    TextView tvAlign;
    TextView tvSave;
    TextView tvDate;
    EditText edtTodoName;

    ListView listView;
    MemoAdapter memoAdapter = new MemoAdapter();

    String dateAtLast = "";

    boolean isFont = false;
    boolean isCheck = false;
    boolean isAlign = false;

    DBHepler dbHepler_Memo = new DBHepler(MemoActivity.this, "memoTable.db", null, 1);
    DBHepler dbHepler_Todo = new DBHepler(MemoActivity.this, "todoTable.db", null, 1);

    Date date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<MemoItem> memoItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        initState();
        initListener();

        Toast.makeText(MemoActivity.this,dbHepler_Memo.getMemoItemArrayList(getIntent().getStringExtra("selectedTodoItem")).size()+"", Toast.LENGTH_SHORT).show();

    }

    private void initState(){

        imgSettingFont = (ImageView)findViewById(R.id.imgSettingFont);
        imgSettingCheck = (ImageView)findViewById(R.id.imgSettingCheck);
        imgSettingSave = (ImageView)findViewById(R.id.imgSettingSave);
        imgSettingAlign = (ImageView)findViewById(R.id.imgSettingAlign);

        tvFont = (TextView)findViewById(R.id.tvFont);
        tvCheck = (TextView)findViewById(R.id.tvCheck);
        tvAlign = (TextView)findViewById(R.id.tvAlign);
        tvSave = (TextView)findViewById(R.id.tvSave);
        tvDate = (TextView)findViewById(R.id.tvDate);
        edtTodoName = (EditText)findViewById(R.id.edtTodoName);

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(memoAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MemoActivity.this);
                builder.setTitle("")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dbHepler_Memo.deleteMemoList(memoItemArrayList.get(position).getMemoName());
                                memoItemArrayList.remove(position);
                                memoItemArrayList.notifyAll();
                                memoAdapter.notifyDataSetChanged();
                                showMemoItem();
                            }
                        })
                        .show();

                return true;
            }
        });

        ;
        tvDate.setText(getIntent().getStringExtra("todoDate"));

        showMemoItem();
    }

    private void initListener(){
        tvFont.setOnClickListener(menuListener);
        tvCheck.setOnClickListener(menuListener);
        tvAlign.setOnClickListener(menuListener);
        tvSave.setOnClickListener(menuListener);
    }

    View.OnClickListener menuListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.tvFont :
                    if(isFont) {
                        isFont = false;
                        imgSettingFont.setImageResource(R.drawable.setting_w);
                        tvFont.setTypeface(null,Typeface.NORMAL);
                    }
                    else {
                        isFont = true;
                        imgSettingFont.setImageResource(R.drawable.setting_b);
                        tvFont.setTypeface(null, Typeface.BOLD);
                    }
                    break;
                case  R.id.tvCheck:
                    if(isCheck) {
                        isCheck = false;
                        imgSettingCheck.setImageResource(R.drawable.setting_w);
                        tvCheck.setTypeface(null, Typeface.NORMAL);
                    }
                    else {
                        isCheck = true;
                        imgSettingCheck.setImageResource(R.drawable.setting_b);
                        tvCheck.setTypeface(null, Typeface.BOLD);
                    }

                    break;
                case R.id.tvAlign:
                    if(isAlign) {
                        isAlign = false;
                        imgSettingAlign.setImageResource(R.drawable.setting_w);
                        tvAlign.setTypeface(null, Typeface.NORMAL);
                    }
                    else {
                        isAlign = true;
                        imgSettingAlign.setImageResource(R.drawable.setting_b);
                        tvAlign.setTypeface(null, Typeface.BOLD);
                    }
                    break;
                case R.id.tvSave:
                    date = new Date(System.currentTimeMillis());
                    String mDate = dateFormat.format(date);
                    dbHepler_Memo.insertMemoList(getIntent().getStringExtra("selectedTodoItem"), edtTodoName.getText().toString(), mDate);
                    dbHepler_Todo.todoUpdateDate(getIntent().getStringExtra("selectedTodoItem"), mDate);

                    Toast.makeText(MemoActivity.this, memoItemArrayList.size()+"", Toast.LENGTH_SHORT).show();

                    showMemoItem();
                    Toast.makeText(MemoActivity.this,dbHepler_Memo.getMemoItemArrayList(getIntent().getStringExtra("selectedTodoItem")).size()+"", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void showMemoItem(){
        memoAdapter.deleteAll();
        memoItemArrayList.clear();
        memoItemArrayList = (ArrayList<MemoItem>) dbHepler_Memo.getMemoItemArrayList(getIntent().getStringExtra("selectedTodoItem")).clone();

        if(memoItemArrayList.size() == 0)
        {
            return;
        }

        for(int i=0;i<memoItemArrayList.size();i++)
        {
            memoAdapter.addItem(memoItemArrayList.get(i).getTodoName(), memoItemArrayList.get(i).getMemoName());
            memoAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK)
        {
            switch (resultCode)
            {
                case 3001:
                    dateAtLast = getIntent().getStringExtra("todoDate");
                    tvDate.setText(dateAtLast);
                    break;
                default:
                    break;
            }
        }
    }
}
