package com.bellarhoa.idle_sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Credit extends AppCompatActivity {
    TextView textSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        SharedPreferences dataSP = getSharedPreferences("dataSP",0);
        int money = dataSP.getInt("keyPoint", 0);
        ArrayList<DataUpgrade> potato = FragmentBawah.itemPotatoes;
        int progress = 0;
        for(int i=0;i<potato.size();i++){
            progress+=potato.get(i).getLevel();
        }
        float precentage = (float) progress*100/(potato.size()*4);

        textSummary = findViewById(R.id.completion);
        textSummary.setText("Completion Summary:\n\nmoney: "+String.valueOf(money)+"\nupgrade: "+String.valueOf(precentage)+"%");
    }
}
