package com.example.android_job_project.offlinestorage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import com.example.android_job_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {


    public BlankFragment() {
        // Required empty public constructor
    }

    Button btnSignIn, btnSignUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        btnSignIn = view.findViewById(R.id.btnSignIn);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                Fragment fragment = new LoginFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Frame_Layout, fragment)
                        .commit();
                break;

            case R.id.btnSignUp:
                Fragment fragment1 = new RegistrationFragment();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Frame_Layout, fragment1)
                        .commit();
                break;
        }
    }
}
