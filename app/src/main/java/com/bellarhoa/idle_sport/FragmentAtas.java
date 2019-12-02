package com.bellarhoa.idle_sport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentAtas extends Fragment {
    public static ImageView imageDrink;
    public static ImageView imagePC;
    public static ImageView imagePoster;
    public static ImageView imageHeadset;
    public static ImageView imageChair;
    private TextView textViewPoint;
    private TextView textViewClickPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_atas, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        textViewPoint = getActivity().findViewById(R.id.textView_point);
        textViewClickPoint = getActivity().findViewById(R.id.textView_clickPoint);
        final ProgressBar progBar = getActivity().findViewById(R.id.progBar);
        ImageView layoutTap = getActivity().findViewById(R.id.layoutTap);

        imageDrink = getActivity().findViewById(R.id.imagedrink);
        imagePC = getActivity().findViewById(R.id.imagepc);
        imagePoster = getActivity().findViewById(R.id.imageposter);
        imageHeadset = getActivity().findViewById(R.id.imagepeople);
        imageChair = getActivity().findViewById(R.id.imagechair);

        SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP",0);
        int currPoint = dataSP.getInt("keyPoint", 0);
        textViewPoint.setText(String.valueOf(currPoint));

        Intent mIntent = new Intent(getActivity(), FragmentBawah.class);
        Bundle mBundle = new Bundle();
        mIntent.putExtras(mBundle);
        ImageView img = getActivity().findViewById(R.id.imageposter);
        img.setImageResource(R.drawable.poster2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (true) {
                        i++;
                        Thread.sleep(500);

                        //Untuk lihat apa thread jalan atau tidak di "Run"
//                        Log.i("not dead", "not dead" + i);

                        progBar.post(new Runnable() {
                            @Override
                            public void run() {
                                SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP",0);
                                int currPoint = dataSP.getInt("keyPoint", 0) + 10;
                                textViewPoint.setText("$"+String.valueOf(currPoint));
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

        layoutTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hasil Tap default aja = 5, sementara pakai ini
//                SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP", 0);
//                int currPoint = dataSP.getInt("keyPoint", 0);
//                textViewPoint.setText(String.valueOf(currPoint+5) + "\t+5");
//
//                SharedPreferences.Editor editData = dataSP.edit();
//                editData.putInt("keyPoint", currPoint);
//                editData.apply();

                //Ambil hasil Tap dari level upgrade
                SharedPreferences dataSP = getActivity().getSharedPreferences("dataSP", 0);
                int currPoint = dataSP.getInt("keyPoint", 0);
                int currTap = dataSP.getInt("keyTap", 5);
                textViewPoint.setText("$"+String.valueOf(currPoint));
                textViewClickPoint.setText("+$"+String.valueOf(currTap));
                startAnimation();
                SharedPreferences.Editor editData = dataSP.edit();
                editData.putInt("keyPoint", currPoint+currTap);
                editData.apply();
            }
        });
    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this.getActivity(), R.anim.animation_clickPoint);
        textViewClickPoint.startAnimation(animation);
    }
}
