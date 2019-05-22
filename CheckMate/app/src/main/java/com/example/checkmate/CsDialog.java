package com.example.checkmate;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CsDialog extends Dialog {
    private TextView positiveButton;
    private TextView negativeButton;
    private EditText newFolderName;

    private Context context;
    private CustomDialogListener customDialogListener;

    public CsDialog(Context context){
        super(context);
        this.context = context;
    }

    interface CustomDialogListener{
        void onPositiveClicked(String newFolderName);
        void onNegativeClicked();
    }

    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        positiveButton = (TextView)findViewById(R.id.tvPositiveButton);
        negativeButton = (TextView)findViewById(R.id.tvNegativeButton);
        newFolderName = (EditText)findViewById(R.id.edtNewFolderName);

        positiveButton.setOnClickListener(btnListener);
        negativeButton.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.tvPositiveButton:
                    String folderName = newFolderName.getText().toString();
                    customDialogListener.onPositiveClicked(folderName);
                    dismiss();
                    break;
                case R.id.tvNegativeButton:
                    cancel();
                    break;
            }
        }
    };
}
