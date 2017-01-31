package com.yuseok.android.basiclst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView txtNo, txtDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtNo = (TextView) findViewById(R.id.txtNo);
        txtDay = (TextView) findViewById(R.id.txtDay);

        // 1. 리스트에서 넘어온 인텐트를 꺼낸다.
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 2. 넘어온 인텐트에서 특정 값을 타입에 맞춰서 꺼낸다.
        int no = bundle.getInt("no");

        String day = bundle.getString("day");
        // 3. 꺼낸 값을 위젯에 셋팅한다.
        txtNo.setText(no + "");
        txtDay.setText(day);
    }
}
