package com.innovators.fitnesschef;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {
    private ArrayAdapter mAdapter;
    public ListView l;
    ArrayList<String> myStringArray1;
    String x;
    String q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        l = (ListView) findViewById(R.id.list);
        myStringArray1 = new ArrayList<String>();
    }
    public void additem(View v)
    {
        EditText t=(EditText) findViewById(R.id.editText3);
        x=t.getText().toString();
        quantity();

    }
    public void quantity() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ExerciseActivity.this);
        builder.setTitle("Calories Burnt!");
        TextView tv=new TextView(ExerciseActivity.this);
        tv.setText("Quantity:");
        final EditText input = new EditText(ExerciseActivity.this);
        input.setText("1");
        builder.setView(tv);
        builder.setView(input);
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        q=input.getText().toString();
                        if(q.isEmpty())
                        {
                            q="0";
                        }
                        dialog.cancel();
                        dis(x);
                    }

                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
                dis(x);
            }
        });
        builder.show();

    }
    private void dis(String x)
    {
        myStringArray1.add(x.toUpperCase()+",           "+"CALORIES: "+q);

        mAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, myStringArray1);
        l.setAdapter(mAdapter);
    }
}
