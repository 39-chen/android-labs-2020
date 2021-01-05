package edu.hzuapps.androidlabs.net1814080903312;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {
    private Button mBtReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        mBtReturn = findViewById(R.id.bt_play_return);
        mBtReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this,Net1814080903312Activity.class);
                startActivity(intent);
            }
        });
    }
}