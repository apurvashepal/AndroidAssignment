package com.example.androidtraining.Application.UI.Fragment;

import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import com.example.androidtraining.Application.UI.Activity.Aunthentication;
import com.example.androidtraining.Application.Utils;
import com.example.androidtraining.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.androidtraining.Application.UI.*;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static androidx.core.content.ContextCompat.checkSelfPermission;
import static com.example.androidtraining.Application.UI.Fragment.LoginFragment.TAG;
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
    EditText Imei1, Imei,mName,mpassword,mAge,mContact,mAadhar;
    private List<String> countryList = new ArrayList<>();
    private List<String> stateList1 = new ArrayList<>();
    private List<String> stateList2 = new ArrayList<>();
    private ArrayAdapter<String> adapterState1,adapterState2;

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
        mName = mView.findViewById(R.id.r_name);
        mAge=mView.findViewById(R.id.r_age);
        mContact=mView.findViewById(R.id.r_contact);
        mpassword =mView.findViewById(R.id.r_password);
        mAadhar = mView.findViewById(R.id.r_aadhar_number);
        addListenerOnSpinnerItemSelection();
        mRegister.setOnClickListener(this);


        setimei();
    }

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



    @Override
    public void onClick(View view) {
       try{ switch (view.getId()) {
           case R.id.btn_Register:
               if (isValid()) {
                   ((Aunthentication) getActivity()).loadFragment(R.id.fragment_lay,new LoginFragment(),"Login",true);
               }
               break;
           case R.id.r_country:
               addListenerOnSpinnerItemSelection();
               break;

           default:
       }
       }catch (Exception e){
           Log.e(RTAG, "onClick: Invalid Data" );
       }
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
            stateList1 = Arrays.asList(getResources().getStringArray(state_array_India));
            adapterState1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList1);
            adapterState1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState1);
        }
        if (country.contentEquals("ShriLanka")) {
            stateList2 = Arrays.asList(getResources().getStringArray(state_array_India));
            adapterState2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, stateList2);
            adapterState2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            mState.setAdapter(adapterState2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Utils.AlertBox(getActivity(),getString(R.string.d_title),getString(R.string.d_message));
    }


}
