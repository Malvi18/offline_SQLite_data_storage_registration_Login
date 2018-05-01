package com.example.android_job_project.offlinestorage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android_job_project.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnSubmit;
    ListView lv;
    Context context;
    List<User> user;
    private User nuser = null;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        context=getActivity();
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        lv = view.findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nuser = user.get(position);
                etUsername.setText(nuser.getUsername());
                etPassword.setText(nuser.getPassword());
            }
        });
        btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        fetchdata();

        return view;
    }

    private void fetchdata() {
        UserDao userDao = new UserDao(getActivity());
        user = userDao.selectData();
        ArrayAdapter<User> userArrayAdapter=new ArrayAdapter<User>
                (getActivity(),android.R.layout.simple_list_item_1,user);
        lv.setAdapter(userArrayAdapter);
    }

    @Override
    public void onClick(View v) {
       UserDao userDao=new UserDao(getActivity());
       User user1=new User();
       user1.setUsername(etUsername.getText().toString());
       user1.setPassword(etPassword.getText().toString());

      int Count= (int) userDao.insertData(user1);

        if(Count>0){
            Toast.makeText(context, "Insert Data", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(context, "not", Toast.LENGTH_SHORT).show();
        }
        fetchdata();
    }
}
