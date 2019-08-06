package com.example.androidtraining.Application.UI.Fragment;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String Name;
    private int Age;
    private int Gender;
    private Long Contact;
    private String password;
    private String Country;
    private String State;
    private  int Aadhar;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
