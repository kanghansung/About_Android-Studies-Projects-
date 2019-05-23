package com.example.checkmate;

import android.content.Intent;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvNewFolder;
    TextView tvEdit;
    ListView listView;

    ImageView imgTopLogo;

    FolderAdapter folderAdapter = new FolderAdapter();
    DBHepler dbHepler = new DBHepler(MainActivity.this, "folderTable.db", null, 1);
    ArrayList<FolderItem> folderItemArrayList = new ArrayList<>();

    private boolean isTvEditPressed = false;
    private boolean isItemsSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        InitState();

        tvNewFolder.setOnClickListener(btnListener);
        tvEdit.setOnClickListener(btnListener);
        imgTopLogo.setOnClickListener(btnListener);
        tvEdit.setOnClickListener(btnListener);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!isTvEditPressed) {   // isTvEditPressed = false 일 때
                    Intent intent = new Intent(MainActivity.this, FolderPage.class);
                    FolderItem selectedItem = (FolderItem) folderAdapter.getItem(position);
                    Log.d("선택된 폴더", selectedItem.getFolderName());
                    intent.putExtra("selectedFolder", selectedItem.getFolderName());
                    setResult(RESULT_OK, intent);

                    startActivityForResult(intent, 3000);
                } else {    //isTvEditPressed = true 일 때
//                    FolderItem selectedItem = (FolderItem) folderAdapter.getItem(position);
//                    selectedItem.setImgIcon(!isItemsSelected);

                }
            }
        });

    }

    private void InitView(){
        tvNewFolder = (TextView)findViewById(R.id.tvNewFolder);
        imgTopLogo =(ImageView)findViewById(R.id.imgTopLogo);
        tvEdit = (TextView)findViewById(R.id.tvEdit);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(folderAdapter);

    }

    private void InitState(){
        folderItemArrayList = (ArrayList<FolderItem>) dbHepler.getFolderItemArrayListResult().clone();
        showFolderItems();
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.tvNewFolder:
                //Solution1
//                CustomDialog customDialog = new CustomDialog(MainActivity.this, folderAdapter, folderItemArrayList, dbHepler);
//                customDialog.callFunction(tvNewFolder);

//                Solution2
                    //CustomDialog 말고, CsDialog 방법을 사용 했음.
                    CsDialog dialog = new CsDialog(MainActivity.this);
                    dialog.setDialogListener(new CsDialog.CustomDialogListener() {
                        @Override
                        public void onPositiveClicked(String newFolderName) {
                            dbHepler.insertFolder(newFolderName);
                            showFolderItems();
                        }

                        @Override
                        public void onNegativeClicked() {

                        }
                    });
                    dialog.show();
                    break;

                case R.id.imgTopLogo:
                    Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                    startActivity(intent);
                    break;

                case R.id.tvEdit:
                    Toast.makeText(getApplicationContext(), isTvEditPressed+"", Toast.LENGTH_SHORT).show();
                    isTvEditPressed = !isTvEditPressed;
                    if(isTvEditPressed){
                        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
                    } else {
                        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                    }

                    break;

            }
        }
    };

    public void showFolderItems(){

        folderAdapter.deleteAll();
        folderItemArrayList.clear();
        folderItemArrayList = (ArrayList<FolderItem>) dbHepler.getFolderItemArrayListResult().clone();

        if(folderItemArrayList.size() == 0) {
            folderAdapter.notifyDataSetChanged();
            return;
        }

        int count = 0;
        while(folderItemArrayList.get(count)!=null){
            folderAdapter.addItem(folderItemArrayList.get(count++).getFolderName());
            folderAdapter.notifyDataSetChanged();

            if(count == dbHepler.foldersCount())
                break;
        }
    }

}

