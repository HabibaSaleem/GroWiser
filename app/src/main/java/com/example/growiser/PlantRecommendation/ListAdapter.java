package com.example.growiser.PlantRecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.growiser.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<List> {
    private  Context mContext;
    private int mResource;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<List> objects){
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

    }
    @NonNull
    @Override
    public  View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent , false);
        ImageView imageView = convertView.findViewById(R.id.rowImg);
        TextView txt = convertView.findViewById(R.id.rowTxt);
        TextView txtDes = convertView.findViewById(R.id.rowDes);
        imageView.setImageResource(getItem(position).getImage());
        txt.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());
        return convertView;


    }

}
