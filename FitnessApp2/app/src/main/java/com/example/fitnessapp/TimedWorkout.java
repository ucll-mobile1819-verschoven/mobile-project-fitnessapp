package com.example.fitnessapp;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class TimedWorkout extends AppCompatActivity {

    ArrayList<String> intList;
    TextView woTitle,txtCalc, txtTime, txtWoCurls, txtWoBench, txtWoDeadlifts, txtWoPullup, txtWoPushup, txtWoSitup, txtWoSquat;
    ImageView imgWoCurls, imgWoBench, imgWoDeadlifts, imgWoPullup, imgWoPushup, imgWoSitup, imgWoSquat;
    String difficulty;
    LinearLayout loBench, loCurls, loDeadlifts, loPullup, loPushup, loSitup, loSquat;
    int workableDifficulty, result = 0, calories = 0, totalMinuts = 0, totalSecounts = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timedworkout);

        loBench = (LinearLayout)findViewById(R.id.loBench);
        loCurls = (LinearLayout)findViewById(R.id.loCurls);
        loDeadlifts = (LinearLayout)findViewById(R.id.loDeadlifts);
        loPullup = (LinearLayout)findViewById(R.id.loPullup);
        loPushup = (LinearLayout)findViewById(R.id.loPushup);
        loSitup = (LinearLayout)findViewById(R.id.loSitup);
        loSquat = (LinearLayout)findViewById(R.id.loSquat);


        imgWoDeadlifts = (ImageView)findViewById(R.id.imgWoDeadlifts);
        imgWoBench = (ImageView)findViewById(R.id.imgWoBench);
        imgWoCurls = (ImageView)findViewById(R.id.imgWoCurls);
        imgWoPullup = (ImageView)findViewById(R.id.imgWoPullup);
        imgWoPushup = (ImageView)findViewById(R.id.imgWoPushup);
        imgWoSitup = (ImageView)findViewById(R.id.imgWoSitup);
        imgWoSquat = (ImageView)findViewById(R.id.imgWoSquat);

        txtCalc = (TextView)findViewById(R.id.txtCalc);
        txtTime = (TextView)findViewById(R.id.txtTime);
        txtWoDeadlifts = (TextView)findViewById(R.id.txtWoDeadlifts);
        txtWoBench = (TextView)findViewById(R.id.txtWoBench);
        txtWoCurls = (TextView)findViewById(R.id.txtWoCurls);
        txtWoPullup = (TextView)findViewById(R.id.txtWoPullup);
        txtWoPushup = (TextView)findViewById(R.id.txtWoPushup);
        txtWoSitup = (TextView)findViewById(R.id.txtWoSitup);
        txtWoSquat = (TextView)findViewById(R.id.txtWoSquat);
        woTitle = (TextView)findViewById(R.id.woTitle);

        difficulty = getIntent().getStringExtra("difficulty");
        ArrayList<String> intList = (ArrayList<String>)getIntent().getSerializableExtra("intList");

        if(difficulty.equals("EASY")){
            workableDifficulty = 2;
        }else if(difficulty.equals("MEDIUM")){
            workableDifficulty = 3;
        }else {
            workableDifficulty = 5;
        }

        woTitle.setText(difficulty+" WORKOUT");

        if(intList.get(0).equals("Bench presses")){
                txtWoBench.setText("Do "+workableDifficulty+" sets of \n10 Bench presses");
                imgWoBench.setImageResource(R.drawable.icons8_bench_press_75px);
                result += 80 * workableDifficulty;
                calories += 10 * workableDifficulty;
        } else{
            for (int i = 0; i< loBench.getChildCount(); i++){
                View view = loBench.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(1).equals("Dumbell curls")){
            txtWoCurls.setText("Do "+workableDifficulty+" sets of \n15 Dumbell curls");
            imgWoCurls.setImageResource(R.drawable.icons8_curls_with_dumbbells_75px);
            result += 60 * workableDifficulty;
            calories += 3 * workableDifficulty;
        } else{
            for (int i = 0; i< loCurls.getChildCount(); i++){
                View view = loCurls.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(2).equals("Deadlifts")){
            txtWoDeadlifts.setText("Do "+workableDifficulty+" sets of \n5 Deadlifts");
            imgWoDeadlifts.setImageResource(R.drawable.icons8_deadlift_75px);
            result += 110 * workableDifficulty;
            calories += 15 * workableDifficulty;
        } else{
            for (int i = 0; i< loDeadlifts.getChildCount(); i++){
                View view = loDeadlifts.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(3).equals("Pull-Ups")){
            txtWoPullup.setText("Do "+workableDifficulty+" sets of \n5 Pull-Ups");
            imgWoPullup.setImageResource(R.drawable.icons8_pullups_75px);
            result += 40 * workableDifficulty;
            calories += 3 * workableDifficulty;
        } else{
            for (int i = 0; i< loPullup.getChildCount(); i++){
                View view = loPullup.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(4).equals("Push-Ups")){
            txtWoPushup.setText("Do "+workableDifficulty+" sets of \n10 Push-Ups");
            imgWoPushup.setImageResource(R.drawable.icons8_pushups_75px);
            result += 50 * workableDifficulty;
            calories += 3 * workableDifficulty;
        } else{
            for (int i = 0; i< loPushup.getChildCount(); i++){
                View view = loPushup.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(5).equals("Sit-Ups")){
            txtWoSitup.setText("Do "+workableDifficulty+" sets of \n10 Sit-Ups");
            imgWoSitup.setImageResource(R.drawable.icons8_sit_ups_75px);
            result += 45 * workableDifficulty;
            calories += 2 * workableDifficulty;
        } else{
            for (int i = 0; i< loSitup.getChildCount(); i++){
                View view = loSitup.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        if(intList.get(6).equals("Squats")){
            txtWoSquat.setText("Do "+workableDifficulty+" sets of \n20 Squats");
            imgWoSquat.setImageResource(R.drawable.icons8_squats_75px);
            result += 65 * workableDifficulty;
            calories += 10 * workableDifficulty;
        } else{
            for (int i = 0; i< loSquat.getChildCount(); i++){
                View view = loSquat.getChildAt(i);
                view.setVisibility(View.GONE);
            }
        }
        totalMinuts = result / 60;
        totalSecounts = result % 60;

        txtCalc.setText("ESTIMATED TOTAL CALORIES BURNED: " + Integer.toString(calories));
        txtTime.setText("ESTIMATED WORKOUT TIME: " +Integer.toString(totalMinuts) + "MIN " + Integer.toString(totalSecounts) + "SEC");

    }
}


