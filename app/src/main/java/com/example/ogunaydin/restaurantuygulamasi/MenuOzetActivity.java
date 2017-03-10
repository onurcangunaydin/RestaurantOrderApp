package com.example.ogunaydin.restaurantuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuOzetActivity extends AppCompatActivity {
    public static final String SIPARIS_LIST = "siparis_list";
    List<Siparis> siparisList;
    ListView menuList;


    public static Intent newInstance(Context context, ArrayList<Siparis> siparisList) {
        Intent intent = new Intent(context, MenuOzetActivity.class);
        intent.putExtra(SIPARIS_LIST, siparisList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ozet);

        siparisList = getIntent().getParcelableArrayListExtra(SIPARIS_LIST);
        menuList = (ListView) findViewById(R.id.siparisListe);


        menuList.setAdapter(new MenuListeAdapter(siparisList));

    }
}
