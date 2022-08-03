package com.example.growiser.ui.PlantGallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.growiser.R;

import java.util.ArrayList;
import java.util.List;


public class PlantGalleryFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_plant_gallery,container,false);
        recyclerView = v.findViewById(R.id.galleryRV);
        recyclerView.setHasFixedSize(true);

        List<GalleryPhotos> glist = new ArrayList<>();
        glist.add(new GalleryPhotos(R.drawable.pic1));
        glist.add(new GalleryPhotos(R.drawable.pic2));
        glist.add(new GalleryPhotos(R.drawable.pic3));
        glist.add(new GalleryPhotos(R.drawable.pic4));
        glist.add(new GalleryPhotos(R.drawable.pic5));
        glist.add(new GalleryPhotos(R.drawable.pic6));
        glist.add(new GalleryPhotos(R.drawable.pic7));
        glist.add(new GalleryPhotos(R.drawable.pic8));
        glist.add(new GalleryPhotos(R.drawable.pic9));
        glist.add(new GalleryPhotos(R.drawable.pic10));
        glist.add(new GalleryPhotos(R.drawable.pic11));
        glist.add(new GalleryPhotos(R.drawable.pic12));
        glist.add(new GalleryPhotos(R.drawable.pic13));
        glist.add(new GalleryPhotos(R.drawable.pic14));

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        PhotosAdapter adapter = new PhotosAdapter(glist);
        recyclerView.setAdapter(adapter);


        return v;
    }
    private void setContentView(int fragment_plant_gallery) {
    }


}
