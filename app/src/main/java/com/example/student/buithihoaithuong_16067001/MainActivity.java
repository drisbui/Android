package com.example.student.buithihoaithuong_16067001;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtTK,txtMK;
    CheckBox cbox;
    Button btnDN,btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTK=(EditText)findViewById(R.id.txtTK);
        txtMK=(EditText)findViewById(R.id.txtMK);
        cbox=(CheckBox)findViewById(R.id.checkBox);
        btnDN=(Button)findViewById(R.id.btnDN);
        btnThoat=(Button)findViewById(R.id.btnThoat);

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str="";
                Toast toast;
                String a=txtTK.getText().toString(),b=txtMK.getText().toString();
                if(a.trim().length()==0||b.trim().length()==0)
                {
                    Toast toast1=Toast.makeText(MainActivity.this,"Vui lòng không để trống thông tin",Toast.LENGTH_SHORT);
                    toast1.show();
                    txtTK.setText("");
                    txtMK.setText("");
                }
                else {
                    if (cbox.isChecked() == true) {
                        str = "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn được lưu";
                    } else {
                        str = "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu";
                    }
                    toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thong bao");
                builder.setMessage("Bạn có muốn đăng xuất không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Không thoát được", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Đăng xuất", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

}
