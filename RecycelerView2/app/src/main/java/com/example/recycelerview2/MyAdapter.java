package com.example.recycelerview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   private static ClickListener clickListener;
    Context context;
    String[] countryNames;
    int[] flags;

    public MyAdapter(Context context, String[] countryNames, int[] flags) {
        this.context = context;
        this.countryNames = countryNames;
        this.flags = flags;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.imageView.setImageResource(flags[position]);
            holder.textView.setText(countryNames[position]);
    }

    @Override
    public int getItemCount() {
        return countryNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewId);
            textView = itemView.findViewById(R.id.countryNameTextViewId);
            cardView = itemView.findViewById(R.id.cardViewId);
            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.OnClickListener(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.OnLongClickListener(getAdapterPosition(),v);
            return false;
        }
    }
    public interface ClickListener{
        void OnClickListener(int position,View view);
        void OnLongClickListener(int position,View view);
    }
    public void SetOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;
    }

}
