package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        display(quantity);
//        displayPrice(quantity*5);
        TextView summaryName = findViewById(R.id.name_text_view);
        TextView summaryQuantity = findViewById(R.id.quantity_sum_text_view);
        TextView summaryPrice = findViewById(R.id.price_text_view);
        TextView summaryThanks = findViewById(R.id.thanks_text_view);

        summaryQuantity.setText("Quantity: " + quantity);
        summaryPrice.setText("Total: $" + 5*quantity);

        summaryName.setVisibility(view.VISIBLE);
        summaryQuantity.setVisibility(view.VISIBLE);
        summaryThanks.setVisibility(view.VISIBLE);
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
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
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