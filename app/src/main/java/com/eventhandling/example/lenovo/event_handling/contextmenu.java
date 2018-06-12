package com.eventhandling.example.lenovo.event_handling;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class contextmenu extends Activity implements AdapterView.OnItemClickListener
{
     ListView listv;
     String name[] = {"abhishek","anand","ahuja","anderson","bristal","ketty","alisha","akash","prem"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextmenu);
        listv =findViewById(R.id.lv1);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,name);
       listv.setAdapter(adapter);
       listv.setOnItemClickListener(this);
registerForContextMenu(listv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("select");
        menu.add(0,0,1,1);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
