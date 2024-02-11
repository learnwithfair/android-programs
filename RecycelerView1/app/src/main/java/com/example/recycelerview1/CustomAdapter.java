package com.example.recycelerview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private static ClickListener clickListener;
    Context context;
    int[] flags;
    String[] CountryNames;

    public CustomAdapter(Context context, int[] flags, String[] countryNames) {
        this.context = context;
        this.flags = flags;
        CountryNames = countryNames;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewId);
            textView = itemView.findViewById(R.id.coutryNametextViewId);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(flags[position]);
        holder.textView.setText(CountryNames[position]);
    }

    @Override
    public int getItemCount() {
        return CountryNames.length;
    }




    public interface ClickListener{
        void onItemClick(int position,View view);
        void onItemLongClick(int position,View view);
    }
    public void setOnClickListener(ClickListener clickListener){
        CustomAdapter.clickListener = clickListener;

    }
}
