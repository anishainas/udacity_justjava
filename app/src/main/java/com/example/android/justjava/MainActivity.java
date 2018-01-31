package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText inputName = findViewById(R.id.input_name);
        CheckBox checkboxWhip = findViewById(R.id.checkbox_whip);
        CheckBox checkboxChocolate = findViewById(R.id.checkbox_chocolate);
        TextView summary = findViewById(R.id.summary);

        String whippedCream = (checkboxWhip.isChecked())?"true":"false";
        String chocolate = (checkboxChocolate.isChecked())?"true":"false";

        StringBuilder summaryMessage = new StringBuilder();
        summaryMessage.append("Name: "+inputName.getText());
        summaryMessage.append("\nAdd whipped cream? " + whippedCream);
        summaryMessage.append("\nAdd chocolate? " + chocolate);
        summaryMessage.append("\nQuantity: " + quantity);
        summaryMessage.append("\nTotal: $" + price);
        summaryMessage.append("\nThank you!");

        summary.setText(summaryMessage.toString());

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        displayPrice(price);
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
        price+=5;
        display(quantity);
    }

    public void decreaseOrder(View view){
        if (quantity>0){
            quantity--;
            price-=5;
            display(quantity);
        }
    }

    public void checkToppings(View view) {
        CheckBox whip = (CheckBox) findViewById(R.id.checkbox_whip);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox_chocolate);

        if (view.getId() == R.id.checkbox_whip){
            if (whip.isChecked()){
                price+=1;
            } else {
                price-=1;
            }
        } else if (view.getId() == R.id.checkbox_chocolate){
            if (chocolate.isChecked()){
                price+=2;
            } else {
                price-=2;
            }
        }

        if (quantity>0){
            displayPrice(price);
        }
    }
}