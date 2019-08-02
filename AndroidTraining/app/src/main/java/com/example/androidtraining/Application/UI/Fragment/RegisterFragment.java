package com.example.androidtraining.Application.UI.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;
import android.telephony.TelephonyManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.androidtraining.Application.UI.Activity.Aunthentication;
import com.example.androidtraining.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static androidx.core.content.ContextCompat.checkSelfPermission;
import static com.example.androidtraining.R.array.country_array;
import static com.example.androidtraining.R.array.state_array_India;
import static com.example.androidtraining.R.array.state_array_ShriLanka;
import static com.example.androidtraining.R.layout.registration;

public class RegisterFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    public static final String RTAG = "Registration";
    public static final int PERMISSION_READ_STATE=1;
    private Toolbar mToolbar;
    private View mView;
    private Spinner mCountry, mState;
    private Button mRegister;
    private TelephonyManager tel;
    EditText Imei1, Imei2;
    private List<String> countryList = new ArrayList<>();
    private List<String> stateList = new ArrayList<>();
    private ArrayAdapter<String> adapterState;

    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(registration, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = mView.findViewById(R.id.toolbar);
        mRegister = mView.findViewById(R.id.btn_Register);
        addListenerOnSpinnerItemSelection();
        mRegister.setOnClickListener(this);


       // setimei();
    }
/*
    private void setimei() {
        //Code for IMEI Fetching

        //CheckPermission for Reading the Phone State.
        //Dangerous Permission are restricted by Android and USer can revoke the Permission so generating run time Permission .
        if (checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // We do not have this permission. Let's ask the user
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_READ_STATE);
        }
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();  //Storing the IMEI Number.
        Imei1.setText(imei);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted!
                    // you may now do the action that requires this permission
                } else {
                    // permission denied
                }
                return;
            }
        }
    }
*/


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Register:
                if (isValid()) {

                }
                break;
            case R.id.r_country:
                addListenerOnSpinnerItemSelection();
                break;

            default:
        }
    }







    private boolean isValid() {
        String mName, Age, Contact, password, Aadhar, IMEI1, IMEI2;
        mName = (((EditText) mView.findViewById(R.id.r_name)).getText()).toString();
        Age = (((EditText) mView.findViewById(R.id.r_age)).getText()).toString();
        Contact = (((EditText) mView.findViewById(R.id.r_contact)).getText()).toString();

        if (mName.isEmpty() || Age.isEmpty() || Contact.isEmpty()) {
            Toast.makeText(getActivity(), "Fields Should not be Empty", Toast.LENGTH_LONG).show();
        }

        return true;
    }

    private void addListenerOnSpinnerItemSelection() {
        mCountry = mView.findViewById(R.id.r_country);
        mState = mView.findViewById(R.id.r_state);
        countryList = Arrays.asList(getResources().getStringArray(country_array));
        ArrayAdapter adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,countryList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mCountry.setAdapter(adapter);

        mCountry.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String country = String.valueOf(adapterView.getSelectedItem());
        if (country.contentEquals("India")) {
            stateList = Arrays.asList(getResources().getStringArray(state_array_India));
            adapterState = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList);
            adapterState.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState);
        }
        if (country.contentEquals("ShriLanka")) {
            stateList = Arrays.asList(getResources().getStringArray(state_array_India));
            adapterState = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList);
            adapterState.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //@Override
 /*   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String country = String.valueOf(mCountry.getSelectedItem());
        Toast.makeText(getActivity(), country, Toast.LENGTH_SHORT).show();
        if(country.contentEquals("India")){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity()
                    ,android.R.layout.simple_spinner_item,
                    stateList
                    );
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
        }
    }*/
}
