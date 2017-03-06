package com.example.mayur.doctor24_7;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateBMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

    }

    public void calculateBMI(View view) {

        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);
        TextView result = (TextView) findViewById(R.id.result);

        float getHeight, getWeight;

        if (height.getText().toString().equals("")) {
            getHeight = 0f;
        } else {
            getHeight = Float.parseFloat(height.getText().toString());
        }
        if (weight.getText().toString().equals("")) {
            getWeight = 0f;
        } else {
            getWeight = Float.parseFloat(weight.getText().toString());
        }

        float bmi = getWeight / (getHeight * getHeight);

        result.setText("Your BMI is " + bmi);
    }


}