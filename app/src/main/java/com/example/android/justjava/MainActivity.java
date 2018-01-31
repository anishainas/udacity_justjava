package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox checkboxWhip = findViewById(R.id.checkbox_whip);
        TextView summary = findViewById(R.id.summary);

        String whippedCream = (checkboxWhip.isChecked())?"true":"false";

        StringBuilder summaryMessage = new StringBuilder();
        summaryMessage.append("Name: Lyla Labyrinth");
        summaryMessage.append("\nAdd whipped cream? " + whippedCream);
        summaryMessage.append("\nQuantity: " + quantity);
        summaryMessage.append("\nTotal: $" + quantity*5);
        summaryMessage.append("\nThank you!");

        summary.setText(summaryMessage.toString());

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        displayPrice(5*quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.summary);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increaseOrder(View view) {
        quantity++;
        display(quantity);
    }

    public void decreaseOrder(View view){
        if (quantity>0){
            quantity--;
            display(quantity);
        }
    }
}