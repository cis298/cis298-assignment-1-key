package edu.kvcc.cis298.personcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    private Button mMinusButton;
    private Button mPlusButton;
    private TextView mCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Declare and assign a variable for the view's counter control
        mCounterTextView = (TextView) findViewById(R.id.counter_textview);
        // Assign a default starting value to the CounterTextView
        mCounterTextView.setText("0");

        // Declare and assign a variable for the view's minus button control
        mMinusButton = (Button) findViewById(R.id.minus_button);
        // Set the OnClickListener with an anonymous inner class to handle the onclick event
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current text value
                String currentValue = mCounterTextView.getText().toString();
                // Cast the currentValue to an integer
                int currentIntValue = Integer.parseInt(currentValue);

                // If the current value is not already zero, we can decrement it further
                if (currentIntValue > 0) {
                    // Decrease the value of currentIntValue
                    currentIntValue--;
                    // Set the text of the counter to the previous text - 1
                    mCounterTextView.setText(Integer.toString(currentIntValue));
                }
            }
        });

        // Declare and assign a variable for the view's plus button control
        mPlusButton = (Button) findViewById(R.id.plus_button);
        // Set the OnClickListener with an anonymous inner class to handle the onclick event
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current text value
                String currentValue = mCounterTextView.getText().toString();
                // Cast the currentValue to an integer
                int currentIntValue = Integer.parseInt(currentValue);
                // Increase the value of currentValue
                currentIntValue++;
                // Set the text of the previous counter value plus 1
                mCounterTextView.setText(Integer.toString(currentIntValue));

                // Check to see if the currentIntValue is above 20
                if (currentIntValue == 21) {
                    // Toast message to user that they have surpassed 20
                    Toast.makeText(
                            CounterActivity.this,
                            R.string.above_20_toast,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}
