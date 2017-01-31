package com.yuseok.android.basiclst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by YS on 2017-01-31.
 */

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater; // 전역변수
    String datas[];

    // 생성자 재설정
    public CustomAdapter(String datas[], Context context) { // 시스템 자원함수가 많이 정의되어있는 객체. 시스템마다 context가 다르다.
        // context로 startActivity가 가능하다.

        // getView 함수에서 사용할 xml 레이아웃을 객체로 변환해주는 inflater를 가져온다.
       inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE); // xml파일을 메모리에 올리기 위해서는 자바 코드로 바뀐다.
        // Inflaster는 xml을 자바코드로 변환해주는 역할을 한다.

        this.datas = datas; // 전역변수와 지역변수가 겹치면 지역변수 앞에 this를 붙여 구분

    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }

    /** 선택된 리스트 아이템
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**아이템의 인덱스 값
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 리스트 아답터에서 뷰는 한 행 단위이다.
    // 한 행 단위를 개발자가 직접 만들어서 시스템에 넘겨줘야 한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        // 1. 한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어준다.
        if(convertView == null);
        View view = inflater.inflate(R.layout.list_item, null);
        // 2. inflate된 뷰를 통해서 findViewById함수를 사용한다.
        TextView txtNum = (TextView) view.findViewById(R.id.txtNum);
        TextView txtDay = (TextView) view.findViewById(R.id.txtDay);

        // 3. inflast된 뷰의 위젯으ㅔ 값을 세팅한다.
        txtNum.setText((position + 1) + "");
        txtDay.setText(datas[position]);

        // 4. 완성된 한행의 뷰를 시스템에 넘겨준다.
        return view;
        */

        // 1. 한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어준다.
        if(convertView == null){ // 한번 화면에 셋팅됐던 행은 convertView에 담겨져서 돌아온다.
        convertView = inflater.inflate(R.layout.list_item, null); }
        // 2. inflate된 뷰를 통해서 findViewById함수를 사용한다.
        TextView txtNum = (TextView) convertView.findViewById(R.id.txtNum);
        TextView txtDay = (TextView) convertView.findViewById(R.id.txtDay);

        // 3. inflast된 뷰의 위젯으ㅔ 값을 세팅한다.
        txtNum.setText((position + 1) + "");
        txtDay.setText(datas[position]);

        // 4. 완성된 한행의 뷰를 시스템에 넘겨준다.
        return convertView;
    }
}
