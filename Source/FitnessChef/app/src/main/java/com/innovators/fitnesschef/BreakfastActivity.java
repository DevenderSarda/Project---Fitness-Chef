package com.innovators.fitnesschef;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {
    int PICK_IMAGE=1;
    String s;
    Bitmap bitmap;
    String n;
    String str;
    static final int TAKE_PHOTO_CODE = 0;
    private ArrayAdapter mAdapter;
    public ListView l;
    ArrayList<String> myStringArray1;
    String z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
         l = (ListView) findViewById(R.id.list);
         myStringArray1 = new ArrayList<String>();

    }

    public void upload(View v) {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(BreakfastActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (items[item].equals("Take Photo")) {
                        cameraIntent();

                        }
                 else if (items[item].equals("Choose from Library")) {
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }
private void cameraIntent()
{
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);

}
    private  void galleryIntent()
    {
        Intent gallery=new Intent();
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery, "Select Picture"),PICK_IMAGE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Handler handler = new Handler();
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            s=getPath(uri);
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       imagescan();  //Do something after 100ms
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getcallories(n);  //Do something after 100ms
                    }
                }, 2000);
            }catch (Exception e)
            {

            }
        }
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            try {
                bitmap = (Bitmap) data.getExtras().get("data");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imagescan();  //Do something after 100ms
                    }
                }, 1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getcallories(n);  //Do something after 100ms
                    }
                }, 2000);
            }
            catch (Exception e)
            {

            }
        }
    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = BreakfastActivity.this.getContentResolver().query(uri, projection, null, null, null);
        int columnIndex = cursor.getColumnIndex(projection[0]);
        cursor.moveToFirst();
        return cursor.getString(columnIndex);
    }

    private void imagescan()
    {
        String getURL = "https://gateway-a.watsonplatform.net/visual-recognition/api/v3/classify?api_key=94848e5ce4ed34c5ec88f5bc86c409bca1f0ca95&version=2016-05-19";

        String response = null;
        BufferedReader bfr = null;
        try {
            URL url = new URL(getURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "image/jpeg");
            conn.setRequestMethod("POST");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            conn.getURL();
            out.close();
            bfr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = bfr.readLine()) != null) {
                // Append server response in string
                sb.append(line + " ");
            }
            response = sb.toString();
        } catch (Exception ex) {
            String Error = ex.getMessage();
        } finally {
            try {
                bfr.close();
            } catch (Exception ex) {

            }
        }
        try{
            JSONObject j=new JSONObject(response);
            JSONArray a=j.getJSONArray("images");
            JSONObject b=a.getJSONObject(0);
            JSONArray c=b.getJSONArray("classifiers");
            JSONObject d=c.getJSONObject(0);
            JSONArray e=d.getJSONArray("classes");
            JSONObject f=e.getJSONObject(0);
            n=f.getString("class");


        }catch (Exception e)
        {
            e.getMessage();
        }

    }

    public void getcallories(String n) {
        String getURL = "https://api.edamam.com/api/nutrition-data?app_id=254d36ea&app_key=383e71430a323ae94ec781cab4b8918a&ingr=1%20large%20" + n;
        String response = null;
        BufferedReader bfr = null;
        try {
            URL url = new URL(getURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            bfr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bfr.readLine()) != null) {
                // Append server response in string
                sb.append(line + " ");
            }
            response = sb.toString();
            JSONObject o=new JSONObject(response);
             str=o.getString("calories");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void additem(View v)
    {
        EditText t=(EditText) findViewById(R.id.editText3);
        String x=t.getText().toString();
        getcallories(x);
        myStringArray1.add(x+"   "+str);
     //   myStringArray1.add("Quantity : 1");
        mAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, myStringArray1);
        l.setAdapter(mAdapter);
    }
}
