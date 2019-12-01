package com.bellarhoa.idle_sport;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecycleViewAdapter_bawah extends RecyclerView.Adapter<RecycleViewAdapter_bawah.ViewHolder> {
    private static int counter = 0;
    LayoutInflater mInflater;
    ArrayList<itemPotato> itemPotatoes;

    public RecycleViewAdapter_bawah(FragmentBawah context, ArrayList<itemPotato> itemPotatoes) {
        this.mInflater = (LayoutInflater) LayoutInflater.from(context.getActivity());
        this.itemPotatoes = itemPotatoes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Button namaButton;
        public ImageView imgMinuman;
        public ViewHolder(View v) {
            super(v);
            namaButton = (Button) v.findViewById(R.id.btn);
            imgMinuman = (ImageView) v.findViewById(R.id.imgMinuman);
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
        final itemPotato current = itemPotatoes.get(position);
        final String nama = itemPotatoes.get(position).getNama();
        holder.namaButton.setText(current.nama);


        holder.namaButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Button btnn = (Button) v.findViewById(R.id.btn);
                ImageView minum = (ImageView) v.findViewById(R.id.imgMinuman);

//                ImageView headset = (ImageView) v.findViewById(R.drawable.headset0);
//                ImageView poster = (ImageView) v.findViewById(R.drawable.poster0);
//                ImageView pc = (ImageView) v.findViewById(R.drawable.pc0);
//                ImageView kursi = (ImageView) v.findViewById(R.drawable.kursi0);
                switch (itemPotatoes.get(position).level) {
                    case 0:
                        btnn.setBackgroundResource(R.drawable.btn_round2);
                        Drawable d = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level 1)");
                        current.setLevel(1);
                        //Minuman, headset, poster, PC, kursi
                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
//                                minuman.setImageResource(R.drawable.minuman0);
//                                Drawable m1 = minuman.getDrawable();
//                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1:
                        btnn.setBackgroundResource(R.drawable.btn_round);
                        Drawable d1 = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level 2)");
                        current.setLevel(2);

                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
                                minum.setImageResource(R.drawable.minuman1);
                                Drawable m1 = minum.getDrawable();
                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        btnn.setBackgroundResource(R.drawable.btn_round2);
                        Drawable d2 = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level 3)");
                        current.setLevel(3);
                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
//                                minuman.setImageResource(R.drawable.minuman2);
//                                Drawable m1 = minuman.getDrawable();
//                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        btnn.setBackgroundResource(R.drawable.btn_round);
                        Drawable d3 = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level 4)");
                        current.setLevel(4);
                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
//                                minuman.setImageResource(R.drawable.minuman3);
//                                Drawable m1 = minuman.getDrawable();
//                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    case 4:
                        btnn.setBackgroundResource(R.drawable.btn_round2);
                        Drawable d4 = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level MAX)");
                        current.setLevel(5);
                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
//                                minuman.setImageResource(R.drawable.minuman4);
//                                Drawable m1 = minuman.getDrawable();
//                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    case 5:
                        btnn.setBackgroundResource(R.drawable.btn_round);
                        Drawable d5 = btnn.getBackground();
                        holder.namaButton.setText(current.nama + " (Level MAX)");
                        btnn.setEnabled(true);
                        switch (itemPotatoes.get(position).nama){
                            case "Minuman":
//                                minum.setImageResource(R.drawable.minuman5);
//                                Drawable m1 = minum.getDrawable();
//                                current.setPrice(current.getPrice() + 200);
                                break;
                            case "Headset":
                                break;
                            case "Poster":
                                break;
                            case "PC":
                                break;
                            case "Kursi":
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemPotatoes.size();
    }
}