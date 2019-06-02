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

    Button btnExercises, btnCC, btnEasy, btnMedium, btnHard, btnAbout;
    ImageButton btnTraining;
    TextView txtAmount;

    String difficulty = "EASY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExercises = (Button)findViewById(R.id.btnExercises);
        btnTraining = (ImageButton)findViewById(R.id.btnTraining);
        btnEasy = (Button)findViewById(R.id.btnEasy);
        btnCC = (Button)findViewById(R.id.btnCC);
        btnMedium = (Button)findViewById(R.id.btnMedium);
        btnHard = (Button)findViewById(R.id.btnHard);
        txtAmount = (TextView)findViewById(R.id.txtAmount);
        btnAbout = (Button)findViewById(R.id.btnAbout);

        txtAmount.setText("WORKOUT LEVEL: "+difficulty);
        btnEasy.setEnabled(false);
        btnEasy.setBackgroundResource(R.drawable.btnbg);
        btnMedium.setBackgroundResource(R.drawable.btnbgstop);
        btnHard.setBackgroundResource(R.drawable.btnbgstop);

        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Workout.class);
                intent.putExtra("difficulty", difficulty);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, About.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

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

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = "EASY";
                txtAmount.setText("WORKOUT LEVEL: " + difficulty);
                btnEasy.setEnabled(false);
                btnMedium.setEnabled(true);
                btnHard.setEnabled(true);
                btnEasy.setBackgroundResource(R.drawable.btnbg);
                btnMedium.setBackgroundResource(R.drawable.btnbgstop);
                btnHard.setBackgroundResource(R.drawable.btnbgstop);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = "MEDIUM";
                txtAmount.setText("WORKOUT LEVEL: "+ difficulty);
                btnMedium.setEnabled(false);
                btnEasy.setEnabled(true);
                btnHard.setEnabled(true);
                btnEasy.setBackgroundResource(R.drawable.btnbgstop);
                btnMedium.setBackgroundResource(R.drawable.btnbg);
                btnHard.setBackgroundResource(R.drawable.btnbgstop);
            }
        });
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = "HARD";
                txtAmount.setText("WORKOUT LEVEL: " + difficulty);
                btnHard.setEnabled(false);
                btnEasy.setEnabled(true);
                btnMedium.setEnabled(true);
                btnEasy.setBackgroundResource(R.drawable.btnbgstop);
                btnMedium.setBackgroundResource(R.drawable.btnbgstop);
                btnHard.setBackgroundResource(R.drawable.btnbg);
            }
        });
    }
}
