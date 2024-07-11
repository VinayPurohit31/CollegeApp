package com.example.loginform;

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

public class Calculator extends AppCompatActivity {
    Button addBTn,subBtn,mulBtn,divBtn;
    EditText enter1,enter2;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        addBTn=findViewById(R.id.Addition);
        subBtn=findViewById(R.id.substraction);
        mulBtn=findViewById(R.id.multiplycation);
        divBtn=findViewById(R.id.division);
        enter1=findViewById(R.id.EnterNO1);
        enter2=findViewById(R.id.EnterNO2);
        resultText=findViewById(R.id.Result);
        //Clicking button
        addBTn.setOnClickListener(v -> {
            addNo();
        });

        subBtn.setOnClickListener(v -> {
            subNo();
        });

        mulBtn.setOnClickListener(v -> {
            mulNo();
        });

        divBtn.setOnClickListener(v -> {
            divNo();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void divNo() {
        String num1Str = enter1.getText().toString();
        String num2Str = enter2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = num1 / num2;

            resultText.setText("Result: " + result);
        } else {
            resultText.setText("Please enter both numbers.");
        }
    }

    private void mulNo() {
            String num11Str = enter1.getText().toString();
            String num22Str = enter2.getText().toString();

            if (!num11Str.isEmpty() && !num22Str.isEmpty()) {
                double num1 = Double.parseDouble(num11Str);
                double num2 = Double.parseDouble(num22Str);
                double result = num1 * num2;

                resultText.setText("Result: " + result);
            } else {
                resultText.setText("Please enter both numbers.");
        }
    }

    private void subNo() {
            String num111Str = enter1.getText().toString();
            String num222Str = enter2.getText().toString();

            if (!num111Str.isEmpty() && !num222Str.isEmpty()) {
                double num1 = Double.parseDouble(num111Str);
                double num2 = Double.parseDouble(num222Str);
                double result = num1 - num2;

                resultText.setText("Result: " + result);
            } else {
                resultText.setText("Please enter both numbers.");
        }
    }

    private void addNo() {
            String num11111Str = enter1.getText().toString();
            String num22222Str = enter2.getText().toString();

            if (!num11111Str.isEmpty() && !num22222Str.isEmpty()) {
                double num1 = Double.parseDouble(num11111Str);
                double num2 = Double.parseDouble(num22222Str);
                double result = num1 + num2;

                resultText.setText("Result: " + result);
            } else {
                resultText.setText("Please enter both numbers.");
        }
    }
}