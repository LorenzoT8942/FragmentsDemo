package it.claudiopezzino.fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FragmentToActivity extends AppCompatActivity implements FTA_Fragment2.Fragment2Listener, FTA_Fragment1.Fragment1Listener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fta_comm);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_1, new FTA_Fragment1()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_2, new FTA_Fragment2()).commit();
        }
    }

    @Override
    public void onFragment1Button1Clicked() {
        Log.d("F1B1", "Button 1 of Fragment 1 clicked");
        Toast.makeText(getApplicationContext(), "Button 1 of Fragment 1 clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragment1Button2Clicked() {
        Log.d("F1B2", "Button 2 of Fragment 1 clicked");
        Toast.makeText(getApplicationContext(), "Button 2 of Fragment 1 clicked", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFragment2Button1Click() {
        Log.d("F2B1", "Button 1 of Fragment 2 clicked");
        Toast.makeText(getApplicationContext(), "Button 1 of Fragment 2 clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFragment2Button2Click() {
        Log.d("F2B2", "Button 2 of Fragment 2 clicked");
        Toast.makeText(getApplicationContext(), "Button 2 of Fragment 2 clicked", Toast.LENGTH_SHORT).show();
    }
}






