package com.example.user.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mylist=(ListView)findViewById(R.id.listView);
        final ArrayAdapter<String>listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        mylist.setAdapter(listAdapter);
        Button add=(Button)findViewById(R.id.button);
        add.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myItem =(EditText)findViewById(R.id.editText);
                String value=myItem.getText().toString();
                listAdapter.add(value);
                myItem.getText().clear();
            }
        }));
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView)arg1).getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        Button grid=(Button)findViewById(R.id.button2);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
       mylist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listAdapter.getItem(position);
                listAdapter.remove(item);
                listAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }
}
