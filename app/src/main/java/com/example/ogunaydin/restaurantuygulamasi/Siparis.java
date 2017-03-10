package com.example.ogunaydin.restaurantuygulamasi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cnkaptan on 08/03/2017.
 */

public class Siparis implements Parcelable {
    private String baslangic;
    private String anaMenu;
    private String tatli;
    private String icecek;

    public Siparis(String baslangic, String anaMenu, String tatli, String icecek) {
        this.baslangic = baslangic;
        this.anaMenu = anaMenu;
        this.tatli = tatli;
        this.icecek = icecek;
    }

    public String getBaslangic() {
        return baslangic;
    }

    public void setBaslangic(String baslangic) {
        this.baslangic = baslangic;
    }

    public String getAnaMenu() {
        return anaMenu;
    }

    public void setAnaMenu(String anaMenu) {
        this.anaMenu = anaMenu;
    }

    public String getTatli() {
        return tatli;
    }

    public void setTatli(String tatli) {
        this.tatli = tatli;
    }

    public String getIcecek() {
        return icecek;
    }

    public void setIcecek(String icecek) {
        this.icecek = icecek;
    }

    @Override
    public String toString() {
        return "Siparis{" +
                "baslangic='" + baslangic + '\'' +
                ", anaMenu='" + anaMenu + '\'' +
                ", tatli='" + tatli + '\'' +
                ", icecek='" + icecek + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.baslangic);
        dest.writeString(this.anaMenu);
        dest.writeString(this.tatli);
        dest.writeString(this.icecek);
    }

    protected Siparis(Parcel in) {
        this.baslangic = in.readString();
        this.anaMenu = in.readString();
        this.tatli = in.readString();
        this.icecek = in.readString();
    }

    public static final Parcelable.Creator<Siparis> CREATOR = new Parcelable.Creator<Siparis>() {
        @Override
        public Siparis createFromParcel(Parcel source) {
            return new Siparis(source);
        }

        @Override
        public Siparis[] newArray(int size) {
            return new Siparis[size];
        }
    };
}
