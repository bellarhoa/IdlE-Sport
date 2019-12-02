package com.bellarhoa.idle_sport;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecycleViewAdapter_bawah extends RecyclerView.Adapter<RecycleViewAdapter_bawah.ViewHolder> {
    LayoutInflater mInflater;
    ArrayList<DataUpgrade> itemPotatoes;
    Context context;

    public RecycleViewAdapter_bawah(Context context, ArrayList<DataUpgrade> itemPotatoes) {
        this.mInflater = (LayoutInflater) LayoutInflater.from(context);
        this.itemPotatoes = itemPotatoes;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button namaButton;
        TextView txt;

        public ViewHolder(View v) {
            super(v);
            namaButton = (Button) v.findViewById(R.id.btn);
            txt = (TextView) v.findViewById(R.id.tv_text);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DataUpgrade current = itemPotatoes.get(position);
        holder.txt.setText(current.nama);


        holder.namaButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Button btnn = (Button) v.findViewById(R.id.btn);
                SharedPreferences dataSP = context.getSharedPreferences("dataSP", 0);
                int currTap;
                SharedPreferences.Editor editData = dataSP.edit();
                switch (current.getLevel()){
                    case 4:
                        btnn.setBackgroundResource(R.drawable.btn_round5);
                    case 3:
                        btnn.setBackgroundResource(R.drawable.btn_round4);
                    case 2:
                        btnn.setBackgroundResource(R.drawable.btn_round3);
                    case 1:
                        btnn.setBackgroundResource(R.drawable.btn_round2);
                    case 0:
                        btnn.setBackgroundResource(R.drawable.btn_round1);
                }
                current.setLevel(current.getLevel()+1);
                current.setHarga(current.getHarga()+200);
                current.setNama(current.getNama()+" level: "+String.valueOf(current.getLevel()+1));
                ImageView image = ResourceArray.imageView[current.type];
                image.setImageResource(ResourceArray.data[current.type][current.getLevel()-1]);
                currTap = dataSP.getInt("keyTap", 5);
                editData.putInt("keyTap", currTap+current.level);
                editData.apply();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemPotatoes.size();
    }
}