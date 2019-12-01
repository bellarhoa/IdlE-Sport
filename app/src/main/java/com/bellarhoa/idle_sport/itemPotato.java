package com.bellarhoa.idle_sport;

public class itemPotato {
    public String nama;
    public int level;
    public int price;

    public itemPotato (String nama, int level, int price) {
        this.nama = nama;
        this.level = level;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String name) {
        this.nama = name;
    }

}
