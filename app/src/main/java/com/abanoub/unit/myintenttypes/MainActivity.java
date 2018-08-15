package com.abanoub.unit.myintenttypes;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
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

    /**
     * This method is called when the Open Website button is clicked. It will open the website
     * specified by the URL represented by the variable urlAsString using implicit Intents.
     *
     * @param view Button that was clicked.
     */
    public void onClickOpenWebPage(View view){
        String url = "https://android-developers.googleblog.com/";
        openWebPage(url);
    }

    /**
     * This method is called when the Open send email in email button is clicked. It will open the
     * a mail app and add the sendTo email and the message
     *
     * @param view Button that was clicked.
     */
    public void onClickOpenEmailAddress(View view){
        String email = "test@test.com";
        String message = "Here is my message...";
        openEmailAddress(email, message);
    }

    /**
     * This method is called when the Share Text Content button is clicked. It will simply share
     * the text contained within the String textThatYouWantToShare.
     *
     * @param view Button that was clicked.
     */
    public void onClickShareText(View view){
        String text = "This is my text to share it with you all...";
        shareText(text);
    }

    private void openWebPage(String url){
        // Convert string text to uri to send it as a link
        Uri uri = Uri.parse(url);

        /*
         * Here, we create the Intent with the action of ACTION_VIEW. This action allows the user
         * to view particular content. In this case, our webpage URL.
         */
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);

        /*
         * This is a check we perform with every implicit Intent that we launch. In some cases,
         * the device where this code is running might not have an Activity to perform the action
         * with the data we've specified. Without this check, in those cases your app would crash.
         */
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private void openEmailAddress(String sendTo, String message){
        // intent with action ACTION_SEND for opening an any mail app on your device
        Intent intent = new Intent(Intent.ACTION_SEND);

        // EXTRA_EMAIL for adding the send to email address/es
        intent.putExtra(Intent.EXTRA_EMAIL, sendTo);

        // EXTRA_TEXT for adding the message you want to send
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private void shareText(String textToShare){
        /* ShareCompat.IntentBuilder provides a fluent API for creating Intents */
        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setChooserTitle("Learning How to Share")
                .setText(textToShare)
                .startChooser();
    }
}
