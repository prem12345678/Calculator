package com.eventhandling.example.lenovo.event_handling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView v1;
    TextView t;
    String str[] = {"abhishek","abhimanu","abhisham","billu","chirag","chkshu","dinesh","dolber","prem","nidhi","sheela"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        v1=findViewById(R.id.lv1);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,str);
        v1.setAdapter(adapter);
        v1.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView t=(TextView)view;
        Toast.makeText(this, t.getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_user,menu);
        return true;
    }
}
