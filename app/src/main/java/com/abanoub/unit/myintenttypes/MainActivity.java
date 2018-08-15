package com.abanoub.unit.myintenttypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* Fields that will store our EditText and Button */
    private EditText mMessageText;
    private Button mExecute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Using findViewById, we get a reference to our Button from xml. This allows us to
         * do things like set the onClickListener which determines what happens when the button
         * is clicked.
         */
        mExecute = findViewById(R.id.b_execute);
        mMessageText = findViewById(R.id.et_text_entry);

        /* Setting an OnClickListener allows us to do something when this button is clicked. */
        mExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mMessageText.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}
