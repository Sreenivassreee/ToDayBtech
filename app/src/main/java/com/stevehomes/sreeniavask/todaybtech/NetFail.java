package com.stevehomes.sreeniavask.todaybtech;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//import android.os.Handler;
//import android.support.v7.app.AlertDialog;
//import android.widget.Toast;

public class NetFail extends AppCompatActivity {
    Button trybtn;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_fail);
        trybtn=findViewById(R.id.trybtn);

//
//        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#673AB7")));
        trybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NetFail.this,Welcome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                Toast.makeText(NetFail.this, "Checking..", Toast.LENGTH_SHORT).show();


            }


        });
    }

    @Override
    public void onBackPressed() {
        finish();
//        System.exit(0);// this line close the  app on backpress

    }

}




