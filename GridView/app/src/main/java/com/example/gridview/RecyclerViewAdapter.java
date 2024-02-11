package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
   String[] CountryNames;
   int[] flags;
   Context context;
    private static ClickListener clickListener;
    public RecyclerViewAdapter(String[] countryNames, int[] flags, Context context) {
        CountryNames = countryNames;
        this.flags = flags;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(flags[position]);
        holder.textView.setText(CountryNames[position]);
    }

    @Override
    public int getItemCount() {
        return flags.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.flagsimageViewId);
            textView = itemView.findViewById(R.id.countryNamesId);
            linearLayout = itemView.findViewById(R.id.sampleLayoutId);
            linearLayout.setOnClickListener(this);
            linearLayout.setOnLongClickListener(this);
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
    public void setOnItemClickListener(ClickListener clickListener){
        RecyclerViewAdapter.clickListener = clickListener;
    }
}
