package com.example.checkmate;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomDialog {

    private Context context;
    private FolderAdapter folderAdapter;
    private ArrayList<FolderItem> folderItemArrayList;
    DBHepler dbHepler;


    public CustomDialog(Context context, FolderAdapter folderAdapter, ArrayList<FolderItem> folderItemArrayList, DBHepler dbHepler){
        this.context = context;
        this.folderAdapter = folderAdapter;
        this.folderItemArrayList = folderItemArrayList;
        this.dbHepler = dbHepler;
    }

    public void callFunction(TextView tvNewFolder){
        //커스텀 다이얼로그를 정의하기 위해 Dialog클래스를 생성한다.
        final Dialog dig = new Dialog(context);

        //액티비티의 타이틀바를 숨긴다.
        dig.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //커스텀 다이얼로그의 레이아웃을 설정한다.
        dig.setContentView(R.layout.custom_dialog);

        //커스텀 다이얼로그 호출
        dig.show();

        final EditText newFolderName = (EditText)dig.findViewById(R.id.edtNewFolderName);
        final TextView tvNegativeButton = (TextView)dig.findViewById(R.id.tvNegativeButton);
        final TextView tvPositiveButton = (TextView)dig.findViewById(R.id.tvPositiveButton);

        tvNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "취소버튼클릭", Toast.LENGTH_SHORT).show();

                dig.dismiss();      //커스텀 다이얼로그 종료
            }
        });

        tvPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "저장버튼클릭", Toast.LENGTH_SHORT).show();

                dbHepler.insertFolder(newFolderName.getText().toString());
                folderItemArrayList.clear();
                folderItemArrayList = (ArrayList<FolderItem>) dbHepler.getFolderItemArrayListResult().clone();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        for(int i=0;i<dbHepler.getFolderItemArrayListResult().size();i++){
                            folderAdapter.deleteAll();
                            folderAdapter.addItem(folderItemArrayList.get(i).getFolderName());
                            folderAdapter.notifyDataSetChanged();

                        }
                    }
                };
                dbHepler.close();

                dig.dismiss();
            }
        });
    }
}
