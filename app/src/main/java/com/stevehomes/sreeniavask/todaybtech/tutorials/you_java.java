package com.stevehomes.sreeniavask.todaybtech.tutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.stevehomes.sreeniavask.todaybtech.R;
import com.stevehomes.sreeniavask.todaybtech.Utils;
import com.stevehomes.sreeniavask.todaybtech.features;

public class you_java extends AppCompatActivity {


    Toolbar toolbar;
    Button you_btn,you_java_playlist;

    private YouTubePlayerView youTubeView;
    public static final String TAG = "MainActivity";
    Button playbtn;
    YouTubePlayer.OnInitializedListener mOnInitializerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.you_java);

            Log.d(TAG, "onCreate : Staring");

//
//        toolbar.setSubtitle("   SteveBrains");
//        toolbar.setLogo(R.drawable.tool_icon);

            you_btn=findViewById(R.id.you_back);

            playbtn = findViewById(R.id.buttonplay);
            youTubeView = findViewById(R.id.youtube_view_java);
            you_java_playlist = findViewById(R.id.you_java_playlist);


            mOnInitializerView = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    Log.d(TAG, "onCreate : Done initialise");
                    youTubePlayer.loadVideo("8cm1x4bC610");

                    youTubePlayer.setShowFullscreenButton(true);
                    youTubePlayer.setFullscreenControlFlags(10);
                    youTubePlayer.setShowFullscreenButton(true);


                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.d(TAG, "onCreate : Fail initialise");
                }
            };

            you_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();

                }
            });


            playbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d(TAG, "onCreate : Youtube Player");
                    youTubeView.initialize(Config.getYoutubeApiKey(), mOnInitializerView);
                    Log.d(TAG, "onCreate : Done initialising");

                }
            });



            you_java_playlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(you_java.this, you_all_java_videos.class);
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
        public void onBackPressed() {
            //Execute your code here
            finish();

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    Toast.makeText(this, "You are at Home ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, features.class);
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









