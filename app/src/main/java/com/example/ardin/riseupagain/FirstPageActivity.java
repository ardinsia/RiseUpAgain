package com.example.ardin.riseupagain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstPageActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextValue;
    FirebaseAuth mAuth;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mValueRef = mRootRef.child("records").child("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        editTextValue = (EditText) findViewById(R.id.editValue);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.buttonLogout).setOnClickListener(this);
        findViewById(R.id.buttonSave).setOnClickListener(this);
        //mValueRef.setValue("ardin");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.buttonLogout:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.buttonSave:
                saveUserInformation();
                break;

        }}

    private void saveUserInformation() {
        String value = editTextValue.getText().toString().trim();

        if(value.isEmpty()){
            editTextValue.setError("Value is required");
            editTextValue.requestFocus();
            return;

    }
        mValueRef.setValue(value);

}}
