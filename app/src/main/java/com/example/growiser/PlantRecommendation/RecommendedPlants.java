package com.example.growiser.PlantRecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.growiser.MainActivity2;
import com.example.growiser.R;
import com.example.growiser.ui.PredictPlant.PredictPlantFragment;

import java.util.ArrayList;

public class RecommendedPlants extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_plants);
        listView = findViewById(R.id.listView);

//        create list
        ArrayList<List> arrayList = new ArrayList<>();
        arrayList.add(new List(R.drawable.pic1, "ABC Plant is an indoor plant..", "ABC "));
        arrayList.add(new List(R.drawable.pic2, "XYZ Plant is an outdoor plant...", "ABC "));
        arrayList.add(new List(R.drawable.pic3, "ABC Plant can grow outdoors as ...", "ABC "));

//        custom adapter
        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_row, arrayList);
        listView.setAdapter(listAdapter);

//        app bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark)));

    }
//    back button
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity2.class);
        //noinspection deprecation
        startActivityForResult(myIntent, 0);
        return true;
    }
}