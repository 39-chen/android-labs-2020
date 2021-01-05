package edu.hzuapps.androidlabs.net1814080903115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brouse);


        Button btnBack = (Button) findViewById(R.id.button_back);
//        btnBack.setX(420f);
//        btnBack.setY(1300f);
        View view = findViewById(R.id.button_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrowseActivity.this, Net1814080903115Activity.class);
                BrowseActivity.this.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}