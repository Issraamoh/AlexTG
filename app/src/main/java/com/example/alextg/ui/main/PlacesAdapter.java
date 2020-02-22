package com.example.alextg.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.alextg.R;

import java.util.ArrayList;
import java.util.List;

public class PlacesAdapter extends ArrayAdapter<LocationModel> {

    public PlacesAdapter(@NonNull Context context, @NonNull ArrayList<LocationModel> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }
        LocationModel currentLocation = getItem(position);
        TextView locationName = (TextView) listItemView.findViewById(R.id.textName);
        TextView locationAddress = (TextView) listItemView.findViewById(R.id.textAddress);
        TextView locationDescription = (TextView) listItemView.findViewById(R.id.textDescription);
        ImageView imageView=listItemView.findViewById(R.id.locationImage);

                locationName.setText(currentLocation.name);
        locationAddress.setText(currentLocation.address);

        locationDescription.setText(currentLocation.description);

        imageView.setImageResource(currentLocation.image);

        return listItemView;

    }
}
