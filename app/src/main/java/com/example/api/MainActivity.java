package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    String s = " ";
   TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        String url = "https://jsonplaceholder.typicode.com/todos";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                  json(response);
               /* ArrayList<String> arrayListtwo = new ArrayList<>();
                try {
                    for(int i=0;i<response.length();i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        s = jsonObject.getString("title");
                        Log.d("nu", "hi" + s);
                        arrayListtwo.add(s);
                        arrayList = arrayListtwo;

                    }*/

                }
               /* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(arrayAdapter);*/

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("json",error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);
       Log.d("my","hi"+s);


    }
    public void json(JSONArray response)
    {
        try {
            for(int i=0;i<response.length();i++) {
                JSONObject jsonObject = response.getJSONObject(i);
                s = jsonObject.getString("title");
                Log.d("nu", "hi" + s);
                arrayList.add(s);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

}