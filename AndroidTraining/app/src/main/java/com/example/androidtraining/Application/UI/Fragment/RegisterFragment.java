package com.example.androidtraining.Application.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.R;

import static com.example.androidtraining.R.layout.registration;

public class RegisterFragment extends Fragment {
    public static final String RTAG="Registration";
    Toolbar mToolbar;
    View mView;
    Spinner spinner;
    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(registration, container, false);
        mToolbar = mView.findViewById(R.id.toolbar);
         spinner =  mView.findViewById(R.id.r_country);
       // ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);

        return mView;
    }
}