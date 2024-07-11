package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button createbutton,loginbutton, calculator;
    EditText textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        calculator = findViewById(R.id.CalculatorB);
        loginbutton = findViewById(R.id.LoginButton);
        createbutton = findViewById(R.id.CereateButton);
        calculator.setOnClickListener(v -> {
            calActivity();
        });
        createbutton.setOnClickListener(v -> createacc());

        loginbutton.setOnClickListener(v -> secondaccticity());
    }
    private void secondaccticity(){
        String username = textView.getText().toString().trim();
        String password = textView2.getText().toString().trim();

        // For demonstration, showing a Toast message. In a real app, you should verify the credentials.
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
        } else {
            // Implement your login logic here
            if (username.equals("admin") && password.equals("1234")) {
                // Login successful
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                // Navigate to another activity
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                finish();
            } else {
                // Login failed
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private  void createacc(){
        Intent intent1=new Intent(getApplicationContext(), Ccreate_account.class);
        startActivity(intent1);
    }
    private  void calActivity(){
        Intent intent1=new Intent(getApplicationContext(), Calculator.class);
        startActivity(intent1);
    }
}