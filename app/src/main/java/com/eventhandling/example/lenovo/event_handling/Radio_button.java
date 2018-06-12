package com.eventhandling.example.lenovo.event_handling;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Radio_button extends Activity implements View.OnClickListener {

    RadioButton r1,r2,r3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);
        r3=findViewById(R.id.radioButton3);
        tv=findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton:
                Toast.makeText(this, r1.getText(), Toast.LENGTH_LONG).show();
                 break;
            case R.id.radioButton2:
                Toast.makeText(this, r2.getText(), Toast.LENGTH_LONG).show();
                break;

            case R.id.radioButton3:
                Toast.makeText(this, r3.getText(), Toast.LENGTH_LONG).show();
                break;
        }

    }
}
