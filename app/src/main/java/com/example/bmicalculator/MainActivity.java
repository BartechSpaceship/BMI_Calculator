package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String FINAL_RESULT = "com.example.bmicalculator.FINAL_RESULT";


    Button mCalculateButton;
    TextView mWeightLabel;
    TextView mHeightLabel;
    SeekBar mWeightBar;
    SeekBar mHeightBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculateButton = findViewById(R.id.calculateButton);
        mWeightLabel = findViewById(R.id.weight);
        mHeightLabel = findViewById(R.id.height);
        mWeightBar = findViewById(R.id.weightBar);
        mHeightBar = findViewById(R.id.heightBar);

        mWeightBar.setOnSeekBarChangeListener(mWeightSeekBarChangeListener);
        mHeightBar.setOnSeekBarChangeListener(mHeightSeekBarChangeListener);

        mHeightLabel.setText("Height: 50 inch");
        mWeightLabel.setText("Weight: 150 lb");


        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBMIValue();

            }
        });
    }



    //Height
    SeekBar.OnSeekBarChangeListener mHeightSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            mHeightLabel.setText("Height: " + progress + " inch");

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    //Weight Listener
    SeekBar.OnSeekBarChangeListener mWeightSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mWeightLabel.setText("Weight: " + progress + " lb");

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void getBMIValue() {
        final int weightProgress =  mWeightBar.getProgress();
        final float weightProgressDouble = Float.valueOf(weightProgress);
        mWeightLabel.setText("Weight: " + weightProgress + " lb");

        final int heightProgress = mHeightBar.getProgress();
        final float heightProgressDouble = Float.valueOf(heightProgress);
        mHeightLabel.setText("Height: " + heightProgress + " inch");

        float result = ( weightProgressDouble / heightProgressDouble / heightProgressDouble ) * 703;

        String printResult = String.valueOf(result);
        System.out.println(printResult);


        Intent intent = new Intent(this, activity2.class);

        intent.putExtra(FINAL_RESULT, result);
        startActivity(intent);

    }









}
