package com.example.android.justjava;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText editText = findViewById(R.id.et);
        String value = editText.getText().toString();
        CheckBox wccb = findViewById(R.id.wccb);
        boolean hasWC = wccb.isChecked();
        CheckBox ccb = findViewById(R.id.wccb);
        boolean hasC = wccb.isChecked();
        int price = calculatePrice(hasWC,hasC);
        displayMessage(createOrderSummery(value, price, hasWC, hasC));
    }

    private int calculatePrice(boolean addWC, boolean addC){
        int baseP = 30;
        if(addWC){
            baseP += 5 ;
        }
        if(addC){
            baseP += 10 ;
        }
        return quantity * baseP;
    }

    private String createOrderSummery(String name, int price, boolean addWC, boolean addC){
        String priceMessage = "Name : " + name;
        priceMessage += "\nAdd Whipped Cream ? " + addWC;
        priceMessage += "\nAdd Chocolate ? " + addC;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal : ₹" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.qtv);
        quantityTextView.setText( "" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String s) {
        TextView orderSummaryTextView = findViewById(R.id.ostv);
        orderSummaryTextView.setText(s);
    }
}