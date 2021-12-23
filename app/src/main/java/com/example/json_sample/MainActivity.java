package com.example.json_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "sample.json");
        String jsonFileString_2 = Utils.getJsonFromAssets(getApplicationContext(), "sample2.json");

        TextView textView = findViewById(R.id.result_text);
        textView.setText(jsonFileString);

        try{
            JSONObject json = new JSONObject(jsonFileString);
            String data_1 = json.getString("sample");
            Log.d("テスト:sample", data_1);

            JSONArray datas = json.getJSONArray("sample");
            for(int i = 0; i < datas.length(); i++){
                JSONObject data = datas.getJSONObject(i);
                String name = data.getString("name");
                Log.d("テスト:name"+i, name);
            }

            JSONObject json2 = new JSONObject(jsonFileString_2);
            String japan = json2.getJSONObject("data").getJSONObject("world").getString("japan");
            Log.d("テスト:japan", japan);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}