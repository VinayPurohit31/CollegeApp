package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    TextView username;
    FirebaseAuth auth;
    FirebaseUser user;
    Button logout,fillInfoBtn,homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout=findViewById(R.id.logoutbutton);
        fillInfoBtn=findViewById(R.id.CustomerFormBtn);
        homeBtn=findViewById(R.id.HomePageBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        fillInfoBtn.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),CustomerInfo.class);
            startActivity(intent);
        });
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        username=findViewById(R.id.username);
        if(user == null){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            username.setText(user.getEmail());
        }
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void openHome() {
        Intent intent=new Intent(getApplicationContext(),Home_page.class);
        startActivity(intent);
    }

}