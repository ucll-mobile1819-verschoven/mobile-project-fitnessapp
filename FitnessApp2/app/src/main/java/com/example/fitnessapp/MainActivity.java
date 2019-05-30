package com.example.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnExercises, btnCC, btnCalendar,btnAdd, btnReduce;
    ImageButton btnTraning;
    TextView txtAmount;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExercises = (Button)findViewById(R.id.btnExercises);
        btnTraning = (ImageButton)findViewById(R.id.btnTraining);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCC = (Button)findViewById(R.id.btnCC);
        btnReduce = (Button)findViewById(R.id.btnReduce);
        txtAmount = (TextView)findViewById(R.id.txtAmount);

        txtAmount.setText("Workout time: 0 min");
        btnReduce.setEnabled(false);

        btnExercises.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ListExercises.class);
                startActivity(intent);
            }
        });

        btnCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CalorieCalculator.class);
                        startActivity(intent);
            }
        });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtAmount.setText("Workout time:" + count + "min");
                if (count < 1){
                    btnReduce.setEnabled(false);
                    btnAdd.setEnabled(true);
                }else if (count > 59){
                    btnReduce.setEnabled(true);
                    btnAdd.setEnabled(false);
                }else {
                    btnReduce.setEnabled(true);
                    btnAdd.setEnabled(true);
                }
            }
        });

        btnReduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                txtAmount.setText("Workout time:"+count+"min");
                if (count < 1){
                    btnReduce.setEnabled(false);
                    btnAdd.setEnabled(true);
                }else if (count > 59){
                    btnReduce.setEnabled(true);
                    btnAdd.setEnabled(false);
                }else {
                    btnReduce.setEnabled(true);
                    btnAdd.setEnabled(true);
                }
            }
        });
    }
}
