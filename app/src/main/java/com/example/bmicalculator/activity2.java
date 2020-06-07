package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.bmicalculator.MainActivity.FINAL_RESULT;

public class activity2 extends AppCompatActivity {

    Button mRecalculateButton;
    TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);



        mRecalculateButton = findViewById(R.id.recalculateButton);
        mResultTextView = findViewById(R.id.result);


        Intent intent = getIntent();


        String textResults = intent.getStringExtra(FINAL_RESULT);
        mResultTextView.setText("" + textResults);



        mRecalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
