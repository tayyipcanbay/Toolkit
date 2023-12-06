package com.example.toolkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Random rnd = new Random();

        EditText amountInput = findViewById(R.id.amountInput);
        EditText minInput = findViewById(R.id.minInput);
        EditText maxInput = findViewById(R.id.maxInput);

        Button generateButton = findViewById(R.id.generateButton);
        LinearLayout results = findViewById(R.id.results);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.removeAllViews();
                int amountValue = Integer.parseInt(amountInput.getText().toString());
                int minValue = Integer.parseInt(minInput.getText().toString());
                int maxValue = Integer.parseInt(maxInput.getText().toString());

                for (int i = 0; i < amountValue; i++) {
                    int _min = rnd.nextInt(maxValue - minValue + 1) + minValue;
                    int _max = rnd.nextInt(maxValue - minValue + 1) + minValue;
                    if (_min > _max) {
                        int temp = _min;
                        _min = _max;
                        _max = temp;
                    }
                    int _num = rnd.nextInt(_max - _min + 1) + _min;
                    int _percentage = (_num - _min) * 100 / (_max - _min);

                    TextView minText = new TextView(RandomActivity.this);
                    TextView numText = new TextView(RandomActivity.this);
                    TextView maxText = new TextView(RandomActivity.this);
                    TextView percentageText = new TextView(RandomActivity.this);

                    ProgressBar progressBar = new ProgressBar(RandomActivity.this,null, android.R.attr.progressBarStyleHorizontal);

                    minText.setText(String.valueOf(_min));
                    numText.setText(String.valueOf(_num));
                    maxText.setText(String.valueOf(_max));
                    percentageText.setText(String.valueOf(_percentage));

                    progressBar.setMax(100);
                    progressBar.setProgress(_percentage);

                    results.addView(minText);
                    results.addView(numText);
                    results.addView(maxText);
                    results.addView(percentageText);
                    results.addView(progressBar);



                }
            }
        });

    }
}