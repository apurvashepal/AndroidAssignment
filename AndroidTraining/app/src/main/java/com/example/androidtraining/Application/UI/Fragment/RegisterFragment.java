package com.example.androidtraining.Application.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.Application.UI.Activity.Aunthentication;
import com.example.androidtraining.R;

import static com.example.androidtraining.R.layout.registration;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    public static final String RTAG="Registration";
    Toolbar mToolbar;
    View mView;
    Spinner spinner;
    Button mRegister;
    TelephonyManager tel;

    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(registration, container, false);
        mToolbar = mView.findViewById(R.id.toolbar);
         spinner =  mView.findViewById(R.id.r_country);
       // ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
            mRegister = mView.findViewById(R.id.btn_Register);
            mRegister.setOnClickListener(this);
            setimei();
        return mView;
    }

    private void setimei() {
        EditText Imei1,Imei2;
        Context context;

        tel= (TelephonyManager) ((Aunthentication) getActivity()).getSystemService( Context.TELEPHONY_SERVICE );

        Imei1 = (EditText) mView.findViewById(R.id.r_imei1);
        //Imei1.setText(tel.getDeviceId());
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Register:
                if(isValid()){

                }
                break;
             default:
        }
    }

    private boolean isValid() {
        String mName,Age,Contact,password,Aadhar,IMEI1,IMEI2;
        mName=(((EditText)mView.findViewById(R.id.r_name)).getText()).toString();
        Age =(((EditText)mView.findViewById(R.id.r_age)).getText()).toString();
        Contact=(((EditText)mView.findViewById(R.id.r_contact)).getText()).toString();



    return true;
    }
}