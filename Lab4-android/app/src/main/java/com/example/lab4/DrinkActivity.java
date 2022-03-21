package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkActivity extends AppCompatActivity {


    TextView txtRs;
    Button btnB;
    Button btnPep;
    Button btnhn;
    Button btnTG;
    Button btnBSG;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        txtRs = (TextView) findViewById(R.id.txtResult);
        btnB = (Button) findViewById(R.id.btnBack);
        btnPep = (Button) findViewById(R.id.btnPepsi);
        btnhn = (Button) findViewById(R.id.btnHeniken);
        btnTG = (Button) findViewById(R.id.btnTiger);
        btnBSG = (Button) findViewById(R.id.btn333);
        //Id Decl

        Intent intent = getIntent();
        String fd = intent.getStringExtra("fd");




        btnPep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fd==null){
                    Intent intent = new Intent(DrinkActivity.this,FoodActivity.class);
                    intent.putExtra("dk","Pepsi ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                    intent.putExtra("dk","Pepsi ");
                    intent.putExtra("fd",fd);
                    startActivity(intent);
                }

            }
        });

        btnhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fd==null){
                    Intent intent = new Intent(DrinkActivity.this,FoodActivity.class);
                    intent.putExtra("dk","HeniKen ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                    intent.putExtra("dk","HeniKen ");
                    intent.putExtra("fd",fd);
                    startActivity(intent);
                }

            }
        });

        btnTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fd==null){
                    Intent intent = new Intent(DrinkActivity.this,FoodActivity.class);
                    intent.putExtra("dk","Tiger ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                    intent.putExtra("dk","Tiger ");
                    intent.putExtra("fd",fd);
                    startActivity(intent);
                }

            }
        });

        btnBSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fd==null){
                    Intent intent = new Intent(DrinkActivity.this,FoodActivity.class);
                    intent.putExtra("dk","333 ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                    intent.putExtra("dk","333 ");
                    intent.putExtra("fd",fd);
                    startActivity(intent);
                }

            }
        });

        // Back Button
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinkActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });





    }


}
