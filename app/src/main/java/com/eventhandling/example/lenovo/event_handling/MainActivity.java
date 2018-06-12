package com.eventhandling.example.lenovo.event_handling;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    EditText e1,e2;
    Button b1,b2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        b1=findViewById(R.id.button1);
        b1=findViewById(R.id.button2);
        t1=findViewById(R.id.tv1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1)
        {
            String s1= e1.getText().toString();
            String s2= e2.getText().toString();
            t1.setText(s1+":"+s2);
        }
    }
}
