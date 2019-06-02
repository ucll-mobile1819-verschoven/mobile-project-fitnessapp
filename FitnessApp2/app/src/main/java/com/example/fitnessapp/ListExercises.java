package com.example.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fitnessapp.Adapter.RecyclerViewAdapter;
import com.example.fitnessapp.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {

    List<Exercise> exerciseList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);

        initData();

        recyclerView = (RecyclerView)findViewById(R.id.list_ex);
        adapter = new RecyclerViewAdapter(exerciseList, getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        exerciseList.add(new Exercise(R.drawable.icons8_bench_press_100px, "Bench presses",
                "The bench press is an upper-body strength-training exercise that consists of pressing a weight upwards from a supine position. The exercise works the pectoralis major as well as the supporting chest, arm, and shoulder muscles trapezii, and triceps.",
                "The person performing the exercise lies on their back on a bench with a weight grasped in both hands. They push the weight upwards until their arms are extended. They then lower the weight to chest level."));
        exerciseList.add(new Exercise(R.drawable.icons8_curls_with_dumbbells_100px, "Dumbell curls",
                "The humble bicep curl is your simplest lift, and an essential ingredient in of arm exercise routine.",
                "Weight (attached to, or used in conjunction with, an item of equipment listed above) is lifted up until the forearms are vertical with the elbows and upper arm remaining close to the body."));
        exerciseList.add(new Exercise(R.drawable.icons8_deadlift_100px, "Deadlifts",
                "The deadlift is a weight training exercise in which a loaded barbell or bar is lifted off the ground to the level of the hips, then lowered to the ground. It is one of the three powerlifting exercises, along with the squat and bench press.",
                "Person stands with their mid-foot under the barbell, bends over and grabs the bar with a shoulder-width grip. Knees are bended until shins touches the bar. Person lifts his chest up and straightens their lower back. Finally, it’s time to take a big breath, hold it, and stand up to the weight."));
        exerciseList.add(new Exercise(R.drawable.icons8_pullups_100px, "Pull-ups",
                "Pull-up is an upper-body compound pulling exercise. Although it can be performed with any grip, in recent years some have used the term to refer more specifically to a pull-up performed with a palms-forward position.",
                "Persons body is suspended by the arms, gripping something, and pulling up. As this happens, the wrists remain in neutral (straight, neither flexed nor extended) position, the elbows flex and the shoulder adducts and/or extends to bring the elbows to or sometimes behind the torso. The knees may be bent by choice or if the bar is not high enough."));
        exerciseList.add(new Exercise(R.drawable.icons8_pushups_100px, "Push-ups",
                "A push-up (or press-up) is a common calisthenics exercise beginning from the prone position, or the front leaning rest position known in the military. By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids. Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training.",
                "Person breathes out while pushing the arms straight to lift the body off the floor and back into the plank position."));
        exerciseList.add(new Exercise(R.drawable.icons8_sit_ups_100px, "Sit-ups",
                "The sit-up (or curl-up) is an abdominal endurance training exercise to strengthen and tone the abdominal muscles. It is similar to a crunch, but sit-ups have a fuller range of motion and condition additional muscles.",
                "It begins with lying with the back on the floor, typically with the arms across the chest or hands behind the head and the knees bent in an attempt to reduce stress on the back muscles and spine, and then elevating both the upper and lower vertebrae from the floor until everything superior to the buttocks is not touching the ground."));
        exerciseList.add(new Exercise(R.drawable.icons8_squats_100px, "Squats",
                "In strength training and fitness, the squat is a compound, full-body exercise that trains primarily the muscles of the thighs, hips and buttocks, hamstrings, as well as strengthening the bones, ligaments and insertion of the tendons throughout the lower body. Squats are considered a vital exercise for increasing the strength and size of the legs as well as developing core strength.",
                "The movement begins from a standing position. The movement is initiated by moving the hips back and bending the knees and hips to lower the torso and accompanying weight, then returning to the upright position. "));
    }
}
