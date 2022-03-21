package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.TraineeRepository;
import api.TraineeService;
import model.Trainee;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TraineeService traineeService;
EditText etname,etemail,etphone,etgioitinh;
Button btnSave,btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=findViewById(R.id.etTen);
        etemail=findViewById(R.id.etEmail);
        etgioitinh=findViewById(R.id.etGender);
        etphone=findViewById(R.id.etPhone);
        btnSave=findViewById(R.id.btnSave);
        btnView=findViewById(R.id.btnView);
        btnSave.setOnClickListener(this);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
            }
        });
        traineeService= TraineeRepository.getTraineeService();
    }
    private void save(){
        String name= etname.getText().toString();
        String email=etemail.getText().toString();
        String phone=etphone.getText().toString();
        String gender=etgioitinh.getText().toString();

        Trainee trainee=new Trainee(name,email,phone,gender);
        try{
            Call<Trainee> call=traineeService.createTrainees(trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() !=null){
                        Toast.makeText(MainActivity.this, "Save successfully", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Save fail", Toast.LENGTH_LONG).show();
                }
            });
        }catch (Exception e){
            Log.d("Lỗi",e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
        save();
    }

}