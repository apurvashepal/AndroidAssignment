package com.example.androidtraining.Application.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.Intent;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.androidtraining.Application.UI.Activity.Aunthentication;

import com.example.androidtraining.R;



public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String TAG="Login";

    View  mView;
    Button mSignIn,mRemPassword,mRegister;
    TextView mText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  mView=inflater.inflate(R.layout.login,container,false);
        mSignIn=mView.findViewById(R.id.l_signin);
        mText = mView.findViewById(R.id.l_register);

        mSignIn.setOnClickListener(this);
        mText.setOnClickListener(this);
        return mView;

        }



    public void onClick(View view)
    {    final LoginFragment context = this;
        switch (view.getId()) {
            case R.id.l_signin:
                if(isValid()){
                    Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getActivity(),"Username and Password Not Matching",Toast.LENGTH_LONG).show();

                break;
            case R.id.l_register:
                ((Aunthentication) getActivity()).loadFragment(R.id.fragment_lay,new RegisterFragment(),"Registration",true);


        }
    }


    private boolean isValid() {
        EditText contact,password;
        contact= mView.findViewById(R.id.l_contact);
        password=mView.findViewById(R.id.l_password);
        String c=contact.toString();
        String p=password.toString();
        int valid =c.compareTo(p);
        if (valid == 0) {
            return true;
        }
        else
            return false;
    }




}







