package com.example.loceatcreatemenumodule1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<BusinessData> businessDataList;

    public MyAdapter(Context context, List<BusinessData> businessDataList) {
        this.context = context;
        this.businessDataList = businessDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.businessrecycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(businessDataList.get(position).getImage()).into(holder.recImage);
        holder.recFoodname.setText(businessDataList.get(position).getFoodname());
        holder.recPrice.setText(businessDataList.get(position).getPrice());
        holder.recType.setText(businessDataList.get(position).getType());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BusinessDetailActivity.class);
                intent.putExtra("Image", businessDataList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Food Name", businessDataList.get(holder.getAdapterPosition()).getFoodname());
                intent.putExtra("Price", businessDataList.get(holder.getAdapterPosition()).getPrice());
                intent.putExtra("Type", businessDataList.get(holder.getAdapterPosition()).getType());
                intent.putExtra("Key",businessDataList.get(holder.getAdapterPosition()).getKey());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return businessDataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recFoodname, recPrice, recType;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recFoodname = itemView.findViewById(R.id.recFoodname);
        recPrice = itemView.findViewById(R.id.recPrice);
        recType = itemView.findViewById(R.id.recType);
    }
}