package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentB extends Fragment {
        TextView txtB;
        EditText edtB;
        Button btnB;

@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= (View) inflater.inflate(R.layout.fragment_b,container,false);
        txtB=(TextView) view.findViewById(R.id.fragmentB);
        edtB=(EditText) view.findViewById(R.id.edtB);
        btnB=(Button) view.findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),edtB.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
return view;

    }
}