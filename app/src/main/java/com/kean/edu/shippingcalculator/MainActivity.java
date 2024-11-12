package com.kean.edu.shippingcalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ShipItem shipItem;

    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shipItem = new ShipItem();

        weightET = (EditText) findViewById(R.id.userInput);

        baseCostTV = (TextView) findViewById(R.id.baseNum);
        addedCostTV = (TextView) findViewById(R.id.addedNum);
        totalCostTV = (TextView) findViewById(R.id.shippingNum);

        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    shipItem.setWeight((int)Double.parseDouble(s.toString()));
                } catch (NumberFormatException e) {
                    shipItem.setWeight(0);
                }
                displayShipping();
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

    public void displayShipping() {
        baseCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));

    }
}