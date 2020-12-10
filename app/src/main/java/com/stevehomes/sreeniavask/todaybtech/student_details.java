package com.stevehomes.sreeniavask.todaybtech;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class student_details extends AppCompatActivity {
    EditText name, mail, phonenumber, college, comments;
    Spinner groups, year;
    Button submit;
    DatabaseReference Student_Database;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.student_details);

        Student_Database = FirebaseDatabase.getInstance().getReference("AddDetails");

//        Student_Database= FirebaseDatabase.getInstance().getReference("AddDetails");


        name = findViewById(R.id.stu_name);
        mail = findViewById(R.id.stu_Email);
        phonenumber = findViewById(R.id.PhoneNumber);
        college = findViewById(R.id.college);
        groups = findViewById(R.id.groups);
        year = findViewById(R.id.year);
        submit = findViewById(R.id.submit);
        comments = findViewById(R.id.Comments);
        scrollView = findViewById(R.id.scrollview);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDetails();

            }
        });
        scrollView.setVerticalScrollBarEnabled(false);

    }


    public void AddDetails() {
        String SName = name.getText().toString().trim();
        String SMail = mail.getText().toString().trim();
        String Sphonenumber = phonenumber.getText().toString().trim();
        String Scollege = college.getText().toString().trim();
        String Sgroup = groups.getSelectedItem().toString();
        String Syear = year.getSelectedItem().toString();
        String Scomments = comments.getText().toString();

        if (!TextUtils.isEmpty(SName)) {

            if (!TextUtils.isEmpty(SMail)) {

                if (!TextUtils.isEmpty(Sphonenumber)) {

                    if (!TextUtils.isEmpty(Scollege)) {

                        if (!TextUtils.isEmpty(Sgroup)) {

                            if (!TextUtils.isEmpty(Syear)) {

//                                int i=0;
                                if (!TextUtils.isEmpty(Scomments)) {


                                    String id = Student_Database.push().getKey();

                                    AddDetails addDetails = new AddDetails(id, SName, SMail, Sphonenumber, Scollege, Sgroup, Syear, Scomments);

                                    Student_Database.child(id).setValue(addDetails);


                                    Toast.makeText(this, "Submitted successfully" + "\n" + "--> Your id is :: " + id, Toast.LENGTH_SHORT).show();

                                    onBackPressed();

                                } else
                                    Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show();

    }

}