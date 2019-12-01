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
    ArrayList<itemPotato> listItem = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bawah, container, false);
        initializeData();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = new RecycleViewAdapter_bawah(this,listItem);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
    }

    private void initializeData(){
        listItem = new ArrayList<>();
        listItem.add(new itemPotato("Minuman", 0,100));
        listItem.add(new itemPotato("Headset",0,200));
        listItem.add(new itemPotato("Poster",0,350));
        listItem.add(new itemPotato("PC",0,450));
        listItem.add(new itemPotato("Kursi",0,250));
        //Minuman, headset, poster, PC, kursi

    }
}
