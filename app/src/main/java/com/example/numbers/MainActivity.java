package com.example.numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.lang.Math;


public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl, bExit, easyButton, hardButton;
    int number = (int) (Math.random() * 100);
    int max = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.headline1);
        etInput = findViewById(R.id.answer);
        bControl = findViewById(R.id.button1);
        bExit = findViewById(R.id.exit);
        easyButton = findViewById(R.id.level1);
        hardButton = findViewById(R.id.level2);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        String input = etInput.getText().toString();
        if (!input.matches("\\d+")) {
            tvInfo.setText(getResources().getString(R.string.error));
        } else {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber > number && inputNumber <= max) {
                tvInfo.setText(getResources().getString(R.string.ahead));
            } else {
                if (inputNumber < number && inputNumber >= 0) {
                    tvInfo.setText(getResources().getString(R.string.behind));
                } else {
                    if (inputNumber == number) {
                        tvInfo.setText(getResources().getString(R.string.hit));
                    } else {
                        tvInfo.setText(getResources().getString(R.string.error2));
                    }
                }
            }
        }
    }

    public void difficultyEasy(View view) {
        number = (int) (Math.random() * 100);
        tvInfo.setText(getResources().getString(R.string.level1));
        etInput.setText(R.string.notext);
        max = 100;
    }

    public void difficultyHard(View view) {
        number = (int) (Math.random() * 1000);
        tvInfo.setText(R.string.level2);
        etInput.setText(R.string.notext);
        max = 1000;
    }

    public void exit(View view) {
        System.exit(0);
    }
}