package com.example.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>{

    private List<String> data;

    public NameAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder( NameViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.tvName);
        String value = data.get(position);
        tv.setText(value);

//        Button btnClick = holder.itemView.findViewById(R.id.btnClick);
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), value, Toast.LENGTH_SHORT).show();
//            }
//        });



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
