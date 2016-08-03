package com.example.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private String jsonString = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
    private String jsonComplexString = "{\"students\":[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]}";
    private ListView mListView;

   private List<String> dataList =
           Arrays.asList(jsonComplexString);

    private ArrayAdapter<String> arrayAdapter;

    private ArrayList<String> dataArrayList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.mList);

        Gson gson = new GsonBuilder().create();
        //Type listType = new TypeToken<List<ListItem>>() {}.getType();
        Result result = gson.fromJson(jsonComplexString, Result.class);

        for (Student student : result.students) {
            if (true) {
                dataArrayList.add(student.name + " " + student.grade + " " + student.age);
            }
            Log.d(TAG, "doGSONComplexMagic: " + student.name + " " + student.grade + " " + student.age);
        }

            arrayAdapter =
                new ArrayAdapter<String>(
                        this,
                        //android.R.layout.simple_list_item_1, used for default android layout, code below for custom
                        //android.R.layout.activity_list_item,
                        R.layout.activity_list_item,
                        R.id.l_item_txt,
                        dataArrayList);

        //attach adapter to listview
        mListView.setAdapter(arrayAdapter);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        View customView = inflater.inflate(R.layout.activity_list_item, parent, false);

        TextView textView = (TextView) customView.findViewById(R.id.l_item_txt);

    return customView;
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

    public void doGSONMagic(View view) {
        //gson library to build array list
        //create gson object from array list of students
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<Student>>() {}.getType();

        //use listype for array not gor object
        ArrayList<Student> students = gson.fromJson(jsonString, listType);
        for (Student student : students) {
            Log.d(TAG, "doGSONMagic: " + student.name + " " + student.grade + " " + student.age);
        }
    }

    public void doGSONComplexMagic(View view) {
        Gson gson = new GsonBuilder().create();
        Result result = gson.fromJson(jsonComplexString, Result.class);

        //get a single object called result
        for (Student student : result.students) {
            if (true) {

            }
            Log.d(TAG, "doGSONComplexMagic: " + student.name + " " + student.grade + " " + student.age);
        }
    }
}
