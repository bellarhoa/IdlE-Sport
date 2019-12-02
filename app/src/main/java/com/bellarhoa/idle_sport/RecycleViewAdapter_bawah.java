package com.bellarhoa.idle_sport;
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


    public RecycleViewAdapter_bawah(FragmentBawah context, ArrayList<DataUpgrade> itemPotatoes) {
        this.mInflater = (LayoutInflater) LayoutInflater.from(context.getActivity());
        this.itemPotatoes = itemPotatoes;
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


//                TextView txt = (TextView) v.findViewById(R.id.tv_text);
//                ImageView imagePC = v.findViewById(R.id.imagepc);
//                ImageView imagePeople = v.findViewById(R.id.imagepeople);
//                ImageView imageChair = v.findViewById(R.id.imagechair);
//                ImageView imageDrink = v.findViewById(R.id.imagedrink);
//                ImageView imagePoster = v.findViewById(R.id.imageposter);
//
//                switch (itemPotatoes.get(position).level){
//                    case 0:
//                        current.setHarga(current.getHarga() + 200);
//                        holder.txt.setText(current.nama + " (Level 1)");
//                        imagePC.setImageResource(R.drawable.chair1);
//                        imagePeople.setImageResource(R.drawable.drink1);
//
//                        break;
//                }
//
//
//                switch (itemPotatoes.get(position).level) {
//                    case 0:
//                        btnn.setBackgroundResource(R.drawable.btn_round);
//                        Drawable d = btnn.getBackground();
//                        current.setLevel(1);
//                        //Minuman, headset, poster, PC, kursi
//
//                        switch (itemPotatoes.get(position).nama){
//                            case "Minuman":
////                                holder.imgMinum.setImageResource(current.setGambar(R.drawable.minuman3));
////                                Drawable m1 = minuman.getDrawable();
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 1)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Headset":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 1)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Poster":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 1)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "PC":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 1)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Kursi":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 1)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            default:
//                                break;
//                        }
//                        break;
//                    case 1:
//                        btnn.setBackgroundResource(R.drawable.btn_round1);
//                        Drawable d1 = btnn.getBackground();
//                        current.setLevel(2);
//                        switch (itemPotatoes.get(position).nama){
//                            case "Minuman":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 2)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Headset":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 2)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Poster":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 2)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "PC":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 2)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Kursi":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 2)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            default:
//                                break;
//                        }
//                        break;
//                    case 2:
//                        btnn.setBackgroundResource(R.drawable.btn_round2);
//                        Drawable d2 = btnn.getBackground();
//                        current.setLevel(3);
//                        switch (itemPotatoes.get(position).nama){
//                            case "Minuman":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 3)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Headset":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 3)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Poster":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 3)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "PC":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 3)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Kursi":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 3)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            default:
//                                break;
//                        }
//                        break;
//                    case 3:
//                        btnn.setBackgroundResource(R.drawable.btn_round3);
//                        Drawable d3 = btnn.getBackground();
//                        current.setLevel(4);
//                        switch (itemPotatoes.get(position).nama){
//                            case "Minuman":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 4)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Headset":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 4)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Poster":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 4)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "PC":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 4)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            case "Kursi":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level 4)");
//                                holder.namaButton.setText("Beli\n Rp. "+ current.getHarga());
//                                break;
//                            default:
//                                break;
//                        }
//                        break;
//                    case 4:
//                        btnn.setBackgroundResource(R.drawable.btn_round4);
//                        Drawable d4 = btnn.getBackground();
//                        current.setLevel(5);
//                        switch (itemPotatoes.get(position).nama){
//                            case "Minuman":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level MAX)");
//                                holder.namaButton.setText("MAX");
//                                break;
//                            case "Headset":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level MAX)");
//                                holder.namaButton.setText("MAX");
//                                break;
//                            case "Poster":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level MAX)");
//                                holder.namaButton.setText("MAX");
//                                break;
//                            case "PC":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level MAX)");
//                                holder.namaButton.setText("MAX");
//                                break;
//                            case "Kursi":
//                                current.setHarga(current.getHarga() + 200);
//                                holder.txt.setText(current.nama + " (Level MAX)");
//                                holder.namaButton.setText("MAX");
//                                break;
//                            default:
//                                break;
//                        }
//                        btnn.setEnabled(true);
//                        break;
//                    default:
//                        break;
//                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemPotatoes.size();
    }
}