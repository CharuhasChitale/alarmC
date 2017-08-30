package com.example.charu.alarmc;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {



   EditText d,m,y,ho,minutes,se;
    int yy,mm,dd,min,sec,hour;
    String day,mon,year,h,mi,s,x,k,z;
    Button b1,b2,b3,submit,reset;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        d=  (EditText) findViewById(R.id.editText2DD);
        m=  (EditText) findViewById(R.id.editText2MM);
        y=  (EditText) findViewById(R.id.editText2YY);
        b1= (Button) findViewById(R.id.Button1);
        b2= (Button) findViewById(R.id.Button2);
        b3= (Button) findViewById(R.id.Button3);
        submit =(Button) findViewById(R.id.ButtonSubmit);
        reset =(Button) findViewById(R.id.ButtonRest);
        ho= (EditText)findViewById(R.id.editTextHour);
        minutes= (EditText)findViewById(R.id.editTextMin);
        se= (EditText)findViewById(R.id.editTextSec);


        final Calendar c = Calendar.getInstance();
        yy = c.get(Calendar.YEAR);
        mm = c.get(Calendar.MONTH);
        dd = c.get(Calendar.DAY_OF_MONTH);
         hour=  c.get(Calendar.HOUR);
        min= c.get(Calendar.MINUTE);
        sec= c.get(Calendar.SECOND);

        day=  String.valueOf(dd);
        mon = String.valueOf(mm);
        year=String.valueOf(yy);
        h=String.valueOf(hour);
        mi=String.valueOf(min);
        s=String.valueOf(sec);
       /* int temp = dd+1;
        x=String.valueOf(temp);
        temp=temp+1;
        k=String.valueOf(temp);
        temp+=1;
        z=String.valueOf(temp);*/

        d.setText(day);
        m.setText(mon);
        y.setText(year);
       ho.setText(h);
        minutes.setText(mi);
        se.setText(s);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setText("1");
                m.setText("9");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setText("2");
                m.setText("9");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setText("3");
                m.setText("9");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setText("");
                m.setText("");
                y.setText("");
                ho.setText("");
                minutes.setText("");
                se.setText("");
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String day = d.getText().toString();
                String mon = m.getText().toString();
                String year = y.getText().toString();
                String hour = ho.getText().toString();
                String min = minutes.getText().toString();
                String sec = se.getText().toString();
                int da = Integer.parseInt(day);
                int mo =Integer.parseInt(mon);
                int yy = Integer.parseInt(year);
                int h = Integer.parseInt(hour);
               int mi = Integer.parseInt(min);
                int s = Integer.parseInt(sec);
                if((da<=0 || da>31) || day.length()==0)
                {
                    d.requestFocus();
                    d.setError("PLEASE ENTER VALID DAY");

                }
                else if((mo<=0 || mo>12) || mon.length()==0)
                {
                    m.requestFocus();
                    m.setError("PLEASE ENTER VALID MONTH");
                }
                else if(yy<=0 || year.length()==0)
                {
                    y.requestFocus();
                    y.setError("PLEASE ENTER VALID YEAR");
                }
                else if((h<=0 || h>12) || hour.length()==0)
                {
                    ho.requestFocus();
                    ho.setError("PLEASE ENTER VALID HOUR");
                }
                else if((mi<=0 || mi>60)|| min.length()==0)
                {
                    minutes.requestFocus();
                    minutes.setError("PLEASE ENTER VALID MIN");
                }
                else if((s<=0 || s>60)|| sec.length()==0)
                {
                    se.requestFocus();
                    se.setError("PLEASE ENTER VALID SEC");
                }
                else {
                Intent i = new Intent(Main2Activity.this,
                            Main3Activity.class);
                    startActivity(i); }
            }
        });
    }
}
