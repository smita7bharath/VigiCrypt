package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private EditText keyText;
    private TextView outputText;
    private Button encryptButton;
    private Button decryptButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        keyText = findViewById(R.id.keyText);
        outputText = findViewById(R.id.outputText);
        encryptButton = findViewById(R.id.encryptButton);
        decryptButton = findViewById(R.id.decryptButton);

        encryptButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = inputText.getText().toString().toUpperCase();
                String key = keyText.getText().toString().toUpperCase();
                String output = VigenereCipher.encrypt(input, key);
                outputText.setText(output);
            }
        });

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputText.getText().toString().toUpperCase();
                String key = keyText.getText().toString().toUpperCase();
                String output = VigenereCipher.decrypt(input, key);
                outputText.setText(output);
            }
        });
    }
}