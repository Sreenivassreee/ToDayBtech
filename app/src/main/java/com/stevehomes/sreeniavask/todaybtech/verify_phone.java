package com.stevehomes.sreeniavask.todaybtech;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verify_phone extends AppCompatActivity {


        private String mVerificationId;


        private EditText editTextCode;


        private FirebaseAuth mAuth;
        private ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_verify_phone);

            mAuth = FirebaseAuth.getInstance();
            editTextCode = (EditText)findViewById(R.id.editTextCode);
            progressBar=findViewById(R.id.progressbar);






            Intent intent = getIntent();
            String mobile = intent.getStringExtra("mobile");
            sendVerificationCode(mobile);



            findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String code = editTextCode.getText().toString().trim();

                    if (code.isEmpty() || code.length() < 6) {
                        editTextCode.setError("Enter valid code");
                        editTextCode.requestFocus();
                        return;
                    }



                    //verifying the code entered manually
                    verifyVerificationCode(code);
                }
            });

        }


        private void sendVerificationCode(String mobile) {
            progressBar.setVisibility(View.VISIBLE);
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+91" + mobile,
                    60,
                    TimeUnit.SECONDS,
                    TaskExecutors.MAIN_THREAD,
                    mCallbacks);

        }


        //the callback to detect the verification status
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                String code = phoneAuthCredential.getSmsCode();

                if (code != null) {

                    editTextCode.setText(code);
                    //verifying the code

                    verifyVerificationCode(code);
                }
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(verify_phone.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                //storing the verification id that is sent to the user
                mVerificationId = s;
            }
        };


        private void verifyVerificationCode(String code) {

            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);


            signInWithPhoneAuthCredential(credential);
        }

        private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(verify_phone.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //verification successful we will start the profile activity
                                Intent intent = new Intent(verify_phone.this, features.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);

                            } else {

                                Toast.makeText(verify_phone.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                String message = "Something is wrong, we will fix it soon...";

                                try {
                                    Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
                                    snackbar.setAction("Dismiss", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                        }

                                    });
                                    snackbar.show();
                                }catch (IllegalArgumentException e){
                                    Toast.makeText(verify_phone.this, "You Are login", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }

    }






//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_verify_phone);
//
//        String phoneNumber = getIntent().getStringExtra("phoneNumber");
//
////        mAuth = FirebaseAuth.getInstance();
//        editTextCode = findViewById(R.id.editTextCode);
//
//        Intent intent = getIntent();
//        String mobile = intent.getStringExtra("mobile");
//        sendVerificationCode(mobile);
//
//    }
//
//
//    private void sendVerificationCode(String mobial) {
//
//    }
////    private void sendVerificationCode(String mobile) {
////        PhoneAuthProvider.getInstance().verifyPhoneNumber(
////                "+91" + mobile,
////                60,
////                TimeUnit.SECONDS,
////                TaskExecutors.MAIN_THREAD,
////                mCallbacks);
////    }
//
//}
