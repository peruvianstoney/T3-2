package com.example.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.entities.Anime;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.NameViewHolder>{

    private List<Anime> data;

    public AnimeAdapter(List<Anime> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AnimeAdapter.NameViewHolder holder, int position) {
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        TextView tvDescrip = holder.itemView.findViewById(R.id.tvDescrip);
        //imagenes
        ImageView ivAnime = holder.itemView.findViewById(R.id.ivAnime);
        ImageView ivRate = holder.itemView.findViewById(R.id.ivImgRate);

        Anime ani = data.get(position);
        tvName.setText((ani.getName()));
        tvDescrip.setText((ani.getDescription()));
        //imagenes
        Picasso.get().load(ani.getUrlImage()).into(ivAnime);
        Picasso.get().load(ani.getImageRate()).into(ivRate);





    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
