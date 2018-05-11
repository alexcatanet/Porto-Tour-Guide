package com.example.android.portotourguide.food_and_drink;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.portotourguide.R;

//Creating a class to display description and the details of the fragment item
public class Catraio extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the catraio.xml layout file
        setContentView(R.layout.catraio);
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView textView = findViewById(R.id.tower_clericos_des);

        // Create the Typeface object to specify the style of the font which will be loaded from the assets folder
        Typeface font = Typeface.createFromAsset(getBaseContext().getAssets(),
                "fonts/CrimsonText-Regular.ttf");
        textView.setTypeface(font);  // Set the style of the font
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}