package com.goodhub.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnred , btnyellow;
    LinearLayout layout1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnred = findViewById(R.id.red);
        btnyellow = findViewById(R.id.yellow);
        layout1 = findViewById(R.id.layout);

        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red_fragment firstfragment = new red_fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout, firstfragment);
                transaction.commit();
            }
        });
        btnyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellow_fragment secondFragment = new yellow_fragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout,secondFragment);
                transaction.commit();
            }
        });
    }
    }

