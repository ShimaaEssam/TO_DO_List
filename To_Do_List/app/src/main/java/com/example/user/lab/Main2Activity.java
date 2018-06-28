package com.example.user.lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String[] myarr=getResources().getStringArray(R.array.grid);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myarr);
        GridView gv=(GridView)findViewById(R.id.gridView);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView View=(TextView)view;
                String value=View.getText().toString();
                if(Character.isLowerCase(value.charAt(0)))
                {
                    View.setText(value.toUpperCase());
                }
                else if(Character.isUpperCase(value.charAt(0)))
                {
                    View.setText(value.toLowerCase());
                }
            }
        });


    }
}
