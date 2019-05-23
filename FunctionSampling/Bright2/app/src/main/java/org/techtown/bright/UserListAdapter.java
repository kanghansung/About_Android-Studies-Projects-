package org.techtown.bright;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.net.URL;
import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList, saveList;
    private Activity parentActivity;

    public UserListAdapter(Context context, List<User> userList, List<User> saveList, Activity parentActivity){
        this.context = context;
        this.userList = userList;
        this.saveList = saveList;
        this.parentActivity = parentActivity;   //이 부분 중요!
    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i).getUserID();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
//        return null;
        View v = View.inflate(context, R.layout.user, null);
        final TextView idText = (TextView)v.findViewById(R.id.idText);
        TextView passwordText = (TextView)v.findViewById(R.id.passwordText);
        TextView nameText = (TextView)v.findViewById(R.id.nameText);
        TextView ageText = (TextView)v.findViewById(R.id.ageText);
        final TextView phoneText = (TextView)v.findViewById(R.id.phoneText);

        idText.setText(userList.get(i).getUserID().toString());
        passwordText.setText(userList.get(i).getUserPassword().toString());
        nameText.setText(userList.get(i).getUserName().toString());
        ageText.setText(userList.get(i).getUserAge());
        phoneText.setText(userList.get(i).getUserPhone().toString());

        v.setTag(userList.get(i).getUserID());

        Button deleteButton = (Button)v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Response.Listener<String>  listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                userList.remove(i);
                                for(int i=0;i<saveList.size();i++){
                                    if(saveList.get(i).getUserID().equals(idText.getText().toString())){
                                        saveList.remove(i);
                                        break;
                                    }
                                }
                            } else{

                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
            }
        });

        Button callButton = (Button)v.findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + userList.get(i).getUserPhone().toString()));
                    parentActivity.startActivity(intent);   //주의!
                }
                else{
                    ActivityCompat.requestPermissions(parentActivity, new String[]{Manifest.permission.CALL_PHONE}, 0);
                }
            }
        });

        return v;
    }
}
