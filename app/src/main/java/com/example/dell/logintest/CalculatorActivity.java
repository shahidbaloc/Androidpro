package com.example.dell.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    // views field
    private TextView txtResult; // Reference to EditText of result

    // class fields
    private int result = 0;     // Result of computation
    private String inStr = "0"; // Current input string
    // Previous operator: '+', '-', '*', '/', '=' or ' ' (no operator)
    private char lastOperator = ' ';



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Retrieve a reference to the EditText field for displaying the result.
        txtResult = findViewById(R.id.txtResultId);
        txtResult.setText("0");

        // Register listener (this class) for all the buttons
        BtnListener listener = new BtnListener();
        findViewById(R.id.btnNum0Id).setOnClickListener(listener);
        findViewById(R.id.btnNum1Id).setOnClickListener(listener);
        findViewById(R.id.btnNum2Id).setOnClickListener(listener);
        findViewById(R.id.btnNum3Id).setOnClickListener(listener);
        findViewById(R.id.btnNum4Id).setOnClickListener(listener);
        findViewById(R.id.btnNum5Id).setOnClickListener(listener);
        findViewById(R.id.btnNum6Id).setOnClickListener(listener);
        findViewById(R.id.btnNum7Id).setOnClickListener(listener);
        findViewById(R.id.btnNum8Id).setOnClickListener(listener);
        findViewById(R.id.btnNum9Id).setOnClickListener(listener);
        findViewById(R.id.btnAddId).setOnClickListener(listener);
        findViewById(R.id.btnSubId).setOnClickListener(listener);
        findViewById(R.id.btnMulId).setOnClickListener(listener);
        findViewById(R.id.btnDivId).setOnClickListener(listener);
        findViewById(R.id.btnClearId).setOnClickListener(listener);
        findViewById(R.id.btnEqualId).setOnClickListener(listener);
    }

    private class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                // Number buttons: '0' to '9'
                case R.id.btnNum0Id:
                case R.id.btnNum1Id:
                case R.id.btnNum2Id:
                case R.id.btnNum3Id:
                case R.id.btnNum4Id:
                case R.id.btnNum5Id:
                case R.id.btnNum6Id:
                case R.id.btnNum7Id:
                case R.id.btnNum8Id:
                case R.id.btnNum9Id:
                    String inDigit = ((Button) view).getText().toString();
                    if (inStr.equals("0")) {
                        inStr = inDigit; // no leading zero
                    } else {
                        inStr += inDigit; // accumulate input digit
                    }
                    txtResult.setText(inStr);
                    // Clear buffer if last operator is '='
                    if (lastOperator == '=') {
                        result = 0;
                        lastOperator = ' ';
                    }
                    break;

                // Operator buttons: '+', '-', '*', '/' and '='
                case R.id.btnAddId:
                    compute();
                    lastOperator = '+';
                    break;
                case R.id.btnSubId:
                    compute();
                    lastOperator = '-';
                    break;
                case R.id.btnMulId:
                    compute();
                    lastOperator = '*';
                    break;
                case R.id.btnDivId:
                    compute();
                    lastOperator = '/';
                    break;
                case R.id.btnEqualId:
                    compute();
                    lastOperator = '=';
                    break;

                // Clear button
                case R.id.btnClearId:
                    result = 0;
                    inStr = "0";
                    lastOperator = ' ';
                    txtResult.setText("0");
                    break;
            } //end of switch
        } // end of on click
    }//end of class BtnListener

    // User pushes '+', '-', '*', '/' or '=' button.
    // Perform computation on the previous result and the current input number,
    // based on the previous operator.
    private void compute() {
        int inNum = Integer.parseInt(inStr);
        inStr = "0";
        if (lastOperator == ' ') {
            result = inNum;
        } else if (lastOperator == '+') {
            result += inNum;
        } else if (lastOperator == '-') {
            result -= inNum;
        } else if (lastOperator == '*') {
            result *= inNum;
        } else if (lastOperator == '/') {
            result /= inNum;
        } else if (lastOperator == '=') {
            // Keep the result for the next operation
        }
        txtResult.setText(String.valueOf(result));
    } // end of compute
}

