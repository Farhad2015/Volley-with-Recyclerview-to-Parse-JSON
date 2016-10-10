package com.example.androiddevelopment.recyclerviewwithvolleyrnd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.androiddevelopment.recyclerviewwithvolleyrnd.adapter.DemoDataloadAdapter;
import com.example.androiddevelopment.recyclerviewwithvolleyrnd.model.DemoDataHandler;
import com.example.androiddevelopment.recyclerviewwithvolleyrnd.utils.ServiceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textViewNullView;
    RecyclerView recyclerViewDemo;
    DemoDataloadAdapter ddLoadAdapter;
    private List<DemoDataHandler> demoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewDemo = (RecyclerView)findViewById(R.id.rv_demoRecyclerview);
        textViewNullView =(TextView)findViewById(R.id.tv_mainactivity_emptyview);
        loadinaternetdata();
    }

    private void loadinaternetdata(){
        String linkrequest = "https://api.myjson.com/bins/4zr16";
        StringRequest stringRequest= new StringRequest(Request.Method.GET,linkrequest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("contacts");
                            for (int i =0; i<array.length(); i++){
                                JSONObject innerobj = array.getJSONObject(i);
                                String name = innerobj.getString("name");
                                String email = innerobj.getString("email");
                                String address = innerobj.getString("address");
                                DemoDataHandler dhandler = new DemoDataHandler();
                                dhandler.setUsername(name.toString().trim());
                                dhandler.setEmail(email.toString().trim());
                                dhandler.setAddress(address.toString().trim());
                                demoList.add(dhandler);
                            }
                            setRecyclerviewData();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Toast.makeText(getApplicationContext(),String.valueOf(volleyError),Toast.LENGTH_SHORT).show();

                    }
                });
        ServiceHelper.getInstance().addToRequest(stringRequest);
    }

    public void setRecyclerviewData(){
        if (demoList.size()>0){
            recyclerViewDemo.setVisibility(View.VISIBLE);
            textViewNullView.setVisibility(View.GONE);
            ddLoadAdapter = new DemoDataloadAdapter(demoList,MainActivity.this);
            ddLoadAdapter.notifyDataSetChanged();
            recyclerViewDemo.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewDemo.setAdapter(ddLoadAdapter);
        }else {
            recyclerViewDemo.setVisibility(View.GONE);
            textViewNullView.setVisibility(View.VISIBLE);
        }
    }
}
