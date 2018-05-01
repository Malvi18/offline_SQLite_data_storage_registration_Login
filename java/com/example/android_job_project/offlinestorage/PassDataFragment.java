package com.example.android_job_project.offlinestorage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android_job_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PassDataFragment extends Fragment {

     TextView txtUsername,txtPassword;
    public PassDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pass_data, container, false);
        txtUsername=view.findViewById(R.id.txtUsername);
        txtPassword=view.findViewById(R.id.txtPassword);

        Bundle bundle=getArguments();
        txtUsername.setText(String.valueOf(bundle.getString("username")));
        txtPassword.setText(String.valueOf(bundle.getString("password")));

        return view;
    }

}
