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

public class FragmentA extends Fragment {

    TextView txtA;
    EditText edtA;
    Button btnA;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= (View) inflater.inflate(R.layout.fragment_a,container,false);

       txtA=(TextView) view.findViewById(R.id.txtA);
       edtA =(EditText) view.findViewById(R.id.edtA);
       btnA =(Button) view.findViewById(R.id.btnA);
       btnA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getActivity(), edtA.getText().toString(), Toast.LENGTH_SHORT).show();
           }
       });
       return view;
    }
public void gannoidung(String noidung){
        txtA.setText(noidung);
}

}