package org.techtown.bright;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class NoticeRequest extends StringRequest {
    static private String URL = "http://xovndrkd.cafe24.com/Notice.php";
    private Map<String, String> parameters;

    NoticeRequest(String notice, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("notice", notice);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
