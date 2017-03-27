package com.example.ogunaydin.restaurantuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class IkinciYemekAlimActivity extends AppCompatActivity implements YemekAlimFragment.PushDatasActivity {


    private static final String SIPARIS = "siparis";
    private List<Siparis> siparisList;

    public static Intent newInstance(Context context, ArrayList<Siparis> siparisList) {
        Intent intent = new Intent(context, IkinciYemekAlimActivity.class);
        intent.putExtra(SIPARIS, siparisList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci_yemek_alim);

        siparisList = getIntent().getParcelableArrayListExtra(SIPARIS);

    }

    @Override
    public void datasArrived(Siparis siparis) {
        siparisList.add(siparis);

        startActivity(UcuncuYemekAlimActivity.newInstance(this, new ArrayList<Siparis>(siparisList)));
    }
}
