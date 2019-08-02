package com.example.androidtraining.Application.UI.Fragment;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.example.androidtraining.Application.UI.Activity.Aunthentication;

import com.example.androidtraining.R;



public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String TAG="Login";
    private  EditText mcontact,mpassword;
    private View  mView;
    private Button mSignIn,mVisibility;
    private TextView mText;
    private boolean isPasswordVisible;

    int setImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.login,container,false);
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

            case R.id.l_show_hide:
                togglePassVisability();


        }
    }


    private boolean isValid() {

        mcontact= mView.findViewById(R.id.l_contact);
        mpassword=mView.findViewById(R.id.l_password);
        String contact=mcontact.getText().toString();
        String password=mpassword.getText().toString();

        int valid =contact.compareTo(password);
        if(contact.isEmpty() ){
            mcontact.setError("Username should not be empty ");
        }
        if( password.isEmpty())
            mpassword.setError("Password should not be empty");
        if (valid == 0) {
            return true;
         }
         else
            return false;
    }


    private void togglePassVisability() {
        mpassword=mView.findViewById(R.id.l_password);
                if (!isPasswordVisible) {
                    setImage = R.drawable.hide_password;
                    mpassword.setTransformationMethod(new PasswordTransformationMethod());
                }
                else
                {
                    setImage =R.drawable.show_password;
                    mpassword.setTransformationMethod(null);
                }
                isPasswordVisible= !isPasswordVisible;
               // mVisibility.setImageDrawable( ContextCompat.getDrawable(getActivity().getApplicationContext(), setImage));

            }
        }











