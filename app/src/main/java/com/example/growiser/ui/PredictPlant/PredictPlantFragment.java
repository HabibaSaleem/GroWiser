package com.example.growiser.ui.PredictPlant;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.util.Objects;

import com.example.growiser.MainActivity2;
import com.example.growiser.ManuallyPredict;
import com.example.growiser.PlantRecommendation.RecommendedPlants;
import com.example.growiser.R;

public class PredictPlantFragment extends Fragment {

    Button button1_choosePre, button2_choosePre;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v =inflater.inflate(R.layout.fragment_plant_gallery,container,false);
//        button1_choosePre=v.findViewById(R.id.button1_choosePre);
//        button2_choosePre=v.findViewById(R.id.button2_choosePre);
//
////        button1_choosePre.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent(getApplicationContext(), ManuallyPredict.class);
////                startActivity(i);
////
////            }
////        });
//
//        // Inflate the layout for this fragment
//
//    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.fragment_predict_plant, container, false);
//
//        Button button1_choosePre = (Button) v.findViewById(R.id.button1_choosePre);
//        button1_choosePre.setOnClickListener(this);
//        return v;
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button1_choosePre:
//                onClick(v);
//                break;
//
//        }
//    }
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_predict_plant, container, false);
        Button button1_choosePre = (Button) v.findViewById(R.id.button1_choosePre);
        Button button2_choosePre = (Button) v.findViewById(R.id.button2_choosePre);
        button1_choosePre.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(getActivity(), ManuallyPredict.class);
            ((MainActivity2) getActivity()).startActivity(intent);

        }
    });
    button2_choosePre.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent = new Intent(getActivity(), RecommendedPlants.class);
            ((MainActivity2) getActivity()).startActivity(intent);

        }
    });


    return v;
}


}