# QuoteFire

QuoteFire is an Android application that provides users with a random quote from a pre-defined list and allows them to share the quote with others. This app is built with simplicity and user-friendliness in mind.

## Features

- **Random Quote Generator**: Display a random quote from an array of quotes.
- **Share Quotes**: Easily share your favorite quotes with others via social media or messaging apps.

## Screenshots

![Screenshot 1](path/to/screenshot1.png)
![Screenshot 2](path/to/screenshot2.png)

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/gauravthakur/quotefire.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on an Android device or emulator.

## Usage

1. Open the QuoteFire app.
2. Tap the "Load Quote" button to generate a random quote.
3. Tap the "Share" button to share the displayed quote with others.

## Code Overview

The main functionality of the app is implemented in the `MainActivity` class.

```java
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
```

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`
3. Make your changes and commit them: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Thanks to all the contributors and users for their support and feedback.
- Special thanks to the open-source community for providing the resources and inspiration to build this app.
