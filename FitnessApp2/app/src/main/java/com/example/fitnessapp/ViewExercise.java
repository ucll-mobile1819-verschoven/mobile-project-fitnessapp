package com.example.fitnessapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ViewExercise extends AppCompatActivity {

    int image_id;
    String name;
    String desc;
    String howTo;

    TextView title, descContent, howToContent;
    ImageView detail_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        title = (TextView)findViewById(R.id.title);
        detail_image = (ImageView)findViewById(R.id.detail_image);
        descContent = (TextView)findViewById(R.id.descContent);
        howToContent = (TextView)findViewById(R.id.howToContent);

        if(getIntent()!= null){
            image_id = getIntent().getIntExtra("image_id", -1);
            name = getIntent().getStringExtra("name");
            desc = getIntent().getStringExtra("desc");
            howTo = getIntent().getStringExtra("howTo");

            howToContent.setText(howTo);
            descContent.setText(desc);
            detail_image.setImageResource(image_id);
            title.setText(name);
        }
    }
}
