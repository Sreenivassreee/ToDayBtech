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

public class drawing_contant extends AppCompatActivity {
    Toolbar toolbar;
    ScrollView myScrollview;
    Button points,lines,solids,dep_solids,iso_projections,orth_projections,cycloidal,involute,conic,dep_surfaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.drawing_contant);

        toolbar=findViewById(R.id.toolbar);
        myScrollview=findViewById(R.id.scrollview);
        points=findViewById(R.id.points);
        lines=findViewById(R.id.lines);
        solids=findViewById(R.id.solids);

        iso_projections=findViewById(R.id.iso_projections);
        orth_projections=findViewById(R.id.orth_projections);
        cycloidal=findViewById(R.id.cycloidal);
        involute=findViewById(R.id.involute);
        conic=findViewById(R.id.conic);
        dep_surfaces=findViewById(R.id.dep_surfaces);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);
        getSupportActionBar().setTitle("  ToDayBtech");
        toolbar.setSubtitle("     SteveHomes");
//        toolbar.setLogo(R.drawable.tool_icon);
        myScrollview.setVerticalScrollBarEnabled(false);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.tool_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_points.class);
                startActivity(intent);
            }
        });
        lines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_lines.class);
                startActivity(intent);
            }
        });

        solids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_solids.class);
                startActivity(intent);
            }
        });
        dep_surfaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_develop_surfaces.class);
                startActivity(intent);
            }
        });
        iso_projections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_iso_projections.class);
                startActivity(intent);
            }
        });
        orth_projections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_orth_projections.class);
                startActivity(intent);
            }
        });
        cycloidal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_cyc_curves.class);
                startActivity(intent);
            }
        });
        involute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_involute.class);
                startActivity(intent);
            }
        });
        conic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(drawing_contant.this, you_draw_conic_sec_curves.class);
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
                Intent intent=new Intent(this, features.class);
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



