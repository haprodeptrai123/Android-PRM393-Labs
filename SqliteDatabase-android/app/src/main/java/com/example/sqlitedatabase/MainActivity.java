package com.example.sqlitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Database database;
ListView lvCongViec;
ArrayList<CongViec> arrayCongViec;
CongViecAdapter adapter;
    private void GetDataCongViec() {
        Cursor dataCongViec= database.GetData("Select * from CongViec");
        arrayCongViec.clear();
        while (dataCongViec.moveToNext()){
            String ten= dataCongViec.getString(1);
            int id= dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuAdd){
            DialogThem();
        }
        return super.onOptionsItemSelected(item);

    }
public void DialogSuaCongViec(String ten,int id){
Dialog dialog=new Dialog(this);
dialog.setContentView(R.layout.dialog_sua);
EditText edtTenCV=(EditText) dialog.findViewById(R.id.editTextTenCVedit);
Button btnXacNhan=(Button)  dialog.findViewById(R.id.buttonSua);
Button btnHuy=(Button)  dialog.findViewById(R.id.buttonHuyedit);
edtTenCV.setText(ten);
btnXacNhan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String tenMoi=edtTenCV.getText().toString().trim();
        database.QueryData("UPDATE CongViec SET tenCV = '"+ tenMoi+ "' WHERE id='"+id+"'");
        Toast.makeText(MainActivity.this, "Đã cập nhật!", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        GetDataCongViec();
    }
});
btnHuy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialog.dismiss();
    }
});
dialog.show();
}
    private void DialogThem(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_cong_viec);

        EditText edtTen=(EditText) dialog.findViewById(R.id.editTextTenCV);
        Button btnThem=(Button) dialog.findViewById(R.id.buttonThem);
        Button btnHuy=(Button) dialog.findViewById(R.id.buttonHuy);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tencv=edtTen.getText().toString();
                if(tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show();
                }else{
                    database.QueryData("Insert into CongViec values(null,'"+tencv+"')");
                    Toast.makeText(MainActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }

            }


        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec=(ListView)findViewById(R.id.listviewCongViec);
        arrayCongViec   =new ArrayList<>();
        adapter=new CongViecAdapter(this,R.layout.activity_dong_cong_viec,arrayCongViec);
        lvCongViec.setAdapter(adapter);

        database =new Database(this,"Ghichu.sqLite",null,1);
        database.QueryData("Create table if not exists CongViec(id Integer Primary Key Autoincrement,"+"TenCV nvarchar(200))");
        database.QueryData("Insert into CongViec values(null,'Project Android')");
        database.QueryData("Insert into CongViec values(null,'Design app')");

        Cursor dataCongViec =database.GetData("Select * from CongViec");
        while(dataCongViec.moveToNext()){
            String ten= dataCongViec.getString(1);
//            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            int id= dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id,ten));
        }
            adapter.notifyDataSetChanged();

    }

    public void DialogXoaCongViec(String tencv, int id) {
        AlertDialog.Builder dialogXoa =new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa công việc này không?");
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM CongViec WHERE Id= '"+ id+ "' ");
                Toast.makeText(MainActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();

    }
}