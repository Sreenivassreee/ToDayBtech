package com.stevehomes.sreeniavask.todaybtech;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.google.android.gms.common.Feature;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.stevehomes.sreeniavask.todaybtech.tutorials.all_tuto_screen  ;


public class features extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button pribtn,syllabusbtn,matebtn,tuto,Notes,Noti,pro_notes,All_off_webs,compus,java_questions,c_questions,acadamic_cal,model_Resumes;
    androidx.appcompat.widget.Toolbar toolbar;
    Button aboutUs;
    ScrollView myScrollview;
    private SharedPreference sharedPreferenceObj;

    Animation btnAnim ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.features);

        myScrollview=findViewById(R.id.scrollview);

//        actionBar=getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#212121")));

        syllabusbtn = findViewById(R.id.syllabusbtn);
//        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);
        pribtn = findViewById(R.id.priviousbtn);
        matebtn = findViewById(R.id.matebtn);
//        Upload_mate_btn = findViewById(R.id.Upload_mate);
//        aboutUs = findViewById(R.id.about);
//        share = findViewById(R.id.share);
        toolbar = findViewById(R.id.toolbar);
        Notes= findViewById(R.id.notes);
        Noti = findViewById(R.id.Noti_btn);
        pro_notes = findViewById(R.id.pro_notes);
        All_off_webs = findViewById(R.id.off_AllWebs);
        tuto=findViewById(R.id.tuto);
        compus=findViewById(R.id.compus_intra);
        java_questions=findViewById(R.id.java_questions);
        c_questions=findViewById(R.id.c_questions);
        acadamic_cal=findViewById(R.id.academic_cal_btn);
        model_Resumes=findViewById(R.id.model_Resumes);

//        FirebaseInstanceId.getInstance().getInstanceId()
//                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "getInstanceId failed", task.getException());
//                            return;
//                        }
//
//                        // Get new Instance ID token
//                        String token = task.getResult().getToken();
//
//                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
//                        Log.d(TAG, msg);
//                        Toast.makeText(features.this, msg, Toast.LENGTH_SHORT).show();
//                        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
//
//                    }
//                });





        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("  ToDayBtech");
        toolbar.setSubtitle("     SteveBrains");
        toolbar.setLogo(R.drawable.tool_icon2);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        myScrollview.setVerticalScrollBarEnabled(false);







        pribtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this, pri_courses.class);
                startActivity(intent);
            }
        });
        compus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this,campus_interaction.class);
                startActivity(intent);
            }
        });

        syllabusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this, syl_courses.class);
                startActivity(intent);
            }

        });

        matebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this, mate_courses.class);
                startActivity(intent);

            }

        });

        Notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this,note_cources.class);
                startActivity(intent);
            }

        });
        tuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(features.this,all_tuto_screen.class);
                startActivity(intent);
            }

        });

        Noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this, student_details.class);
                startActivity(intent);

            }
        });

        pro_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this,B_pro_notes.class);
                startActivity(intent);
            }
        });
        All_off_webs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this,All_off_webs.class);
                startActivity(intent);
            }
        });
        java_questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this,All_Inter_Quations.class);
                startActivity(intent);
            }
        });

        acadamic_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this, All_academic_cal.class);
                startActivity(intent);
            }
        });
        model_Resumes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(features.this, B_model_Resumes.class);
                startActivity(intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }



    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.isDrawerOpen(GravityCompat.START);
                drawer.closeDrawer(GravityCompat.START);
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("     Exit     [ SteveBrains ]")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No", null).show();

//            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }



    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        int id=Item.getItemId();
        if(id ==R.id.playStore){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.stevehomes.sreeniavask.todaybtech"));
            startActivity(intent);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.isDrawerOpen(GravityCompat.START);
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(id ==R.id.Website){

            Toast.makeText(this, "We are working \n Coming soon..", Toast.LENGTH_LONG).show();

//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.addCategory(Intent.CATEGORY_BROWSABLE);
//            intent.setData(Uri.parse("https://todaybtech.blogspot.com"));
//            startActivity(intent);
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
        }
        else if(id ==R.id.facebook){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/SteveBrainsOfficial/"));
            startActivity(intent);
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);

        }
        else if(id ==R.id.Instagram){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.instagram.com/stevebrains_official/"));
            startActivity(intent);
        }else if(id ==R.id.Youtube){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.youtube.com/channel/UC0dKlPveAyyiIs1cuyAh4gQ"));
            startActivity(intent);
        }else if(id ==R.id.whatsapp){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://chat.whatsapp.com/BqTYXVpcnUSJpKn6TbCtvl"));
            startActivity(intent);
        }else if(id ==R.id.nav_share){
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.isDrawerOpen(GravityCompat.START);
            drawer.closeDrawer(GravityCompat.START);
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Hey Dear i recently found a great App for Btech students  \uD83D\uDC9D ,it has all features which we need to get good Skills and % .."+" Download by using this link \n  \uD83D\uDC47\uD83C\uDFFB  \uD83D\uDC47\uD83C\uDFFB  \uD83D\uDC47\uD83C\uDFFB  \uD83D\uDC47\uD83C\uDFFB \n"+
            "https://play.google.com/store/apps/details?id=com.stevehomes.sreeniavask.todaybtech";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "ToDayBtech");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via "));


        }else if(id ==R.id.materials){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(features.this,Upload_main_page.class);
            startActivity(intent);
        }
        else if(id ==R.id.feedback) {

            Intent intent=new Intent(features.this,student_details.class);
            startActivity(intent);
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
//            Intent mailIntent = new Intent(Intent.ACTION_VIEW);
//            Uri data = Uri.parse("mailto:?subject=" + "Materials" + "&body=" + "Please respond in positive way and give me suggestions to make more useful... " + "&to=" + "stevehomes143@mail.com");
//            mailIntent.setData(data);
//            startActivity(Intent.createChooser(mailIntent, "We are waiting for ur feedback..."));

        }else if(id ==R.id.Logout){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);

            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(this,Welcome.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }else if(id ==R.id.AboutUs){
            Intent intent=new Intent(this,about.class);
            startActivity(intent);
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
//
//            Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();

//            FirebaseAuth.getInstance().signOut();
//
//            Intent intent = new Intent(this,Welcome.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
        }else if(id ==R.id.contact){
//            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.isDrawerOpen(GravityCompat.START);
//            drawer.closeDrawer(GravityCompat.START);
            Intent intent=new Intent(features.this,student_details.class);
            startActivity(intent);


        }else if(id ==R.id.privacy){
//
            Intent intent=new Intent(features.this,Privacy_policy.class);
            startActivity(intent);

        }
        else if(id ==R.id.Terms) {
//
            Intent intent = new Intent(features.this, Terms_conditions.class);
            startActivity(intent);
        } else if(id==R.id.nightmode){
            Utils.changeToTheme(this, Utils.THEME_DEFAULT);

        }else if(id==R.id.normalmode){
            Utils.changeToTheme(this, Utils.THEME_WHITE);

        } else if(id ==R.id.help){
            Intent i = new Intent(this, IntroActivity.class);
            startActivity(i);

        }
//





        return false;
    }

    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),features.class);
        startActivity(i);
        finish();
    }
}
