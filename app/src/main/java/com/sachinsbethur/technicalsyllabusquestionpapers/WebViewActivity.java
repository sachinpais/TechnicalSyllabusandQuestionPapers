package com.sachinsbethur.technicalsyllabusquestionpapers;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private Bundle bundle;
    private TextView tvTitleBar;
    int diploma,be,diplomaCet,oldScheme,newScheme,sem,syllabus,questionPapers,labManuals;
    private ProgressBar progressBar;
    private List<String> previous = new ArrayList<String>();
    private String mLastUrl;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog alertDialog;
    private static final String NANDICOACHING="NANDICOACHING";
    private ConnectivityManager cm;
    private NetworkInfo ni;
    private ScrollTextView scrollView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        scrollView=(ScrollTextView)findViewById(R.id.scrollView);
        tvTitleBar=(TextView)findViewById(R.id.tvTitle);
        tvTitleBar.setTextColor(Color.WHITE);
        //tvTitleBar.setVisibility(View.INVISIBLE);
        scrollView.setTextColor(Color.BLACK);
        scrollView.setSingleLine(true);
        //adTv.setSelected(true);
        //adTv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        scrollView.setText("Nandi Coaching Centre now in MYSORE & VIJAYANAGAR,BANGALORE \t We are going to conduct tutions for DIPLOMA /diploma CET/ BE (ANY SUBJECTS ANY BRANCH )   ( EC, EE, CS, IS, ME, CE ) BE  Subjects : * M1,M2,M3,M4 and dipmath301,401 * Network analysis * Field theory * Control system * Signals & systems * AEC ..........etc All subjects \t Diploma subjects:M1 & M2 ,SCEINCE ,BEEE,SCD,DE ,C-progm , AC,AE,EMI, SOM,TOM,Termal,graphics,DME,fluid power,WT,..............etc \t 8th,9th,10th, and PUC (state,cbse,icse ) \t Admission open, batches will start \t for more info contact www.nandicoaching.com 9740488603,9880349593 \t Address:Nandi coaching centre LAND MARK: Maruti mandir vijayanagar No- 51/102, 20th main road, marenahalli road near sai krupa hospital vijayanagar Bangalore-40");
        scrollView.setSelected(true);
        scrollView.setTextSize(20f);
        scrollView.startScroll();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        bundle=getIntent().getExtras();
        diploma=bundle.getInt("diploma");
        be=bundle.getInt("be");
        diplomaCet=bundle.getInt("diplomaCet");
        //oldScheme=bundle.getInt("oldScheme");
        //newScheme=bundle.getInt("newScheme");
        syllabus=bundle.getInt("syllabus");
        questionPapers=bundle.getInt("questionPapers");
        labManuals=bundle.getInt("labManuals");
        //sem=bundle.getInt("sem");
        webView=(WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        //webView.getSettings().setAppCachePath("/data/data/com.sachinsbethur.technicalsyllabusquestionpapers/cache"‌​);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setWebViewClient(new WebViewClient1());
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
            }
        });
        alertDialogBuilder = new AlertDialog.Builder(WebViewActivity.this);
        alertDialogBuilder.setTitle("No connection");
        // set dialog message
        alertDialogBuilder
                .setMessage("No Internet connection")
                .setCancelable(true)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        if(!isNetworkConnected()){
                            alertDialog.show();
                        }
                    }
                });
        alertDialog = alertDialogBuilder.create();

        if(diploma==1 && syllabus==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else {
                tvTitleBar.setText("Syllabus");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PdjZvelFDbWJmc3M");
            }
        }
        else if(diplomaCet==1 && syllabus==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else {
                //tvTitleBar.setText("Syllabus");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PcXdMbEs3MWdoUTg");
            }
        }
        else if(diploma==1 && labManuals==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else {
                //tvTitleBar.setText("Lab Manuals");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64Pb0kzaDhYR3lCOWs");
            }
        }
        else if(diplomaCet==1 && questionPapers==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else{
                //tvTitleBar.setText("Question Papers");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PQ0VyeHVYTThRSEE");
            }
        }
        else if(diploma==1 && questionPapers==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else {
                //tvTitleBar.setText("Question Papers");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PRVBNREg2ZmFiMFU");
            }
        }
        else if(be==1 && syllabus==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else{
                //tvTitleBar.setText("Syllabus");
            webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PcVFKVE5yMlNwUm8");
            }
        }
        else if(be==1 && questionPapers==1){
            if(isNetworkConnected()!=true){
                alertDialog.show();
            }else {
                //tvTitleBar.setText("Question Papers");
                webView.loadUrl("https://drive.google.com/open?id=0B4k6l2nbq64PTm1fUVJVTmJUSVU");
            }
        }

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                WebView.HitTestResult hr  = ((WebView)view).getHitTestResult();
                if (hr != null && mLastUrl != null) {
                    if (previous.isEmpty() || !previous.get(previous.size() - 1).equals(mLastUrl)) {
                        previous.add(mLastUrl);
                        url=mLastUrl;
                    }
                    Log.i(NANDICOACHING, "getExtra = " + hr.getExtra() + "\t\t Type = " + hr.getType());
                }
                return false;
            }
        });
    }

    public void onBackPressed() {
        //Log.i(NANDICOACHING, "onBackPressed");
        int size = previous.size();
        if (size > 0){
            webView.loadUrl(previous.get(size - 1));
            previous.remove(size - 1);
        } else {
            super.onBackPressed();
        }
    }

    private boolean isNetworkConnected() {
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            //alertDialog.show();
            return false;
        }
        else{
            //webView.loadUrl( url );
            return true;
        }
    }
    class WebViewClient1 extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.i("DebugDebug", "OnPageFinished " + url);
            mLastUrl = url;
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(100);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            //isNetworkConnected();
        }
    }
}
