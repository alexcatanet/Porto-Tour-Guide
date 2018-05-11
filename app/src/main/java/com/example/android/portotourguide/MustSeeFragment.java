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

import com.example.android.portotourguide.must_see_places.ClerigosTower;
import com.example.android.portotourguide.must_see_places.CrystalPalace;
import com.example.android.portotourguide.must_see_places.Foz;
import com.example.android.portotourguide.must_see_places.LivrariaLello;
import com.example.android.portotourguide.must_see_places.Ribeira;
import com.example.android.portotourguide.must_see_places.SaoBento;
import com.example.android.portotourguide.must_see_places.SerraPillar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MustSeeFragment extends android.support.v4.app.Fragment {

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
        places.add(new Places(R.string.clerigos_tower, R.drawable.clerigos, R.drawable.ic_heart));
        places.add(new Places(R.string.serra_do_pillar, R.drawable.serra, R.drawable.ic_heart));
        places.add(new Places(R.string.livraria_lello, R.drawable.lello, R.drawable.ic_heart));
        places.add(new Places(R.string.crystal_palace_garden, R.drawable.crystal, R.drawable.ic_heart));
        places.add(new Places(R.string.ribeira, R.drawable.ribeira, R.drawable.ic_heart));
        places.add(new Places(R.string.foz, R.drawable.foz, R.drawable.ic_heart));
        places.add(new Places(R.string.sao_bento, R.drawable.bento, R.drawable.ic_heart));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Places}s.
        // The adapter knows how to create list items for each item in the list.
        assert getContext() != null;

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called place_list, which is declared in the
        // place_list.xml layout file.
        PlaceAdapter itemsAdapter = new PlaceAdapter((Activity) getContext(), places);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Places} in the list.
        final ListView listView = rootView.findViewById(R.id.places_list);
        listView.setAdapter(itemsAdapter);

        // Set a click listener to launch an activity when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Find the position of all the fragment items and bound them with activity class
                switch (position) {
                    case 0:
                        mIntent = new Intent(getActivity(), ClerigosTower.class);
                        break;
                    case 1:
                        mIntent = new Intent(getActivity(), SerraPillar.class);
                        break;
                    case 2:
                        mIntent = new Intent(getActivity(), LivrariaLello.class);
                        break;
                    case 3:
                        mIntent = new Intent(getActivity(), CrystalPalace.class);
                        break;
                    case 4:
                        mIntent = new Intent(getActivity(), Ribeira.class);
                        break;
                    case 5:
                        mIntent = new Intent(getActivity(), Foz.class);
                        break;
                    case 6:
                        mIntent = new Intent(getActivity(), SaoBento.class);
                        break;
                }
                startActivity(mIntent);
            }
        });
        return rootView;
    }
}
