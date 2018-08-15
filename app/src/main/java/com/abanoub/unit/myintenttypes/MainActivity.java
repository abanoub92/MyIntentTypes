package com.abanoub.unit.myintenttypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                //retrieve the text from the mMessageText (EditText)
                String text = mMessageText.getText().toString();

                /*
                 * intent is responsible of moving to another activity by determine
                 * first the context (the activity well leave it)
                 * second the class (the activity well move to it)
                 * that's what android called explicit intent
                 */
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);

                // Send the text of the EditText to ChildActivity to display it
                intent.putExtra(ChildActivity.MESSAGE_KEY, text);

                // move to ChildActivity
                startActivity(intent);
            }
        });
    }
}
