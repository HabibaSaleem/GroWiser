package com.example.growiser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.growiser.PlantRecommendation.RecommendedPlants;
import com.example.growiser.ui.PlantGallery.PlantGalleryFragment;
import com.example.growiser.ui.PredictPlant.PredictPlantFragment;

public class ManuallyPredict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maually_predict);
        Button btn_manually_predict_1= findViewById(R.id.btn_Manually_Predict_1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.dark)));

        btn_manually_predict_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RecommendedPlants.class);
                startActivity(i);
            }
        });

//        for no action bar/appbar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), PredictPlantFragment.class);
        //noinspection deprecation
        startActivityForResult(myIntent, 0);
        return true;
    }

}

