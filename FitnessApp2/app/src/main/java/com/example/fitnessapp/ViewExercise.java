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

    TextView timer, title, descContent, howToContent;
    ImageView detail_image;

    Button btnStart;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        timer = (TextView)findViewById(R.id.timer);
        title = (TextView)findViewById(R.id.title);
        detail_image = (ImageView)findViewById(R.id.detail_image);
        descContent = (TextView)findViewById(R.id.descContent);
        howToContent = (TextView)findViewById(R.id.howToContent);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning){
                    btnStart.setText("DONE");
                    new CountDownTimer(20000,1000){

                        @Override
                        public void onTick(long millisUntilFinished) {
                            timer.setText(""+millisUntilFinished/1000);
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(ViewExercise.this, "Finish!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }.start();
                }
                else
                {
                    Toast.makeText(ViewExercise.this, "Finish!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                isRunning = !isRunning;
            }
        });

        timer.setText("");

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
