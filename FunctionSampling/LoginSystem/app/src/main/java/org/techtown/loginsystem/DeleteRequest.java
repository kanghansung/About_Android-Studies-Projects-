package org.techtown.loginsystem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {
    final static private String URL = "http://xovndrkd.cafe24.com/Delete.php";
    private Map<String, String> parameters;

    DeleteRequest(String userID, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);   //userID라는 변수명으로 userID값을 받음.

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
