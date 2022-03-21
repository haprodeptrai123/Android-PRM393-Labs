package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnFood;
    Button btnDrink;
    Button btnExit;
    TextView txtResult;
    TextView txtResult2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFood = (Button) findViewById(R.id.btnfood);
        btnDrink = (Button) findViewById(R.id.btndrink);
        btnExit = (Button) findViewById(R.id.btnExit);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtResult2 = (TextView) findViewById(R.id.txtResult2);

        Intent intent = getIntent();
        String drk = intent.getStringExtra("dk");
        String fd = intent.getStringExtra("fd");
        txtResult.setText(fd);
        txtResult2.setText(drk);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}