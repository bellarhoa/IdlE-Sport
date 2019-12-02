package com.bellarhoa.idle_sport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentAtas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_atas, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        final TextView textViewPoint = getActivity().findViewById(R.id.textView_point);
        final ProgressBar progBar = getActivity().findViewById(R.id.progBar);
        ImageView gambarBackground = getActivity().findViewById(R.id.imageBackground);

        Intent mIntent = new Intent(getActivity(), FragmentBawah.class);
        Bundle mBundle = new Bundle();
        mBundle.putInt("photo", R.id.imgMinuman);
        mIntent.putExtras(mBundle);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (true) {
                        i++;
                        Thread.sleep(1000);

                        //Untuk lihat apa thread jalan atau tidak di "Run"
//                        Log.i("not dead", "not dead" + i);

                        progBar.post(new Runnable() {
                            @Override
                            public void run() {
                                SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP",0);
                                int currPoint = dataSP.getInt("keyPoint", 0) + 10;
                                textViewPoint.setText(String.valueOf(currPoint));

                                SharedPreferences.Editor editData = dataSP.edit();
                                editData.putInt("keyPoint", currPoint);
                                editData.apply();
                            }
                        });

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        gambarBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hasil Tap default aja = 5, sementara pakai ini
                SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP", 0);
                int currPoint = dataSP.getInt("keyPoint", 0);
                textViewPoint.setText(String.valueOf(currPoint+5) + "\t+5");

                SharedPreferences.Editor editData = dataSP.edit();
                editData.putInt("keyPoint", currPoint);
                editData.apply();

                //Ambil hasil Tap dari level upgrade
//                SharedPreferences dataSP = getSharedPreferences("dataSP", 0);
//                int currPoint = dataSP.getInt("keyPoint", 0) + dataSP.getInt("keyTap", 0);
//                textViewPoint.setText(String.valueOf(currPoint));
//
//                SharedPreferences.Editor editData = dataSP.edit();
//                editData.putInt("keyPoint", currPoint);
//                editData.apply();
            }
        });
    }
}
