package com.innovators.fitnesschef;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DetailsActivity extends AppCompatActivity {

    EditText fullname;
    EditText age;
    RadioGroup radioGroup;
    RadioButton radioButton;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

         public void details(View v){

        fullname = (EditText) findViewById(R.id.fullname);
        age = (EditText) findViewById(R.id.ddmmyyyy);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
      //  Button nxt = (Button) findViewById(R.id.next);


        sp = getSharedPreferences("Key", Activity.MODE_PRIVATE);
//        nxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                String userName = fullname.getText().toString();
                String person_age = age.getText().toString();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                SharedPreferences.Editor editor = sp.edit();
                String gender = radioButton.getText().toString();
                editor.putString("gender", gender);
                editor.putString("fullname", userName);
                editor.putString("age", person_age);
                editor.commit();

                Log.d("DetailsActivity",userName);

             Intent redirect = new Intent(DetailsActivity.this, Dashboard.class);
             startActivity(redirect);

            }


    }


