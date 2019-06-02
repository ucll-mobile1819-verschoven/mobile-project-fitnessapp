package com.example.fitnessapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Workout extends AppCompatActivity {

    ArrayList<String> intList = new ArrayList<>();
    TextView workoutTitle;
    ImageView imgbench, imgcurls,imgdeadlift,imgpullup,imgpushup,imgsitup,imgsquat,btnWorkout;
    int stage1, stage2 ,stage3,stage4,stage5,stage6,stage7;
    String difficulty;
    boolean boolBench = false, boolCurls = false, boolDeadlift = false, boolPull = false, boolPush = false, boolSit = false, boolSquat = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        intList.add(0,"Empty");
        intList.add(1,"Empty");
        intList.add(2,"Empty");
        intList.add(3,"Empty");
        intList.add(4,"Empty");
        intList.add(5,"Empty");
        intList.add(6,"Empty");

        SharedPreferences preferences = getSharedPreferences("PRESS", 0);
        stage1 = preferences.getInt("switch_stage", 1);
        stage2 = preferences.getInt("switch_stage", 1);
        stage3 = preferences.getInt("switch_stage", 1);
        stage4 = preferences.getInt("switch_stage", 1);
        stage5 = preferences.getInt("switch_stage", 1);
        stage6 = preferences.getInt("switch_stage", 1);
        stage7 = preferences.getInt("switch_stage", 1);

        workoutTitle = (TextView) findViewById(R.id.workoutTitle);
        imgbench = (ImageView) findViewById(R.id.imgbench);
        imgcurls = (ImageView) findViewById(R.id.imgcurls);
        imgdeadlift = (ImageView) findViewById(R.id.imgdeadlift);
        imgpullup = (ImageView) findViewById(R.id.imgpullup);
        imgpushup = (ImageView) findViewById(R.id.imgpushup);
        imgsitup = (ImageView) findViewById(R.id.imgsitup);
        imgsquat = (ImageView) findViewById(R.id.imgsquat);
        btnWorkout = (ImageView) findViewById(R.id.btnWorkout);

        difficulty = getIntent().getStringExtra("difficulty");

        workoutTitle.setText("SELECT EXERCISES");

        imgbench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchBenchNumbers();
            }
        });
        imgcurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCurlsNumbers();
            }
        });
        imgdeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             switchDeadliftNumbers();
            }
        });
        imgpullup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              switchPullupNumbers();
            }
        });
        imgpushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switchPushupNumbers();
            }
        });
        imgsitup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switchSitupNumbers();
            }
        });
        imgsquat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switchSquatNumbers();
            }
        });

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boolBench || boolCurls || boolDeadlift || boolPull || boolPush || boolSit ||boolSquat){
                    Intent intent = new Intent(Workout.this, TimedWorkout.class);
                    intent.putExtra("intList", intList);
                    intent.putExtra("difficulty", difficulty);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Workout.this, "PLEASE SELECT AT LEAST 1 WORKOUT", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void switchBenchNumbers() {
        switch (stage1) {
            case 1:
                stage1 = 2;
                setBenchImage(stage1);
                doBench(stage1);
                boolBench = true;
                break;
            case 2:
                stage1 = 1;
                setBenchImage(stage1);
                doBench(stage1);
                boolBench = false;
                break;
        }
    }
    private void switchCurlsNumbers() {
        switch (stage2) {
            case 1:
                stage2 = 2;
                setCurlsImage(stage2);
                doCurls(stage2);
                boolCurls = true;
                break;
            case 2:
                stage2 = 1;
                setCurlsImage(stage2);
                doCurls(stage2);
                boolCurls = false;
                break;
        }
    }
    private void switchDeadliftNumbers() {
        switch (stage3) {
            case 1:
                stage3 = 2;
                setDeadliftImage(stage3);
                doDeadlift(stage3);
                boolDeadlift = true;
                break;
            case 2:
                stage3 = 1;
                setDeadliftImage(stage3);
                doDeadlift(stage3);
                boolDeadlift = false;
                break;
        }
    }
    private void switchPullupNumbers() {
        switch (stage4) {
            case 1:
                stage4 = 2;
                setPullupImage(stage4);
                doPullup(stage4);
                boolPull = true;
                break;
            case 2:
                stage4 = 1;
                setPullupImage(stage4);
                doPullup(stage4);
                boolPull = false;
                break;
        }
    }
    private void switchPushupNumbers() {
        switch (stage5) {
            case 1:
                stage5 = 2;
                setPushupImage(stage5);
                doPushup(stage5);
                boolPush = true;
                break;
            case 2:
                stage5 = 1;
                setPushupImage(stage5);
                doPushup(stage5);
                boolPush = false;
                break;
        }
    }
    private void switchSitupNumbers() {
        switch (stage6) {
            case 1:
                stage6 = 2;
                setSitupImage(stage6);
                doSitup(stage6);
                boolSit = true;
                break;
            case 2:
                stage6 = 1;
                setSitupImage(stage6);
                doSitup(stage6);
                boolSit = false;
                break;
        }
    }
    private void switchSquatNumbers() {
        switch (stage7) {
            case 1:
                stage7 = 2;
                setSquatImage(stage7);
                doSquat(stage7);
                boolSquat = true;
                break;
            case 2:
                stage7 = 1;
                setSquatImage(stage7);
                doSquat(stage7);
                boolSquat = false;
                break;
        }
    }

    private void setBenchImage(int current) {
        switch (current) {
            case 1:
                imgbench.setImageResource(R.drawable.bench);
                break;
            case 2:
                imgbench.setImageResource(R.drawable.icons8_bench_press_75px);
                break;
        }
    }
    private void setCurlsImage(int current) {
        switch (current) {
            case 1:
                imgcurls.setImageResource(R.drawable.curls);
                break;
            case 2:
                imgcurls.setImageResource(R.drawable.icons8_curls_with_dumbbells_75px);
                break;
        }
    }
    private void setDeadliftImage(int current) {
        switch (current) {
            case 1:
                imgdeadlift.setImageResource(R.drawable.deadlift);
                break;
            case 2:
                imgdeadlift.setImageResource(R.drawable.icons8_deadlift_75px);
                break;
        }
    }
    private void setPullupImage(int current) {
        switch (current) {
            case 1:
                imgpullup.setImageResource(R.drawable.pullup);
                break;
            case 2:
                imgpullup.setImageResource(R.drawable.icons8_pullups_75px);
                break;
        }
    }
    private void setPushupImage(int current) {
        switch (current) {
            case 1:
                imgpushup.setImageResource(R.drawable.pushup);
                break;
            case 2:
                imgpushup.setImageResource(R.drawable.icons8_pushups_75px);
                break;
        }
    }
    private void setSitupImage(int current) {
        switch (current) {
            case 1:
                imgsitup.setImageResource(R.drawable.situp);
                break;
            case 2:
                imgsitup.setImageResource(R.drawable.icons8_sit_ups_75px);
                break;
        }
    }
    private void setSquatImage(int current) {
        switch (current) {
            case 1:
                imgsquat.setImageResource(R.drawable.squat);
                break;
            case 2:
                imgsquat.setImageResource(R.drawable.icons8_squats_75px);
                break;
        }
    }

    private void doBench(int current) {
        switch (current) {
            case 1:
                intList.remove(0);
                intList.add(0, "Empty");
                break;
            case 2:
                intList.remove(0);
                intList.add(0, "Bench presses");
                break;
        }
    }
    private void doCurls(int current) {
        switch (current) {
            case 1:
                intList.remove(1);
                intList.add(1, "Empty");
                break;
            case 2:
                intList.remove(1);
                intList.add(1, "Dumbell curls");
                break;
        }
    }
    private void doDeadlift(int current) {
        switch (current) {
            case 1:
                intList.remove(2);
                intList.add(2, "Empty");
                break;
            case 2:
                intList.remove(2);
                intList.add(2, "Deadlifts");
                break;
        }
    }
    private void doPullup(int current) {
        switch (current) {
            case 1:
                intList.remove(3);
                intList.add(3, "Empty");
                break;
            case 2:
                intList.remove(3);
                intList.add(3, "Pull-Ups");
                break;
        }
    }
    private void doPushup(int current) {
        switch (current) {
            case 1:
                intList.remove(4);
                intList.add(4, "Empty");
                break;
            case 2:
                intList.remove(4);
                intList.add(4, "Push-Ups");
                break;
        }
    }
    private void doSitup(int current) {
        switch (current) {
            case 1:
                intList.set(5, "Empty");
                break;
            case 2:
                intList.set(5, "Sit-Ups");
                break;
        }
    }
    private void doSquat(int current) {
        switch (current) {
            case 1:
                intList.remove(6);
                intList.add(6, "Empty");
                break;
            case 2:
                intList.remove(6);
                intList.add(6, "Squats");
                break;
        }
    }


}