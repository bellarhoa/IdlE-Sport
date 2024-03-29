package com.bellarhoa.idle_sport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager frgManager;
    private FragmentTransaction frgtransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frgManager = getSupportFragmentManager();
        frgtransaction = frgManager.beginTransaction();
        Bundle bundle = new Bundle();
        FragmentAtas fragmentAtas = new FragmentAtas();
        fragmentAtas.setArguments(bundle);
        frgtransaction.add(R.id.containerAtas, fragmentAtas);
        frgtransaction.addToBackStack(null);
        frgtransaction.commit();

        frgManager = getSupportFragmentManager();
        frgtransaction = frgManager.beginTransaction();
        Bundle bundle2 = new Bundle();
        FragmentBawah fragmentBawah = new FragmentBawah();
        fragmentBawah.setArguments(bundle2);
        frgtransaction.add(R.id.containerBawah, fragmentBawah);
        frgtransaction.addToBackStack(null);
        frgtransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Credit.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
