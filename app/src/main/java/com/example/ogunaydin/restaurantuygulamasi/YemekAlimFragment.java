package com.example.ogunaydin.restaurantuygulamasi;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YemekAlimFragment extends Fragment {
    private PushDatasActivity pushDatasActivity;
    private EditText etBaslangic, etAnaYemek, etTatli, etIcecek;
    private Button btnIlet;

    public YemekAlimFragment() {
        // Required empty public constructor
    }

    public static YemekAlimFragment newInstance() {
        YemekAlimFragment fragment = new YemekAlimFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        pushDatasActivity = (PushDatasActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yemek_alim, container, false);

        etBaslangic = (EditText) view.findViewById(R.id.et_baslangic);
        etAnaYemek = (EditText) view.findViewById(R.id.et_ana_yemek);
        etTatli = (EditText) view.findViewById(R.id.et_tatli);
        etIcecek = (EditText) view.findViewById(R.id.et_icecek);
        btnIlet = (Button) view.findViewById(R.id.btn_ilet);

        btnIlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMealEditDatas();
            }
        });
        return view;
    }

    private void checkMealEditDatas() {
        String strBaslangic = null;
        String strAnaYemek = null;
        String strTatli = null;
        String strIcecek = null;

        strBaslangic = etBaslangic.getText().toString();
        strAnaYemek = etAnaYemek.getText().toString();
        strTatli = etTatli.getText().toString();
        strIcecek = etIcecek.getText().toString();

        if (TextUtils.isEmpty(strBaslangic)) {
            Toast.makeText(getActivity(), R.string.error_empty_edittext, Toast.LENGTH_LONG).show();
            return;
        }


        if (TextUtils.isEmpty(strAnaYemek)) {
            Toast.makeText(getActivity(), R.string.error_empty_edittext, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(strTatli)) {
            Toast.makeText(getActivity(), R.string.error_empty_edittext, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(strIcecek)) {
            Toast.makeText(getActivity(), R.string.error_empty_edittext, Toast.LENGTH_LONG).show();
            return;
        }


        Siparis siparis = new Siparis(strBaslangic, strAnaYemek, strTatli, strIcecek);

        pushDatasActivity.datasArrived(siparis);
    }


    public interface PushDatasActivity {
        void datasArrived(Siparis siparis);
    }

}
