package com.eventhandling.example.lenovo.event_handling;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class calculator_4 extends Activity {

    private int[] numericbutton = {R.id.bc0, R.id.bc1, R.id.bc2, R.id.bc3, R.id.bc4, R.id.bc5, R.id.bc6, R.id.bc7, R.id.bc8, R.id.bc9};
    private int[] operationbutton = {R.id.bcp, R.id.bcs, R.id.bcm, R.id.bcd,R.id.pow};

    private TextView txtScreen;
    private TextView txtScreen2;

    private boolean lastNumeric;

    private boolean stateError;
    private boolean lastDot;

    public double b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_4);

        this.txtScreen = (TextView) findViewById(R.id.tvc2);
        this.txtScreen2=(TextView)findViewById(R.id.tvc);

        setNumericOnClickListener();
        setOperatorOnClickListener();
    }

    private void setNumericOnClickListener() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (stateError) {
                    txtScreen.setText(button.getText());
                    stateError = false;

                } else {
                    txtScreen.append(button.getText());

                }
                lastNumeric = true;
            }
        };

        for (int id : numericbutton) {
            findViewById(id).setOnClickListener(listener);
        }
    }


    private void setOperatorOnClickListener() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lastNumeric && !stateError) {
                    Button button = (Button) v;
                    txtScreen.append(button.getText());
                    lastNumeric = false;
                    lastDot = false;
                }
            }
        };

        for (int id : operationbutton) {
            findViewById(id).setOnClickListener(listener);
        }

        findViewById(R.id.bcpoint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastNumeric && !stateError && !lastDot) {
                    txtScreen.append(".");
                    lastNumeric = false;
                    lastDot = true;
                }
            }
        });

        findViewById(R.id.bcac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtScreen.setText("");
                txtScreen2.setText("");
                lastNumeric = false;
                stateError = false;
                lastDot = false;
            }
        });

        findViewById(R.id.bccut).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String txt =txtScreen.getText().toString();
                int len =(txt.length()-1);
                txt = txt.substring(0,len);
                txtScreen.setText(txt);
                lastNumeric = false;
                stateError = false;
                lastDot = false;
            }
        });
        findViewById(R.id.bcper).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                if(lastNumeric && !stateError && !lastDot)
                {
                    String q = String.valueOf(onEqual());
                    double d= Double.parseDouble(q);
                    double p=(d/100);
                    txtScreen2.setText(String.valueOf(p));
                }
            }
        });


        findViewById(R.id.bce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t = 0, q = 0;
                String txt =txtScreen.getText().toString();
                for(int k=0;k<txt.length();k++)
                {
                    char aChar = txt.charAt(k);
                    if(aChar == 'p') {
                         t=k-1;
                         q=k+1;
                    }

                }
                //prem bhai...ruko muje dekne do
                //ok

                String txt2 = txt.substring(0,t);
              /*  txtScreen2.setText(Double.toString(Double.parseDouble(txt2)));
                double b = Double.parseDouble(txt2);

                String txt3 = txt.substring(q,txt.length());
                double c = Double.parseDouble(txt3);*/
                for(int i=0;i<txt.length();i++) {
                    char aChar = txt.charAt(i);
                    if (aChar == 'p')
                    {
                       double p = equal(b,c);
                        txtScreen2.setText(Double.toString(p));

                    }
                    else
                    {
                        onEqual();
                    }
                }
            }
        });
    }


    private double onEqual() {

        double onEqual = 0;
        if (lastNumeric && !stateError) {

            String txt = txtScreen.getText().toString();

            Expression expression = new ExpressionBuilder(txt).build();
            try {

                onEqual = expression.evaluate();
                txtScreen2.setText(Double.toString(onEqual));
                lastDot = true; // Result contains a dot
            } catch (ArithmeticException ex) {

                txtScreen2.setText("Error");
                stateError = true;
                lastNumeric = false;
            }
        }
        return onEqual;
    }
    public double equal(double b, double c)
    {
        double dou = Math.pow(b, c);

        return dou;
    }
}