package com.example.tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText billAmountEditText;
    private EditText tipPercentEditText;
    private TextView tipAmountTextView;
    private TextView totalAmountTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEditText = findViewById(R.id.bill_amount_edit_text);
        tipPercentEditText = findViewById(R.id.tip_percent_edit_text);
        tipAmountTextView = findViewById(R.id.tip_amount_text_view);
        totalAmountTextView = findViewById(R.id.total_amount_text_view);
    }

    @SuppressLint("DefaultLocale")
    public void calculateTip(View view) {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());
        double tipPercent = Double.parseDouble(tipPercentEditText.getText().toString());

        double tipAmount = billAmount * (tipPercent / 100);
        double totalAmount = billAmount + tipAmount;

        tipAmountTextView.setText(String.format("Сумма чаевых: %.2f ₽", tipAmount));
        totalAmountTextView.setText(String.format("Общая сумма: %.2f ₽", totalAmount));
    }
}
