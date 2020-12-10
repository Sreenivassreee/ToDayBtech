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

public class All_Inter_Quations extends AppCompatActivity {

    Button android_app_questions,java_questions,c_questions,python_questions,linux_questions,DataStructure_questions;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.all__inter__quations);

        java_questions = findViewById(R.id.java_questions);
        c_questions = findViewById(R.id.c_questions);
        python_questions = findViewById(R.id.python_questions);
        android_app_questions = findViewById(R.id.android_app_questions);
        linux_questions = findViewById(R.id.Linux_questions);
        DataStructure_questions = findViewById(R.id.DataStructure_questions);


        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("  ToDayBtech");
        toolbar.setSubtitle("     SteveBrains");
        toolbar.setLogo(R.drawable.tool_icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);


        java_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,java_questions.class);
                startActivity(intent);


            }
        });


        c_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,c_questions.class);
                startActivity(intent);


            }
        });
        python_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,python_questions.class);
                startActivity(intent);


            }
        });
        android_app_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,android_app_questions.class);
                startActivity(intent);


            }
        });


        linux_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,linux_questions.class);
                startActivity(intent);


            }
        });

        DataStructure_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(All_Inter_Quations.this,DataStructures_questions.class);
                startActivity(intent);


            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(this, "You are at Home ", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,features.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                return true;


            case android.R.id.home:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);

    }





}

