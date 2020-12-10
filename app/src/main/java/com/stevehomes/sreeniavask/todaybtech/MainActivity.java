package com.stevehomes.sreeniavask.todaybtech;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private EditText editTextMobile;
    private Boolean firstTime = null;
    private SharedPreference sharedPreferenceObj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        sharedPreferenceObj=new SharedPreference(MainActivity.this);
        if(sharedPreferenceObj.getApp_runFirst().equals("FIRST"))
        {
            Intent i = new Intent(this, IntroActivity.class);
            startActivity(i);
            finish();
            sharedPreferenceObj.setApp_runFirst("NO");
        }
        else
        {

        }





        editTextMobile = (EditText)findViewById(R.id.editTextMobile);





        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String mobile = editTextMobile.getText().toString().trim();

                    if(mobile.isEmpty() || mobile.length() < 10){
                        editTextMobile.setError("Enter a valid mobile");
                        editTextMobile.requestFocus();
                        return;
                    }


                    Intent intent = new Intent(MainActivity.this,verify_phone.class);
                    intent.putExtra("mobile",mobile);
                    startActivity(intent);
                }
            });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, Welcome.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
//
    }
}