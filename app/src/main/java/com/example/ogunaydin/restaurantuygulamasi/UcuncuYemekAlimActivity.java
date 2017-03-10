package com.example.ogunaydin.restaurantuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UcuncuYemekAlimActivity extends AppCompatActivity implements YemekAlimFragment.PushDatasActivity {

    public static final String SIPARIS = "siparis";
    private List<Siparis> siparisListe;

    public static Intent newInstance(Context context, ArrayList<Siparis> siparisList) {
        Intent intent = new Intent(context, UcuncuYemekAlimActivity.class);
        intent.putExtra(SIPARIS, siparisList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucuncu_yemek_alim_aktivity);

        siparisListe = getIntent().getParcelableArrayListExtra(SIPARIS);


    }

    @Override
    public void datasArrived(Siparis siparis) {
        siparisListe.add(siparis);
        startActivity(MenuOzetActivity.newInstance(this, new ArrayList<Siparis>(siparisListe)));
    }
}
