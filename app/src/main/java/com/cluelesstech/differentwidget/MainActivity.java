package com.cluelesstech.differentwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private SeekBar seekBar;
    private TextView resultText;
    private ToggleButton toggleButton;
    private TextView toggleButtonResult;
    private CheckBox red, blue, black;
    private TextView checkboxText;
    private Button submit;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        //Radio

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.rb_no: {
                        Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case R.id.rb_yes: {
                        Toast.makeText(getApplicationContext(),"YES",Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case R.id.rb_notDecided: {
                        Toast.makeText(getApplicationContext(),"NOT DECIDED",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        //SeekBar
        resultText = findViewById(R.id.resultid);
        seekBar = findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultText.setTextColor(Color.RED);
                resultText.setText("Rate : " + seekBar.getProgress() + "/" + seekBar.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() >= 7){
                    resultText.setTextColor(Color.BLUE);
                }
            }
        });

        //toggle button
        toggleButtonResult = findViewById(R.id.toggleButtonResult);
        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Toggle is enable
                    toggleButtonResult.setVisibility(View.VISIBLE);
                }else{
                    //Toggle is disable
                    toggleButtonResult.setVisibility(View.INVISIBLE);
                }
            }
        });

        //check box
        red = findViewById(R.id.Red);
        black = findViewById(R.id.black);
        blue = findViewById(R.id.blue);
        checkboxText = findViewById(R.id.chkBoxValue);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(red.getText().toString() + " status is :" + red.isChecked() + " \n");
                stringBuilder.append(blue.getText().toString() + " status is :" + blue.isChecked() + " \n");
                stringBuilder.append(black.getText().toString() + " status is :" + black.isChecked() + " \n");

                checkboxText.setText(stringBuilder);
            }
        });
    }
}
