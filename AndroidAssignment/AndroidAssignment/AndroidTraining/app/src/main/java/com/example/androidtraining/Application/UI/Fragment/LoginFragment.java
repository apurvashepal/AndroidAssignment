package com.example.androidtraining.Application.UI.Fragment;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.androidtraining.Application.UI.Activity.Aunthentication;

import com.example.androidtraining.R;



public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String TAG="Login";
    private  EditText mcontact,mpassword;
    private View  mView;
    private Button mSignIn;
    private ImageButton mVisibility;
    private TextView mText;
    private boolean isPasswordVisible;

    int setImage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.login,container,false);

        return mView;

        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSignIn=mView.findViewById(R.id.l_signin);
        mText = mView.findViewById(R.id.l_register);
        mVisibility=mView.findViewById(R.id.l_show_hide);
        mcontact= mView.findViewById(R.id.l_contact);
        mpassword=mView.findViewById(R.id.l_password);
        mSignIn.setOnClickListener(this);
        mText.setOnClickListener(this);
        mVisibility.setOnClickListener(this);
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
               // ((Aunthentication) getActivity()).loadFragment(R.id.fragment_lay,new RegisterFragment(),"Registration",true);
                Navigation.findNavController(mView).navigate(R.id.action_loginFragment_to_registerFragment);
            case R.id.l_show_hide:
                togglePassVisability();

        }
    }


    private boolean isValid() {


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

                if (!isPasswordVisible) {

                    mpassword.setTransformationMethod(new PasswordTransformationMethod());
                    mVisibility.setImageDrawable( ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.eye));
                }
                else
                {

                    mpassword.setTransformationMethod(null);
                    mVisibility.setImageDrawable( ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.visibility));
                }
                isPasswordVisible= !isPasswordVisible;


            }
        }











