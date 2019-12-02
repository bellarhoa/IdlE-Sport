package com.bellarhoa.idle_sport;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class RecycleViewAdapter_bawah extends RecyclerView.Adapter<RecycleViewAdapter_bawah.ViewHolder> {
    LayoutInflater mInflater;
    ArrayList<DataUpgrade> dataUpgrade;
    Context context;

    public RecycleViewAdapter_bawah(Context context, ArrayList<DataUpgrade> dataUpgrade) {
        this.mInflater = LayoutInflater.from(context);
        this.dataUpgrade = dataUpgrade;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button namaButton;
        TextView txt;

        public ViewHolder(View v) {
            super(v);
            namaButton = v.findViewById(R.id.btn);
            txt = v.findViewById(R.id.tv_text);
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
        final DataUpgrade current = dataUpgrade.get(position);
        holder.txt.setText(current.nama);
        holder.namaButton.setText("Beli\n"+ current.harga);

        holder.namaButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Button btnn = v.findViewById(R.id.btn);
                SharedPreferences dataSP = context.getSharedPreferences("dataSP", 0);
                int currTap;
                SharedPreferences.Editor editData = dataSP.edit();

                // KUDU DI FRAGMENT ATAS NGUBAH GAMBARNYA :)

//                FragmentAtas fragAtas = new FragmentAtas();
//                ImageView minum = (ImageView) .getActivity().findViewById(R.id.imgMinuman);
//
//                ImageView headset = (ImageView) v.findViewById(R.drawable.headset0);
//                ImageView poster = (ImageView) v.findViewById(R.drawable.poster0);
//                ImageView pc = (ImageView) v.findViewById(R.drawable.pc0);
//                ImageView kursi = (ImageView) v.findViewById(R.drawable.kursi0);

                switch (dataUpgrade.get(position).level) {
                    case 0:
                        btnn.setBackgroundResource(R.drawable.btn_round);
                        //Minuman, headset, poster, PC, kursi
                        switch (dataUpgrade.get(position).nama){
                            case "Minuman":
//                                holder.imgMinum.setImageResource(current.setGambar(R.drawable.minuman3));
//                                Drawable m1 = minuman.getDrawable();
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Headset":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Poster":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "PC":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Kursi":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1:
                        btnn.setBackgroundResource(R.drawable.btn_round1);
                        switch (dataUpgrade.get(position).nama){
                            case "Minuman":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Headset":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Poster":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "PC":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Kursi":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        btnn.setBackgroundResource(R.drawable.btn_round2);
                        switch (dataUpgrade.get(position).nama){
                            case "Minuman":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Headset":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Poster":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "PC":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Kursi":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        btnn.setBackgroundResource(R.drawable.btn_round3);
                        switch (dataUpgrade.get(position).nama){
                            case "Minuman":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                 holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Headset":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                 holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Poster":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "PC":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                 holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Kursi":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                 holder.txt.setText(current.nama + " (Level "+current.getLevel()+")");
                                holder.namaButton.setText("Beli\n"+ current.getHarga());

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 4:
                        btnn.setBackgroundResource(R.drawable.btn_round4);
                        switch (dataUpgrade.get(position).nama){
                            case "Minuman":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level MAX)");
                                holder.namaButton.setText("MAX");

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Headset":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level MAX)");
                                holder.namaButton.setText("MAX");

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Poster":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level MAX)");
                                holder.namaButton.setText("MAX");

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "PC":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level MAX)");
                                holder.namaButton.setText("MAX");

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            case "Kursi":
                                current.setLevel(current.getLevel()+1);
                                current.setHarga(current.getHarga() + 200);
                                holder.txt.setText(current.nama + " (Level MAX)");
                                holder.namaButton.setText("MAX");

                                currTap = dataSP.getInt("keyTap", 5);
                                editData.putInt("keyTap", currTap+current.level);
                                editData.apply();
                                break;
                            default:
                                break;
                        }
                        btnn.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUpgrade.size();
    }
}