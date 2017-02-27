package com.sachinsbethur.technicalsyllabusquestionpapers;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class DiplomaOptions extends AppCompatActivity {

    private Button btnSyllabus,btnQuestionpapers,btnLabManuals;
    Bundle bundle;
    //private ImageView adIv;
    public int diploma,be, diplomaCet, syllabus =0,questionPapers=0,labManuals=0;
    private ScrollTextView adTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diploma_options);
        btnSyllabus=(Button)findViewById(R.id.btnSyllabus);
        btnQuestionpapers=(Button)findViewById(R.id.btnQuestionPapers);
        btnLabManuals=(Button)findViewById(R.id.btnLabManuals);
        bundle=getIntent().getExtras();
        diploma=bundle.getInt("diploma");
        be=bundle.getInt("be");
        diplomaCet=bundle.getInt("diplomaCet");
        adTv=(ScrollTextView) findViewById(R.id.tvAds);
        adTv.setTextColor(Color.BLACK);
        adTv.setSingleLine(true);
        adTv.setText("Nandi Coaching Centre now in MYSORE & VIJAYANAGAR,BANGALORE \t We are going to conduct tutions for DIPLOMA /diploma CET/ BE (ANY SUBJECTS ANY BRANCH )   ( EC, EE, CS, IS, ME, CE ) BE  Subjects : * M1,M2,M3,M4 and dipmath301,401 * Network analysis * Field theory * Control system * Signals & systems * AEC ..........etc All subjects \t Diploma subjects:M1 & M2 ,SCEINCE ,BEEE,SCD,DE ,C-progm , AC,AE,EMI, SOM,TOM,Termal,graphics,DME,fluid power,WT,..............etc \t 8th,9th,10th, and PUC (state,cbse,icse ) \t Admission open, batches will start \t for more info contact www.nandicoaching.com 9740488603,9880349593 \t Address:Nandi coaching centre LAND MARK: Maruti mandir vijayanagar No- 51/102, 20th main road, marenahalli road near sai krupa hospital vijayanagar Bangalore-40");
        adTv.setSelected(true);
        adTv.setTextSize(20f);
        adTv.startScroll();
        if(diploma==1){
            btnLabManuals.setVisibility(View.VISIBLE);
        }
        else {
            btnLabManuals.setVisibility(View.INVISIBLE);
        }
        btnLabManuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labManuals=1;
                launchWebview();
                labManuals=0;
            }
        });

        btnSyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                syllabus =1;
                if (diplomaCet==1 && diploma==0 && be==0){
                    launchWebview();
                }else if(be==1 && diploma==0 && diplomaCet==0){
                    launchWebview();
                }else{
                    launchWebview();
                }
                syllabus=0;

            }
        });

        btnQuestionpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionPapers=1;
                if (diplomaCet==1 && diploma==0 && be==0){
                    launchWebview();
                }
                else if(be==1 && diploma==0 && diplomaCet==0){
                    launchWebview();
                }
                else{
                    launchWebview();
                }
                questionPapers=0;

            }
        });

    }

    private void launchWebview(){
        Intent wview=new Intent(this,WebViewActivity.class);
        wview.putExtra("diploma",diploma);
        wview.putExtra("be",be);
        wview.putExtra("diplomaCet",diplomaCet);
        wview.putExtra("syllabus",syllabus);
        wview.putExtra("questionPapers",questionPapers);
        wview.putExtra("labManuals",labManuals);
        startActivity(wview);
    }


}
