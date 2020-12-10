package com.stevehomes.sreeniavask.todaybtech;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Upload_main_page extends AppCompatActivity {
    Button whatsapp_btn,Mail_share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.upload_main_page);

        whatsapp_btn= findViewById(R.id.whatsapp_btn);
        Mail_share_btn= findViewById(R.id.Mail_share_btn);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#212121")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Send Your Materials");
//        toolbar.setSubtitle("     SteveHomes");
//        toolbar.setLogo(R.drawable.tool_icon);


        Mail_share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Materials" + "&body=" + "Send Your Materials Here..!! " + "&to=" + "stevebrains2019@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Thanks For Helping... [ SteveHomes ]"));
            }
        });

        whatsapp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String mobile = "919398195115";
                    String msg = "This are my Notes";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + mobile + "&text=" + msg)));
                }catch (Exception e){

                }


//
//                Intent sendIntent = new Intent("android.intent.action.MAIN");
//                sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
//                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators("919505501046") +"@s.whatsapp.net");
//                startActivity(sendIntent);
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
                Intent intent=new Intent(this,features.class);
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
