package com.example.toolkit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {

    private String[] decimalSpinnerOptions = {"Binary", "Octal", "Hexadecimal"};
    private ArrayAdapter<String> decimalSpinnerAdapter;

    private String[] byteSpinnerOptions = {"MB","KB","KiB","Bit"};

    private ArrayAdapter<String> byteSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        EditText decimalInput = findViewById(R.id.decimalInput);
        EditText byteInput = findViewById(R.id.byteInput);
        EditText celsiusInput = findViewById(R.id.celsiusInput);

        Spinner decimalSpinner = findViewById(R.id.decimalSpinner);
        decimalSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, decimalSpinnerOptions);
        decimalSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        decimalSpinner.setAdapter(decimalSpinnerAdapter);


        Spinner byteSpinner = findViewById(R.id.byteSpinner);
        byteSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, byteSpinnerOptions);
        byteSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        byteSpinner.setAdapter(byteSpinnerAdapter);

        TextView decimalResult = findViewById(R.id.decimalResult);
        TextView byteResult = findViewById(R.id.byteResult);
        TextView celsiusResult = findViewById(R.id.celsiusResult);

        RadioButton fahrenayt = findViewById(R.id.fahrenayt);
        RadioButton kelvin = findViewById(R.id.kelvin);

        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!decimalInput.getText().toString().isEmpty()){
                    int decimal = Integer.parseInt(decimalInput.getText().toString());
                    String decimalSpinnerValue = decimalSpinner.getSelectedItem().toString();
                    if(decimalSpinnerValue.equals("Binary")){
                        decimalResult.setText(Integer.toBinaryString(decimal));
                    }else if(decimalSpinnerValue.equals("Octal")){
                        decimalResult.setText(Integer.toOctalString(decimal));
                    }else if(decimalSpinnerValue.equals("Hexadecimal")){
                        decimalResult.setText(Integer.toHexString(decimal));
                    }
                }

                if(!byteInput.getText().toString().isEmpty()){
                    double byteValue = Double.parseDouble(byteInput.getText().toString());
                    String byteSpinnerValue = byteSpinner.getSelectedItem().toString();
                    if(byteSpinnerValue.equals("MB")){
                        byteResult.setText(String.valueOf(byteValue * 0.000001));
                    }else if(byteSpinnerValue.equals("KB")){
                        byteResult.setText(String.valueOf(byteValue * 0.001));
                    }else if(byteSpinnerValue.equals("KiB")){
                        byteResult.setText(String.valueOf(byteValue * 0.0009765625));
                    }else if(byteSpinnerValue.equals("Bit")){
                        byteResult.setText(String.valueOf(byteValue * 8));
                    }
                }

                if(!celsiusInput.getText().toString().isEmpty()){
                    double celsius = Double.parseDouble(celsiusInput.getText().toString());
                    if(fahrenayt.isChecked()){
                        celsiusResult.setText(String.valueOf(celsius * 1.8 + 32));
                    }else if(kelvin.isChecked()){
                        celsiusResult.setText(String.valueOf(celsius + 273.15));
                    }
                }
            }
        });
    }
}