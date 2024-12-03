package com.example.cylinder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Reference UI elements
        EditText editTextRadius=findViewById(R.id.etRadius);
        EditText editTextHeight=findViewById(R.id.etHeight);
        Button buttonCalculate=findViewById(R.id.btnCalculate);
        TextView editTextSA=findViewById(R.id.tvSAAns);
        TextView editTextVolume=findViewById(R.id.tvVolAns);
        Button buttonReset=findViewById(R.id.btnReset);

        //Click listener for buttons
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get input values
                String radiusInput = editTextRadius.getText().toString();
                String heightInput = editTextHeight.getText().toString();

                //Check if empty
                if(radiusInput.isEmpty() || heightInput.isEmpty()) {
                    editTextSA.setText("Please enter both radius and height!");
                    return;
                }

                //Parse input
                double radius = Double.parseDouble(radiusInput);
                double height = Double.parseDouble(heightInput);

                //Calculate SA and Volume
                double x = 2*Math.PI*radius*radius;
                double y = 2*Math.PI*radius*height;

                double surfaceArea = x+y;
                double volume = Math.PI*radius*radius*height;

                //Display results
                editTextSA.setText(String.format("%d square units", Math.round(surfaceArea)));
                editTextVolume.setText(String.format("%d cubed units", Math.round(volume)));

            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear input fields
                editTextRadius.setText("");
                editTextHeight.setText("");
                editTextSA.setText("");
                editTextVolume.setText("");
            }
        });

    }
}