package com.gauravthakur.quotefire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] quotes;
    private TextView quoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quotes = getResources().getStringArray(R.array.quotes);
        quoteTextView = findViewById(R.id.quote_textview);
        Button loadButton = findViewById(R.id.load_button);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadRandomQuote();
            }
        });

        Button shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareQuote();
            }
        });
    }

    private void loadRandomQuote() {
        int randomIndex = (int) (Math.random() * quotes.length);
        String randomQuote = quotes[randomIndex];
        quoteTextView.setText(randomQuote);
    }

    private void shareQuote() {
        String currentQuote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Share Quote"));
    }
}
