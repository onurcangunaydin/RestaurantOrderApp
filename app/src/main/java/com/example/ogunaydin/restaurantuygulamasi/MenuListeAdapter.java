package com.example.ogunaydin.restaurantuygulamasi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MenuListeAdapter extends BaseAdapter {
    List<Siparis> siparisList;

    public MenuListeAdapter(List<Siparis> siparisList) {
        this.siparisList = siparisList;
    }


    @Override
    public int getCount() {
        return siparisList.size();
    }

    @Override
    public Siparis getItem(int position) {
        return siparisList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.siparis_item_layout, parent, false);
        TextView tvBaslangic = (TextView) view.findViewById(R.id.tv_baslangic);
        TextView tvAnaYemek = (TextView) view.findViewById(R.id.tv_ana_yemek);
        TextView tvTatli = (TextView) view.findViewById(R.id.tv_tatli);
        TextView tvIcecek = (TextView) view.findViewById(R.id.tv_icecek);

        Siparis siparis = getItem(position);

        tvBaslangic.setText(siparis.getBaslangic());
        tvAnaYemek.setText(siparis.getAnaMenu());
        tvTatli.setText(siparis.getTatli());
        tvIcecek.setText(siparis.getIcecek());
        return view;
    }
}
