package com.example.charu.alarmc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class MainActivity extends AppCompatActivity {

    private  Tracker mTracker;
    EditText name,email,age,dd,mm,yy,des;
    TextView agetextview;
    Button next;
    String Name,Email,DD,MM,YY,Age,Des;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+",dobpattern="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            AnalyticsApplication application = (AnalyticsApplication) getApplication();
            mTracker = application.getDefaultTracker();
        name = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);
        dd = (EditText) findViewById(R.id.editTextDD);
        mm = (EditText) findViewById(R.id.editTextMM);
        yy = (EditText) findViewById(R.id.editTextYY);
        age = (EditText) findViewById(R.id.editTextAge);
        des = (EditText) findViewById(R.id.editTextDes);
        agetextview = (TextView) findViewById(R.id.textVieweAge);
        next=(Button) findViewById(R.id.button_submit);

        next.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("clicked").build());
                 Name= name.getText().toString();
                 Email= email.getText().toString().trim();
                 DD= dd.getText().toString();
                 MM= mm.getText().toString();
                 YY= yy.getText().toString();
                 Age= age.getText().toString();
                Des= des.getText().toString();
                int d = Integer.parseInt(DD);
                int m =Integer.parseInt(MM);
                int y = Integer.parseInt(YY);
                int a = Integer.parseInt(age.getText().toString());
                if(Name.length()==0)
                {
                    name.requestFocus();
                    name.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!Name.matches("[a-zA-Z ]+"))
                {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                else if(Email.length()==0)
                {
                    email.requestFocus();
                    email.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!Email.matches(emailPattern))
                {
                    email.requestFocus();
                    email.setError("ENTER Valid Email ID");
                }
                else if((d<=0 || d>31) || DD.length()==0)
                {
                    dd.requestFocus();
                    dd.setError("ENTER VALID DAY");

                }
                else if((m<=0 || m>12) || MM.length()==0)
                {
                    mm.requestFocus();
                    mm.setError("ENTER VALID MONTH");

                }
                else if( YY.length()==0)
                {
                    mm.requestFocus();
                    mm.setError("ENTER YEAR");

                }

                else if( Age.length()<0 && a<100)
                {
                    age.requestFocus();
                    age.setError("Age cannot be empty & should be less than 100");

                }
                else
                {
                    mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("submitted").build());
                    Toast.makeText(MainActivity.this,"Validation Successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,
                            Main2Activity.class);
                    startActivity(i);
                }



            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("FormScreen");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
