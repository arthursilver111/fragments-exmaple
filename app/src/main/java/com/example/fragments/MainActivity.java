package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonFragmentAdd = findViewById(R.id.buttonFragmentAdd);
        buttonFragmentAdd.setOnClickListener(this);
        Button buttonFragmentTwo = findViewById(R.id.buttonFragmentDelete);
        buttonFragmentTwo.setOnClickListener(this);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        setFragment(firstFragment);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonFragmentAdd) {
            setFragment(firstFragment);
        }
        if (view.getId() == R.id.buttonFragmentDelete) {
            setFragment(secondFragment);
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
