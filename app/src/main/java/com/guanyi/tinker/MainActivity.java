package com.guanyi.tinker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text);

        (text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Click",Toast.LENGTH_LONG).show();
                TinkerPatch.with().fetchPatchUpdate(true);//tinker不主动推更新，可以使用应用通知，来通知APP更新，demo中使用一个click事件触发
            }
        });
    }
}
