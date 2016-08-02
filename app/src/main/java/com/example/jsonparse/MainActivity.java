package com.example.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private String jsonString = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
    private String jsonComplexString = "{\"students\":[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        //use json from java. try catch required for json stmt
        try { //create json array
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length() ; i++) {
                Log.d(TAG, "doMagic: " + i + " " + jsonArray.get(i));
                //create json object for json array and convert to string
                JSONObject jsonObject
                        = new JSONObject(jsonArray.get(i).toString());
                //add key from json structure
                String name = jsonObject.getString("name");
                String grade = jsonObject.getString("grade");
                String age = jsonObject.getString("age");
                Log.d(TAG, "doMagic: " + i + " " + name + " " + grade + " " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void doComplexMagic(View view) {
        try {
            JSONObject jsonObject = new JSONObject(jsonComplexString);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("students").toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = new JSONObject(jsonArray.get(i).toString());

                String name = student.getString("name");
                String grade = student.getString("grade");
                String age = student.getString("age");
                Log.d(TAG, "doComplexMagic: " + i + " " + name + " " + grade + " " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
