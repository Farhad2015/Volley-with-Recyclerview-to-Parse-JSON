package com.example.androiddevelopment.recyclerviewwithvolleyrnd.utils;

/**
 * Created by Android Development on 10/9/2016.
 */

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mrFARHAD on 10/11/2015.
 */
public class ServiceHelper extends Application {
    private RequestQueue requestQueue;
    private static ServiceHelper instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized ServiceHelper getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequest(Request request) {
        getRequestQueue().add(request);
    }
}
