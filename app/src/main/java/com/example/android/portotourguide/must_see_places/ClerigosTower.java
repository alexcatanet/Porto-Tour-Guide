package com.example.android.portotourguide.must_see_places;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.portotourguide.R;

//Creating a class to display description and the details of the fragment item
public class ClerigosTower extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the clerigos_tower.xml layout file
        setContentView(R.layout.clerigos_tower);

        TextView textView = findViewById(R.id.tower_clericos_des);

        // Create the Typeface object to specify the style of the font which will be loaded from the assets folder
        Typeface font = Typeface.createFromAsset(getBaseContext().getAssets(),
                "fonts/CrimsonText-Regular.ttf");
        textView.setTypeface(font);   // Set the style of the font
    }
}
