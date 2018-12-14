package com.android.fronc.project_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openOneStringItemActivity(View view) {
        Intent intent = new Intent(this, OneStringItemActivity.class);
        startActivity(intent);
    }

    public void openSimpleItemActivity(View view) {
        Intent intent = new Intent(this, SimpleItemLayoutActivity.class);
        startActivity(intent);
    }

    public void openTwoStringItemActivity(View view) {
        Intent intent = new Intent(this, TwoStringItemActivity.class);
        startActivity(intent);
    }

    public void openCustomActivity(View view) {
        Intent intent = new Intent(this, CustomActivity.class);
        startActivity(intent);
    }
}
