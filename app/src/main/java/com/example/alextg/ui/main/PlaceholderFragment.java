package com.example.alextg.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.alextg.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }
private ArrayList<LocationModel> locationsByIndex(int index){
        ArrayList locations=new ArrayList<LocationModel>();
        if(index==1){

            locations.add(new LocationModel("11 Elgaish st","FourSeasons","Mall , Cafes and Restaurants",R.drawable.fourseasons,31.94,32.94));
            locations.add(new LocationModel("20 Elgaish st","Sheraton","5 Stars Hotel",R.drawable.hilton,31.94,32.94));
            locations.add(new LocationModel("35 Elgaish st","Hilton","International 5 Start Hotel",R.drawable.hilton,31.94,32.94));

        }else if(index==2){
            locations.add(new LocationModel("3 Fouad st","Roastery","Business hrz 10 am : 2 am",R.drawable.roastery,31.94,32.94));
            locations.add(new LocationModel("205 Elgaish Road","Sangiovanni","Business hrz 10 am: 1 am",R.drawable.sangiovanni,31.94,32.94));

        }else if (index==3){
            locations.add(new LocationModel("742 Elgaish Road","Space","Business hrz 24/7 ",R.drawable.space,31.94,32.94));
            locations.add(new LocationModel("Al attarin","Santos","Business hrz 24/7",R.drawable.santos,31.94,32.94));


        }else{
            locations.add(new LocationModel("ElGaish Road","Royal Tulip","Beach",R.drawable.royaltulip,31.94,32.94));
            locations.add(new LocationModel(" Elgaish Road","Azur","Beach",R.drawable.azur,31.94,32.94));


        }
        locationModelArryList=locations;
return locations;}
    ArrayList<LocationModel> locationModelArryList = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        final ListView listView = (ListView) root.findViewById(R.id.list);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                locationModelArryList =locationsByIndex(Integer.parseInt(s));
                PlacesAdapter itemsAdapter =
                        new PlacesAdapter(getActivity(), locationModelArryList);


                listView.setAdapter(itemsAdapter);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion
                    , long l) {
                Uri gmmIntentUri = Uri.parse("geo:"+locationModelArryList.get(postion).lattitude+","+locationModelArryList.get(postion).longtitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        return root;
    }
}