package com.abraham24.learnfromudacity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class PercobaanPertama extends AppCompatActivity {
    // example from global Variable

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //===Coba bikin TextView tanpa XML===
//        TextView textcoba = new TextView(this);
//        textcoba.setText("Hello World!");
//        textcoba.setTextColor(Color.BLUE);
//        textcoba.setTextSize(20);
//        textcoba.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(PercobaanPertama.this, "Yeay!", Toast.LENGTH_SHORT).show();
//            }
//        });
//      setContentView(textcoba)
        setContentView(R.layout.activity_percobaan_pertama);
    }

    // Method untuk mengurangi quantity yang diambil dari button min
    public void decrement(View view) {
        //susunan declare variabel =>
        // DataType VariableName = InitialValue
        // int quantity = 2;
        if (quantity == 1) {
            Toast.makeText(this, "Terlalu Sedikit", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
//     Input Method display();
        displayQuantity(quantity);
    }
// Method untuk mengurangi quantity yang diambil dari button plus

    public void increment(View view) {
        //susunan declare variabel =>
        // DataType VariableName = InitialValue
        // int quantity = 2;
        if (quantity == 100) {
            Toast.makeText(this, "Terlalu banyak ", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
//     Input Method display();
        displayQuantity(quantity);
    }

    //  Method yang nyambung sama onClick yang ada di XML Button Order
    public void submitOrder(View view) {
        //susunan declare variabel =>
        // DataType VariableName = InitialValue
        //   int quantity = 2;
//     Input Method display();
        //     display(quantity);
//     Input Method displayPrice();
        //     displayPrice(quantity * 5);
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox1);
        boolean hashWippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox2);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("PercobaanPertama", "Name : " + name);
        int price = calculatePrice(hashWippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, price, hashWippedCream, hasChocolate);
        displayMessage(priceMessage);


    }

    //    Pusat penghitungan dari method display();
    private void displayQuantity(int numberOfCoffees) {
//    Inisialisasi TextView
        TextView quantityTextView = (TextView) findViewById(R.id.textquantity);
//    setText dari penghitungan yang sudah diinput di Method submitOrder();
        quantityTextView.setText("" + numberOfCoffees);
    }

//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.textprice);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(boolean krim, boolean coklat) {
        int basePrice = 5;

        if (krim) {
            basePrice = basePrice + 1;

        }
        if (coklat) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name : " + name + "\n";
        priceMessage = priceMessage + "Quantity : " + quantity + "\n";
        priceMessage = priceMessage + "Whipped Cream " + addWhippedCream + "\n";
        priceMessage = priceMessage + "Chocolate " + hasChocolate + "\n";
        priceMessage = priceMessage + "Total : $" + price + "\n";
        priceMessage = priceMessage + "Thank you!";

        return priceMessage;
    }
}
