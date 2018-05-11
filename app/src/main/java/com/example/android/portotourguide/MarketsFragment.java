package com.example.android.portotourguide;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.portotourguide.markets.CastelBel;
import com.example.android.portotourguide.markets.ClerigosMarket;
import com.example.android.portotourguide.markets.FashionClinic;
import com.example.android.portotourguide.markets.FeetingRoom;
import com.example.android.portotourguide.markets.GarrafeiraTio;
import com.example.android.portotourguide.markets.PortoBelo;
import com.example.android.portotourguide.markets.WineLuxury;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketsFragment extends android.support.v4.app.Fragment {

    //Creating a var of type Intent that it to launch an activity
    Intent mIntent;

    // Method to be called when a fragment is first attached to its context.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_of_places, container, false);

        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(R.string.porto_belo, R.drawable.porto_market, R.drawable.ic_heart));
        places.add(new Places(R.string.clerigos_market, R.drawable.clerigos_market, R.drawable.ic_heart));
        places.add(new Places(R.string.feeting, R.drawable.feeting, R.drawable.ic_heart));
        places.add(new Places(R.string.fashion, R.drawable.fashion, R.drawable.ic_heart));
        places.add(new Places(R.string.wine, R.drawable.wine, R.drawable.ic_heart));
        places.add(new Places(R.string.garrafeira, R.drawable.tio, R.drawable.ic_heart));
        places.add(new Places(R.string.castelbel, R.drawable.castelbel, R.drawable.ic_heart));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Places}s.
        // The adapter knows how to create list items for each item in the list.
        assert getContext() != null;
        PlaceAdapter itemsAdapter = new PlaceAdapter((Activity) getContext(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called place_list, which is declared in the
        // place_list.xml layout file.
        final ListView listView = rootView.findViewById(R.id.places_list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Places} in the list.
        listView.setAdapter(itemsAdapter);

        // Set a click listener to launch an activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Find the position of all the fragment items and bound them with activity class
                switch (position) {
                    case 0:
                        mIntent = new Intent(getActivity(), PortoBelo.class);
                        break;
                    case 1:
                        mIntent = new Intent(getActivity(), ClerigosMarket.class);
                        break;
                    case 2:
                        mIntent = new Intent(getActivity(), FeetingRoom.class);
                        break;
                    case 3:
                        mIntent = new Intent(getActivity(), FashionClinic.class);
                        break;
                    case 4:
                        mIntent = new Intent(getActivity(), WineLuxury.class);
                        break;
                    case 5:
                        mIntent = new Intent(getActivity(), GarrafeiraTio.class);
                        break;
                    case 6:
                        mIntent = new Intent(getActivity(), CastelBel.class);
                        break;
                }
                startActivity(mIntent);
            }
        });
        return rootView;
    }
}