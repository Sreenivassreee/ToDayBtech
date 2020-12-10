package com.stevehomes.sreeniavask.todaybtech;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class note_cources extends AppCompatActivity {
    Button csebtn, ecebtn, eeebtn, civilbtn, mechbtn;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.note_courses);
//
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  ToDayBtech");

        toolbar.setSubtitle("     SteveBrains");
        toolbar.setLogo(R.drawable.tool_icon);

//        toolbar.setNavigationIcon(R.drawable.back);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);




        csebtn = findViewById(R.id.notes_csebtn);
        ecebtn = findViewById(R.id.notes_ecebtn);
        eeebtn = findViewById(R.id.notes_eeebtn);
        civilbtn = findViewById(R.id.notes_civilbtn);
        mechbtn = findViewById(R.id.notes_mechbtn);
        toolbar = findViewById(R.id.toolbar);


        csebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(note_cources.this, note_cse_yearsem.class);
                startActivity(intent);
            }


        });

        ecebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(note_cources.this, note_ece_yearsem.class);
                startActivity(intent);
            }


        });


        eeebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(note_cources.this, note_eee_yearsem.class);
                startActivity(intent);
            }


        });

        civilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(note_cources.this, note_civil_yearsem.class);
                startActivity(intent);
            }

        });


        mechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(note_cources.this, note_mech_yearsem.class);
                startActivity(intent);
            }


        });

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
