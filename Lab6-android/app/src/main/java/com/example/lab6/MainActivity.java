package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
Button btnMenu;
Button btnChonMau;
ConstraintLayout manHinh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChonMau=(Button) findViewById(R.id.button_Chonmau);
        manHinh=(ConstraintLayout) findViewById(R.id.manHinh);
        registerForContextMenu(btnChonMau);



        btnMenu=(Button) findViewById(R.id.buttonMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });
    }

    private void showMenu(){
        PopupMenu popupMenu=new PopupMenu(this,btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menuThem: btnMenu.setText("Menu Them");
                    break;
                    case R.id.menuSua:  btnMenu.setText("Menu Sua");
                    break;
                    case R.id.menuXoa: btnMenu.setText("Menu xoa");
                    break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuDo: manHinh.setBackgroundColor(Color.RED);
            break;
            case R.id.menuVang:manHinh.setBackgroundColor(Color.YELLOW);
            break;
            case R.id.menuXanh: manHinh.setBackgroundColor(Color.BLUE);
            break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mExit:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}