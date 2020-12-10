package com.stevehomes.sreeniavask.todaybtech.tutorials;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.stevehomes.sreeniavask.todaybtech.R;
import com.stevehomes.sreeniavask.todaybtech.Utils;
import com.stevehomes.sreeniavask.todaybtech.features;

public class all_tuto_screen extends AppCompatActivity {

    Toolbar toolbar;
    Button eng_drawing,python,java,c,android_app,linux,git;
    ScrollView scrollview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.all_tuto_screen);

        eng_drawing = findViewById(R.id.tuto_drawing_btn);
        python = findViewById(R.id.tuto_python_btn);
        java = findViewById(R.id.tuto_java_btn);
        c = findViewById(R.id.tuto_c_btn);
        android_app = findViewById(R.id.tuto_android_app_questions_btn);
        linux = findViewById(R.id.tuto_Linux_questions_btn);
        git = findViewById(R.id.tuto_github_btn);

        toolbar=findViewById(R.id.toolbar);
        scrollview=findViewById(R.id.scrollview);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("  ToDayBtech");
        toolbar.setSubtitle("     SteveBrains");
        toolbar.setLogo(R.drawable.tool_icon);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);


        scrollview.setVerticalScrollBarEnabled(false);


        eng_drawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, drawing_contant.class);
                startActivity(intent);
            }





        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_python.class);
                startActivity(intent);
            }

        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_all_java_videos.class);
                startActivity(intent);
            }

        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_all_c_videos.class);
                startActivity(intent);
            }

        });
        android_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_all_android_app_videos.class);
                startActivity(intent);
            }

        });
        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_all_linux_videos.class);
                startActivity(intent);
            }

        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(all_tuto_screen.this, you_all_git_videos.class);
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
                    Intent intent=new Intent(this, features.class);
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








