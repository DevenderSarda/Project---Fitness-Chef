package com.innovators.fitnesschef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.MenuItem;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
     getSupportActionBar().setLogo(R.drawable.ic_arrow_back_white_24dp);
      getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_login);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent redirect = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(redirect);
                        return true;
                    }

                });

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
