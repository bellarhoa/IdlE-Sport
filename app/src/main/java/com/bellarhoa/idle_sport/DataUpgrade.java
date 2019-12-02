package com.bellarhoa.idle_sport;

import android.widget.ImageView;

public class DataUpgrade {
    public String nama;
    public int level;
    public int harga;
    public int gambar;
    public int type;


    public DataUpgrade(String nama, int level, int harga, int type) {
        setNama(nama);
        setLevel(level);
        setHarga(harga);
        this.type = type;
    }

    public void setNama(String a){
        this.nama = a;
    }

    public String getNama(){
        return nama;
    }

    public void setLevel(int b){
        this.level = b;
    }

    public int getLevel(){
        return level;
    }

    public void setHarga(int c){
        this.harga = c;
    }

    public int getHarga(){
        return harga;
    }

}
