package com.phong.hoctabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    EditText edtUser, edtPassword;
    Button btnLogin, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                //s ở trên chính là id
                if (s.equals("t1"))
                {
                    Toast.makeText(MainActivity.this,
                            "Bạn chọn tab Đăng Nhập!",
                            Toast.LENGTH_SHORT).show();
                }
                else if (s.equals("t2"))
                {
                    Toast.makeText(MainActivity.this,
                            "Bạn chọn tab Hướng dẫn!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyDangNhap();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void XuLyDangNhap() {
        Toast.makeText(MainActivity.this, "User name: " + edtUser.getText().toString()
        + ";Password: " + edtPassword.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    private void addControls() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        //Cài TabHost:
        tabHost.setup();//Lấy tabhost ra

        //Tạo đối tượng 1 tab, có id là t1:
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");//id
        //Thiết lập nội dung layout:
        tab1.setContent(R.id.tab1);
        //Thiết lập tiêu đề cho tab:
        //tab1.setIndicator("Đăng nhập");
        tab1.setIndicator("",getResources().getDrawable(R.drawable.login));//Chỉ lấy hình hoặc chữ
        //Đẩy tab1 vào TabHost:
        tabHost.addTab(tab1);

        //Tạo đối tượng 1 tab, có id là t2:
        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");//id
        //Thiết lập nội dung layout:
        tab2.setContent(R.id.tab2);
        //Thiết lập tiêu đề cho tab:
        //tab2.setIndicator("Hướng dẫn");
        tab2.setIndicator("",getResources().getDrawable(R.drawable.help));
        //Đẩy tab2 vào TabHost:
        tabHost.addTab(tab2);

        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
    }
}
