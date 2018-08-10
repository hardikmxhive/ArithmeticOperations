package com.example.matrixhive.arithmeticoperations;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etv1, etv2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsum = findViewById(R.id.buttonsum);
        Button btnsub = findViewById(R.id.buttonsub);
        Button btndiv = findViewById(R.id.buttondiv);
        Button btnmul = findViewById(R.id.buttonmul);
        etv1 = findViewById(R.id.editText1);
        etv2 = findViewById(R.id.editText2);
        result = findViewById(R.id.textView1);


        btnsum.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnmul.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonsum:
                summation();
                break;
            case R.id.buttonsub:
                subtraction();
                break;
            case R.id.buttondiv:
                multiplication();
                break;
            case R.id.buttonmul:
                division();
                break;
            default:
                result.setText("0");
                break;
        }
    }

    private void summation() {
        int num1 = Integer.valueOf(etv1.getText().toString());
        int num2 = Integer.valueOf(etv2.getText().toString());
        int sum = num1 + num2;
        result.setText(MessageFormat.format("The ANS of {0} + {1} = {2}", num1, num2, sum));
        hide();
    }

    private void subtraction() {
        int num1 = Integer.valueOf(etv1.getText().toString());
        int num2 = Integer.valueOf(etv2.getText().toString());
        int sub = num1 - num2;
        result.setText(MessageFormat.format("The ANS of {0} - {1} = {2}", num1, num2, sub));
        hide();
    }

    private void multiplication() {
        int num1 = Integer.valueOf(etv1.getText().toString());
        int num2 = Integer.valueOf(etv2.getText().toString());
        int mul = num1 * num2;
        result.setText(MessageFormat.format("The ANS of {0} * {1} = {2}", num1, num2, mul));
        hide();
    }

    private void division() {
        int num1 = Integer.valueOf(etv1.getText().toString());
        int num2 = Integer.valueOf(etv2.getText().toString());
        int div = num1 / num2;
        result.setText(MessageFormat.format("The ANS of {0} / {1} = {2}", num1, num2, div));
        hide();
    }

    private void hide() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}

