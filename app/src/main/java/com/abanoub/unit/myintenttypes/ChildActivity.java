package com.abanoub.unit.myintenttypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    public static final String MESSAGE_KEY = "message";

    /* Field that will store our TextView */
    private TextView mDisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        /* Using findViewById, we get a reference to our TextView from xml */
        mDisplayMessage = findViewById(R.id.tv_display);
    }
}
