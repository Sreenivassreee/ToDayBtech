package com.stevehomes.sreeniavask.todaybtech;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Welcome extends AppCompatActivity {

    private static int KSV = 2000;
    ActionBar actionBar;
    private static int KSV2 = 2000;
//    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
//        btn=findViewById(R.id.TTTTTEst);


//        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#673AB7")));



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(Welcome.this,features.class);
//                startActivity(i);
//            }
//        });

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            //we are connected to a network
            connected = true;


            if (FirebaseAuth.getInstance().getCurrentUser() == null) {

               new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intant = new Intent(Welcome.this, MainActivity.class);
                            intant.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intant);

                            this.overridePendingTransition(1000, 1000);
                            finish();

                        }

                        private void overridePendingTransition(int i, int i1) {
                        }


                    }, KSV);
            }else {

                if (FirebaseAuth.getInstance().getCurrentUser() != null) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intant = new Intent(Welcome.this, features.class);

                            startActivity(intant);

                            this.overridePendingTransition(1000, 1000);
                            finish();

                        }

                        private void overridePendingTransition(int i, int i1) {
                        }


                    }, KSV);
//
                }else{
                    Toast.makeText(this, "Something is goes Wrong please report to admin ", Toast.LENGTH_LONG).show();
                }
            }

        } else {

            connected = false;
            Toast.makeText(this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intant = new Intent(Welcome.this, NetFail.class);

                    startActivity(intant);
                    finish();


                }
            }, KSV2);
        }




    }
}





