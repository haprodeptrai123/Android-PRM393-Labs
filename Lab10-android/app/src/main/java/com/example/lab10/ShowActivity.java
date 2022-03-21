package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import api.TraineeRepository;
import api.TraineeService;
import model.Trainee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowActivity extends AppCompatActivity {
    TraineeService traineeService;
    Spinner spTrainee;
    ArrayList<Long> alId;
    ArrayList<String>alName,alEmail,alPhone,alGender;
    Button btnLoad,btnUpdate,btnDelete;
    EditText tvName,tvEmail,tvPhone,tvGender;
    int count = 1;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tvName=(EditText) findViewById(R.id.edtName);
        tvEmail=(EditText) findViewById(R.id.edtEmail);
        tvPhone=(EditText) findViewById(R.id.edtPhone);
        tvGender=(EditText) findViewById(R.id.edtGender);
        btnLoad=(Button) findViewById(R.id.btnLoad);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnUpdate=(Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spTrainee.setAdapter(null);
                alId.clear();
                alName.clear();
                alEmail.clear();
                alPhone.clear();
                alGender.clear();
                Update(tvName.getText().toString(),tvEmail.getText().toString(),tvPhone.getText().toString(),tvGender.getText().toString());
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spTrainee.setAdapter(null);
                alId.clear();
                Delete();
                View();
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spTrainee.setAdapter(null);
                alId.clear();
                View();
//                switch(view.getId()) {
//                    case R.id.btnLoad:
//                        count--;
//                        btnLoad.setEnabled(false);
//                        break;
//                    }
            }
        });
        spTrainee=(Spinner) findViewById(R.id.spinner);
        alId=new ArrayList<>();
        alName=new ArrayList<>();
        alEmail=new ArrayList<>();
        alPhone=new ArrayList<>();
        alGender=new ArrayList<>();
        traineeService= TraineeRepository.getTraineeService();

    }
    private void View(){
        Call<Trainee[]> call=traineeService.getAllTrainees();
        call.enqueue(new Callback<Trainee[]>() {
            @Override
            public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                Trainee[] trainees= response.body();
                if(trainees==null){
                    return;
                }
                for (Trainee trainee:trainees){
                    alId.add(trainee.getId());
                    alName.add(trainee.getName());
                    alEmail.add(trainee.getEmail());
                    alPhone.add(trainee.getPhone());
                    alGender.add(trainee.getGender());
                }
                ArrayAdapter adapter=new ArrayAdapter(ShowActivity.this,android.R.layout.simple_spinner_dropdown_item,alId);
                spTrainee.setAdapter(adapter);
                spTrainee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        tvName.setText(alName.get(i));
                        tvEmail.setText(alEmail.get(i));
                        tvPhone.setText(alPhone.get(i));
                        tvGender.setText(alGender.get(i));
                        vitri=i;
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Trainee[]> call, Throwable t) {

            }
        });
    }


private void Update(String name, String email,String phone,String gender){
        long traineeId=vitri+1;
        Trainee trainee = new Trainee(name,email,phone,gender);
        Call<Trainee>call=traineeService.updateTrainees(traineeId,trainee);
        call.enqueue(new Callback<Trainee>() {
            @Override
            public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                if(response.body()!=null){
                    Toast.makeText(ShowActivity.this, "Update successfully", Toast.LENGTH_LONG).show();
                    View();
                }
            }

            @Override
            public void onFailure(Call<Trainee> call, Throwable t) {
                Toast.makeText(ShowActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        });
}

        private void Delete(){
            long TraineeId=vitri+1;
                Call<Trainee> call=traineeService.deleteTrainee(TraineeId);
                call.enqueue(new Callback<Trainee>() {
                    @Override
                    public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                        if(response.body()!=null){
                            Toast.makeText(ShowActivity.this, "Delete successfully", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Trainee> call, Throwable t) {

                    }
                });

        }

}