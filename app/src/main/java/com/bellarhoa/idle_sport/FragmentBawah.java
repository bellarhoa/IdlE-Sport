package com.bellarhoa.idle_sport;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentBawah extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public static ArrayList<DataUpgrade> itemPotatoes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bawah, container, false);
        initializeData();
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mAdapter = new RecycleViewAdapter_bawah(getActivity(),itemPotatoes);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP",0);
        for (int i=0 ; i<itemPotatoes.size() ; i++){
            itemPotatoes.get(i).setHarga(dataSP.getInt("keyHarga"+String.valueOf(i), itemPotatoes.get(i).getHarga()));
            itemPotatoes.get(i).setLevel(dataSP.getInt("keyLevel"+String.valueOf(i), itemPotatoes.get(i).getLevel()));
        }
    }

    private void initializeData(){
        itemPotatoes = new ArrayList<>();
        itemPotatoes.add(new DataUpgrade("Drink", 0,100,0));
        itemPotatoes.add(new DataUpgrade("PC",0,1000,1));
        itemPotatoes.add(new DataUpgrade("Headset",0,600, 3));
        itemPotatoes.add(new DataUpgrade("Poster",0,200, 2));
        itemPotatoes.add(new DataUpgrade("Chair",0,800, 4));
        //Minuman, headset, poster, PC, kursi

    }
}
