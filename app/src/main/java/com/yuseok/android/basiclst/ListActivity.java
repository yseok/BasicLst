package com.yuseok.android.basiclst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    String array[] = {"월", "화", "수", "목", "금", "토", "일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        // 1. 리스트뷰를 가져온다.
        listView = (ListView) findViewById(R.id.listView);


        /*
        //2. 아답터를 정의한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, array);
                //컨텍스트,             스피너에서 사용할 레이아웃,  배열 데이터
        */
        CustomAdapter adapter = new CustomAdapter(array, this);


        // 3. 리스트뷰에 아답터를 세팅한다.
        listView.setAdapter(adapter);


        // 4. 리스트뷰에 리스너를 달아준다.
        listView.setOnItemClickListener(listener);
    }

    // 리스너 생성
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override   // 아이템에 대한 아이디가 필요해서 들어가는 인자가 많다. 사용할건 포지션만 사용
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // 1. detail Activity로 전환하기 위한 intent생성
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);

            // 2. 넘길 데이터를 세팅하고
            intent.putExtra("no", position + 1);
            intent.putExtra("day", array[position]);

            // 3. 액티비티 호출
            startActivity(intent);
        }
    };
}