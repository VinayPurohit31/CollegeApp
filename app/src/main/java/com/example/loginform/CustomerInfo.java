package com.example.loginform;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CustomerInfo extends AppCompatActivity {
    private EditText etFirstName, etLastName, etAge, etMobile;
    private RadioGroup rgGender;
    private Spinner spinnerState, spinnerCountry;
    private Button btnSubmit;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_info);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        rgGender = findViewById(R.id.rgGender);
        spinnerState = findViewById(R.id.spinnerState);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        etMobile = findViewById(R.id.etMobile);
        btnSubmit = findViewById(R.id.btnSubmit);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        // Populate spinners
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this,
                R.array.states_array, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(stateAdapter);

        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });
    }

    private void saveUserInfo() {
        String userId = mAuth.getCurrentUser().getUid();
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String state = spinnerState.getSelectedItem().toString();
        String country = spinnerCountry.getSelectedItem().toString();

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton == null ? "" : selectedGenderRadioButton.getText().toString();

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(age) ||
                TextUtils.isEmpty(gender) || TextUtils.isEmpty(state) || TextUtils.isEmpty(country) ||
                TextUtils.isEmpty(mobile)) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> user = new HashMap<>();
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("age", age);
        user.put("gender", gender);
        user.put("state", state);
        user.put("country", country);
        user.put("mobile", mobile);

        DocumentReference userDoc = db.collection("users").document(userId);
        userDoc.set(user)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(CustomerInfo.this, "User info saved", Toast.LENGTH_SHORT).show();
                    // Navigate to the next activity or close this one
                })
                .addOnFailureListener(e -> Toast.makeText(CustomerInfo.this, "Error saving user info", Toast.LENGTH_SHORT).show());
    }
}