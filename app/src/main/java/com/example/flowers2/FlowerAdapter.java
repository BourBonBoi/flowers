package com.example.flowers2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {

    private final static String PHOTO_URL = "http://services.hanselandpetal.com/photos/";
    TextView descriptionTextView;

    private List<Flower> mFlowers;
    private Context mContext;

    FlowerAdapter(List<Flower> flowers) {
        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flower flower = mFlowers.get(position);
        holder.nameTextView.setText(flower.getName());
        holder.descriptionTextView.setText(flower.getInstructions()); // Установка описания

        Picasso.get()
                .load(PHOTO_URL + flower.getPhoto())
                .resize(400, 300)
                .into(holder.flowerImageView);
    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView; // Initialize the descriptionTextView

        ImageView flowerImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView); // Initialize the descriptionTextView
            flowerImageView = itemView.findViewById(R.id.itemImageView);
        }
    }

}