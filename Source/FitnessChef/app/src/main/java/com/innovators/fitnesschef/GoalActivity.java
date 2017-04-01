package com.innovators.fitnesschef;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class GoalActivity extends AppCompatActivity {

    private RadioButton r1;
    private  RadioButton r2;
    private RadioButton r3;
    private EditText h;
    private EditText w;
    private TextView t;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        r1=(RadioButton) findViewById(R.id.lose);
        r2=(RadioButton) findViewById(R.id.maintain);
        r3=(RadioButton) findViewById(R.id.gain);
        h=(EditText) findViewById(R.id.ht);
        w=(EditText) findViewById(R.id.wt);
        t=(TextView) findViewById(R.id.goal1);
    }

    public void details(View v)
    {
        String s=h.getText().toString();
        String u=w.getText().toString();
        if(r1.isChecked()|r2.isChecked()|r3.isChecked())
        {
            if(!s.isEmpty()&!u.isEmpty())
            {
                Log.d("GoalActivity",s);
                //shared preferences
                SharedPreferences sp = getSharedPreferences("Key", Activity.MODE_PRIVATE);
                SharedPreferences.Editor edt = sp.edit();
                edt.putString("height",s);
                edt.putString("weight",u);
                edt.commit();



                Intent redirect=new Intent(GoalActivity.this,DetailsActivity.class);
                startActivity(redirect);
            }
            else{
                if(s.isEmpty()&u.isEmpty())
                {
                    h.setError("This field is required");
                    w.setError("This filed is required");
                }
                else if(s.isEmpty()){
                    h.setError("This filed is required");
                }
                else
                {
                    w.setError("This filed is required");
                }
            }
        }
        else
        {
            t.setError("This selection is required");
        }




    }



}
