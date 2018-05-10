package com.example.android.portotourguide;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * {@link PlaceAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Places} objects.
 */
public class PlaceAdapter extends ArrayAdapter<Places> {

    /**
     * Create a new {@link PlaceAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param places  is the list of {@link Places}s to be displayed.
     */
    PlaceAdapter(@NonNull Activity context, ArrayList<Places> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // check if the current view is reused else inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_object, parent,
                    false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Places place_item = getItem(position);

        // Find the ImageView in the list_object.xml layout with the ID version_name
        ImageView imageView = ButterKnife.findById(listItemView, R.id.clerigos);

        // Find the ImageView in the list_item.xml layout with the ID placeholder
        ImageView imageView1 = ButterKnife.findById(listItemView, R.id.heart_svg);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        TextView placeName = ButterKnife.findById(listItemView, R.id.text_name_object);
        assert place_item != null;
        placeName.setText(place_item.getPlaceName());

        // Get the image resource ID from the current place_item object and
        // set the image to imageView
        if (place_item.hasImage()) {
            imageView.setImageResource(place_item.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else
            imageView.setVisibility(View.GONE);

        if (place_item.hasImage_for_item()) {
            imageView1.setImageResource(place_item.getImageIcon());
            imageView1.setVisibility(View.VISIBLE);
        } else
            imageView1.setVisibility(View.GONE);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}