package com.yuseok.android.basiclst;

import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    Button btnList, btnHolder, btnRecycler, btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button)findViewById(R.id.btnList);
        btnHolder= (Button) findViewById(R.id.btnHolder);
        btnRecycler = (Button) findViewById(R.id.btnRecycle);
        btnCard = (Button) findViewById(R.id.btnCard);

        btnList.setOnClickListener(Listener);
        btnHolder.setOnClickListener(Listener);
        btnRecycler.setOnClickListener(Listener);
        btnCard.setOnClickListener(Listener);
    }


    // 1, 리스너를 정의한다
    View.OnClickListener Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent;

            switch (v.getId()) {
                case R.id.btnList:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnHolder:
                    intent = new Intent(MainActivity.this, ListHolderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnRecycle:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnCard:
                    intent = new Intent(MainActivity.this, RecyclerCardActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}

