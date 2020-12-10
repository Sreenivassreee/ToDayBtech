package com.stevehomes.sreeniavask.todaybtech;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Toast;

public class about extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.about);

        toolbar=findViewById(R.id.toolbar);
        scrollview=findViewById(R.id.Ascrollview);

        scrollview.setHorizontalScrollBarEnabled(false);
        scrollview.setVerticalScrollBarEnabled(false);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("About Us");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, features.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(this, "You are at Home ", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}
