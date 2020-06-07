package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.example.bmicalculator.MainActivity.FINAL_RESULT;

public class activity2 extends AppCompatActivity {

    Button mRecalculateButton;
    TextView mResultTextView;
    TextView mAdviceLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);



        mRecalculateButton = findViewById(R.id.recalculateButton);
        mResultTextView = findViewById(R.id.result);
        mAdviceLabel = findViewById(R.id.advice);
        RelativeLayout currentLayout = findViewById(R.id.screen);








        Intent intent = getIntent();


        float textResults = intent.getFloatExtra(FINAL_RESULT, 0);
        mResultTextView.setText("" + textResults);



        if (textResults < 18.5) {
            mAdviceLabel.setText("Eat more pies!");

            currentLayout.setBackgroundColor(Color.GREEN);

        } else if (textResults < 24.9) {
            mAdviceLabel.setText("Fit as a fiddle!");
            currentLayout.setBackgroundColor(Color.CYAN);
        } else {
            currentLayout.setBackgroundColor(Color.RED);
            mAdviceLabel.setText("Go for a walk or eat less pies");
        }



        mRecalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
