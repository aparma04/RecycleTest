package com.anirudhparmar.recycletest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String URL_DATA = "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesData.txt";
    //recycler view objects
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Buisness> listItems;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        listItems = new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

        Log.d(TAG, "loadRecyclerViewData: Starts");

        //progress dialogue
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data ..");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,  // request from volley
                URL_DATA,
                //if success
                new Response.Listener<String>() {                           //type new and press ctrl + space
                    @Override
                    public void onResponse(String s) {    // get whole json in string s

                        progressDialog.dismiss();
                        Log.d(TAG, "onResponse: Starts");

                        try {
                            Log.d(TAG, "onResponse: try block starts");
                            JSONObject jsonObject = new JSONObject(s);
                            Log.d(TAG, "onResponse: json object created");
                            JSONArray array = jsonObject.getJSONArray("movies");   ///write your array name here if there is any
                            Log.d(TAG, "onResponse:  json object passed in array next is display");


                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                Buisness buisnessItem = new Buisness(
                                        o.getString("movie"),
                                        o.getString("story"),
                                        o.getString("director")
                                );

                                listItems.add(buisnessItem);
                            }

                            adapter = new MyAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            Log.d(TAG, "onResponse: Any errrrrrrrrrrrrrrrrrrrrrror occured");
                            e.printStackTrace();

                        }
                        Log.d(TAG, "onResponse: try block ends");
                    }
                },
                // if any error
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG);

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
