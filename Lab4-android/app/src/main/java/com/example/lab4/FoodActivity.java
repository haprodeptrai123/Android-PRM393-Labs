package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    TextView txtRs;
    Button btnB;
    Button btnPHN;
    Button btnBBH;
    Button btnMQ;
    Button btnHTSG;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        txtRs = (TextView) findViewById(R.id.txtResult);
        btnB = (Button) findViewById(R.id.btnBack);
        btnPHN = (Button) findViewById(R.id.btnPep);
        btnBBH = (Button) findViewById(R.id.btnHENI);
        btnMQ = (Button) findViewById(R.id.btnTG);
        btnHTSG = (Button) findViewById(R.id.btnBSG);
        Intent intent = getIntent();
        String drk = intent.getStringExtra("dk");
        btnPHN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drk==null){
                    Intent intent = new Intent(FoodActivity.this,DrinkActivity.class);
                    intent.putExtra("fd","Phở Hà Nội ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                    intent.putExtra("fd","Phở Hà Nội ");
                    intent.putExtra("dk",drk);
                    startActivity(intent);
                }

            }
        });

        btnBBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drk==null){
                    Intent intent = new Intent(FoodActivity.this,DrinkActivity.class);
                    intent.putExtra("fd","Bún bò Huế ");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                    intent.putExtra("fd","Bún bò Huế ");
                    intent.putExtra("dk",drk);
                    startActivity(intent);
                }

            }
        });

        btnMQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drk==null){
                    Intent intent = new Intent(FoodActivity.this,DrinkActivity.class);
                    intent.putExtra("fd","Mì Quảng ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                    intent.putExtra("fd","Mì Quảng ");
                    intent.putExtra("dk",drk);
                    startActivity(intent);
                }

            }
        });

        btnHTSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drk==null){
                    Intent intent = new Intent(FoodActivity.this,DrinkActivity.class);
                    intent.putExtra("fd","Hu tiếu Sài Gòn ");
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                    intent.putExtra("fd","Hu tiếu Sài Gòn ");
                    intent.putExtra("dk",drk);
                    startActivity(intent);
                }

            }
        });



        // Back Button
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
