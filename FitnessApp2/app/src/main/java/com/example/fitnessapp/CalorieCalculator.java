package com.example.fitnessapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.Adapter.RecyclerViewAdapter;
import com.example.fitnessapp.Model.Exercise;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalorieCalculator extends AppCompatActivity {

Button btnCC;
EditText bench, dumbell, deadlift, pullup, pushup, situp, squat;
TextView totalc;

double calories = 0;
int benchC = 0, dumbellC = 0, deadC = 0, pullC = 0, pushC = 0, sitC = 0, squatC = 0;
private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecalculator);

        btnCC = (Button)findViewById(R.id.btnCC);
        bench = (EditText)findViewById(R.id.bench);
        dumbell = (EditText)findViewById(R.id.dumbell);
        deadlift = (EditText)findViewById(R.id.deadlift);
        pullup = (EditText)findViewById(R.id.pullup);
        pushup = (EditText)findViewById(R.id.pushup);
        situp = (EditText)findViewById(R.id.situp);
        squat = (EditText)findViewById(R.id.squat);
        totalc = (TextView)findViewById(R.id.totalc);

        bench.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        dumbell.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        deadlift.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        pullup.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        pushup.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        situp.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});
        squat.setFilters(new InputFilter[]{ new MinMaxFilter(1, 99)});

        bench.setMovementMethod(null);

        btnCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bench.getText().toString().isEmpty()){
                    benchC = 0;
                } else if(bench.getText().length() > 2 || Integer.parseInt(bench.getText().toString())>99){
                    Toast.makeText(CalorieCalculator.this,"PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99",Toast.LENGTH_LONG).show();
                    bench.setText("");
                }else{
                    benchC = Integer.parseInt(bench.getText().toString());
                }
                if(dumbell.getText().toString().isEmpty()) {
                    dumbellC = 0;
                }else if(dumbell.getText().length() > 2 || Integer.parseInt(dumbell.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    dumbell.setText("");
                }
                else{
                    dumbellC = Integer.parseInt(dumbell.getText().toString());
                }
                if(deadlift.getText().toString().isEmpty()){
                    deadC = 0;
                }else if(deadlift.getText().length() > 2 || Integer.parseInt(deadlift.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    deadlift.setText("");
                }
                else{
                    deadC = Integer.parseInt(deadlift.getText().toString());
                }
                if(pullup.getText().toString().isEmpty()){
                    pullC = 0;
                }else if(pullup.getText().length() > 2 || Integer.parseInt(pullup.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    pullup.setText("");
                }
                else{
                    pullC = Integer.parseInt(pullup.getText().toString());
                }
                if(pushup.getText().toString().isEmpty()){
                    pushC = 0;
                }else if(pushup.getText().length() > 2 || Integer.parseInt(pushup.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    pushup.setText("");
                }
                else{
                    pushC = Integer.parseInt(pushup.getText().toString());
                }
                if (situp.getText().toString().isEmpty()){
                    sitC = 0;
                }else if(situp.getText().length() > 2 || Integer.parseInt(situp.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    situp.setText("");
                }
                else{
                    sitC = Integer.parseInt(situp.getText().toString());
                }
                if (squat.getText().toString().isEmpty()){
                    squatC = 0;
                }else if(squat.getText().length() > 2 || Integer.parseInt(squat.getText().toString())>99) {
                    Toast.makeText(CalorieCalculator.this, "PLEASE MAKE SURE THE VALUE IS UP TO A MAXIMUM OF 99", Toast.LENGTH_LONG).show();
                    squat.setText("");
                }
                else {
                    squatC = Integer.parseInt(squat.getText().toString());
                }

                calories = (benchC*0.3+dumbellC*0.2+deadC*3+pullC*0.5+pushC*0.3+sitC*0.15+squatC*0.5);
                totalc.setText("TOTAL CALORIES: " + df2.format(calories));
            }
        });

    }
}
