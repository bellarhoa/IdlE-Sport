package com.bellarhoa.idle_sport;

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
    ArrayList<DataUpgrade> itemPotatoes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bawah, container, false);
        initializeData();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = new RecycleViewAdapter_bawah(this,itemPotatoes);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
    }

    private void initializeData(){
        itemPotatoes = new ArrayList<>();
        itemPotatoes.add(new DataUpgrade("Minuman", 0,100));
        itemPotatoes.add(new DataUpgrade("Headset",0,200));
        itemPotatoes.add(new DataUpgrade("Poster",0,350));
        itemPotatoes.add(new DataUpgrade("PC",0,450 ));
        itemPotatoes.add(new DataUpgrade("Kursi",0,250));
        //Minuman, headset, poster, PC, kursi

    }
}
