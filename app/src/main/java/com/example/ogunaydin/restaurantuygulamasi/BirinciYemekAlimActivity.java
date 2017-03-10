package com.example.ogunaydin.restaurantuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BirinciYemekAlimActivity extends AppCompatActivity implements YemekAlimFragment.PushDatasActivity {
    List<Siparis> siparisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siparisList = new ArrayList<>();

    }

    @Override
    public void datasArrived(Siparis siparis) {
        siparisList.add(siparis);

        startActivity(IkinciYemekAlimActivity.newInstance(this, new ArrayList<Siparis>(siparisList)));
    }
}
