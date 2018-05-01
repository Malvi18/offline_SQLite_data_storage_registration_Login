package com.example.android_job_project.offlinestorage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_job_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnSubmit;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        User user = new User();
        UserDao userDao=new UserDao(getActivity());
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userDao.findUser(user);
        if(user1.getUsername()!=null){
            Toast.makeText(getActivity(), "Login", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(), "not login", Toast.LENGTH_SHORT).show();
        }

        Fragment fragment=new PassDataFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.Frame_Layout,fragment).commit();
        Bundle bundle=new Bundle();
        bundle.putString("username",username);
        bundle.putString("password",password);
        fragment.setArguments(bundle);
    }
    }
