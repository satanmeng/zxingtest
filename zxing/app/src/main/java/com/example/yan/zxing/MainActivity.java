package com.example.yan.zxing;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private TextView test;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Object ob=null;
                switch (tabId) {
                    case R.id.main:
                        ob  = new fragmentone();
                        break;
                    case R.id.testb:
                        ob  = new fragmenttwo();
                        break;
                    case R.id.testc:
                        ob  = new fragmentthree();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content,(Fragment) ob).commit();
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new fragmentone()).commit();
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            String result = scanResult.getContents();
            /*
            Bundle b=getIntent().getExtras();
            //test=(TextView)data.getBundleExtra("key");
            test=(TextView)b.get("key");
            Toast.makeText(getApplicationContext(),"f"+test.getText(),Toast.LENGTH_SHORT);
            */
            /*
            v=LayoutInflater.from(MainActivity.this).inflate(R.layout.fragment1,null);
            setContentView(R.layout.fragment1);
            test=(TextView)v.findViewById(R.id.isbn);
            //setContentView(R.layout.fragment1);
            */
           fragmentone.settext(result);

        }
    }
}
