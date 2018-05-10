package com.example.android.portotourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

// Creating a nea class in order to provide the splash screen animation
public class IntroPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Find the ImageView in the list_item.xml layout with the ID placeholder
        ImageView iv = findViewById(R.id.image_intro);

        Animation myAnimation3 = AnimationUtils.loadAnimation(this, R.anim.my_transition_3);
        iv.startAnimation(myAnimation3);

        final Intent intent = new Intent(this, MainActivity.class);

        // Creating the Thread object to prioritize the execution of specific action
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000); // Temporarily cease execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        // Causes this thread to begin execution
        timer.start();
    }
}
