package edu.hzuapps.androidlabs.sec1814080911213;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.sec1814080911213.R;

public class PerformanceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911213Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Drawable drawable = getResources().getDrawable(R.drawable.performance);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
