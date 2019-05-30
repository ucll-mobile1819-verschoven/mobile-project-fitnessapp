package com.example.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessapp.Adapter.RecyclerViewAdapter;
import com.example.fitnessapp.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class CalorieCalculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecalculator);

    }


}
