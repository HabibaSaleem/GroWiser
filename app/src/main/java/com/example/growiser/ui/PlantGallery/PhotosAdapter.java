package com.example.growiser.ui.PlantGallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.growiser.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private List<GalleryPhotos> glist = new ArrayList<>();

    public PhotosAdapter(List<GalleryPhotos> glist){
        this.glist = glist;
    }


    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.PhotosViewHolder holder, int position) {
        holder.imageView.setImageResource(glist.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return glist.size();
    }

    public class PhotosViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView imageView;
        public PhotosViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }

}

