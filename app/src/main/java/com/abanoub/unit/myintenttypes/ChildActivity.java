package com.abanoub.unit.myintenttypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    /* Constant key for the intent to get the message from MainActivity */
    public static final String MESSAGE_KEY = "message";

    /* Field that will store our TextView */
    private TextView mDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        /* Using findViewById, we get a reference to our TextView from xml */
        mDisplayMessage = findViewById(R.id.tv_display);

        // intent to get intent data from another activity
        Intent intent = getIntent();

        // Check if the intent has extra string with MESSAGE_KEY
        if (intent.hasExtra(MESSAGE_KEY)){

            //retrieve the sending String data from an intent
            String text = intent.getStringExtra(MESSAGE_KEY);
            mDisplayMessage.setText(text);
        }
    }
}
