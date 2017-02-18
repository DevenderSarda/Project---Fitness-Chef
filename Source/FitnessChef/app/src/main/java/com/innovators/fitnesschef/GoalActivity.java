package com.innovators.fitnesschef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
    }

    public void details(View v)
    {
        Intent redirect=new Intent(GoalActivity.this,DetailsActivity.class);
        startActivity(redirect);
    }
}
