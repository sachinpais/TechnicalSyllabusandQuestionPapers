package com.sachinsbethur.technicalsyllabusquestionpapers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    public int diploma=0,be=0, diplomaCet =0,syallabus=0,questionPapers=0;
    private Button btnDiploma,btnDiplomaCet,btnEngineering;
    private ScrollTextView adTv;
    //WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDiploma=(Button)findViewById(R.id.btnDiploma);
        btnDiplomaCet=(Button)findViewById(R.id.btnDcet);
        btnEngineering=(Button)findViewById(R.id.btnEngineering);
        adTv=(ScrollTextView) findViewById(R.id.tvAds);
        adTv.setTextColor(Color.BLACK);
        adTv.setSingleLine(true);
        adTv.setText("Nandi Coaching Centre now in MYSORE & VIJAYANAGAR,BANGALORE \t We are going to conduct tutions for DIPLOMA /diploma CET/ BE (ANY SUBJECTS ANY BRANCH )   ( EC, EE, CS, IS, ME, CE ) BE  Subjects : * M1,M2,M3,M4 and dipmath301,401 * Network analysis * Field theory * Control system * Signals & systems * AEC ..........etc All subjects \t Diploma subjects:M1 & M2 ,SCEINCE ,BEEE,SCD,DE ,C-progm , AC,AE,EMI, SOM,TOM,Termal,graphics,DME,fluid power,WT,..............etc \t 8th,9th,10th, and PUC (state,cbse,icse ) \t Admission open, batches will start \t for more info contact www.nandicoaching.com 9740488603,9880349593 \t Address:Nandi coaching centre LAND MARK: Maruti mandir vijayanagar No- 51/102, 20th main road, marenahalli road near sai krupa hospital vijayanagar Bangalore-40");
        adTv.setSelected(true);
        adTv.setTextSize(20f);
        adTv.startScroll();

        btnDiploma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diploma=1;
                launchDiplomaOptionsActivity();
                diploma=0;
            }
        });

        btnDiplomaCet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diplomaCet=1;
                launchDcetActivity();
                diplomaCet=0;
            }
        });

        btnEngineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                be=1;
                launchBeActivity();
                be=0;
            }
        });
    }

    private void launchDiplomaOptionsActivity(){
        Intent diplomaOptions=new Intent(this,DiplomaOptions.class);
        diplomaOptions.putExtra("diploma",diploma);
        diplomaOptions.putExtra("be",be);
        diplomaOptions.putExtra("diplomaCet",diplomaCet);
        startActivity(diplomaOptions);
    }
    private void launchBeActivity(){
        Intent beActivity=new Intent(getApplicationContext(),DiplomaOptions.class);
        beActivity.putExtra("diploma",diploma);
        beActivity.putExtra("diplomaCet",diplomaCet);
        beActivity.putExtra("be",be);
        startActivity(beActivity);
    }

    private void launchDcetActivity(){
        Intent diplomaOptions=new Intent(this,DiplomaOptions.class);
        diplomaOptions.putExtra("diploma",diploma);
        diplomaOptions.putExtra("be",be);
        diplomaOptions.putExtra("diplomaCet",diplomaCet);
        startActivity(diplomaOptions);
    }

}
