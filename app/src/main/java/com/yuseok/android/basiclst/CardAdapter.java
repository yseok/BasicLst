package com.yuseok.android.basiclst;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YS on 2017-01-31.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {

    ArrayList<User> datas;
    Context context; // 클릭처리, 애니메이션 등을 위해 시스템 자원 사용이 필요

    public CardAdapter(ArrayList<User> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    // View를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item,parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;

    }

    // listView 에서의 getView() 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final User user = datas.get(position);
        // 앞으로 변경사항이 없을 때 final을 붙여준다.

        holder.txtid.setText(user.id + "");
        holder.txtname.setText(user.name);
        holder.txtage.setText(user.age + "");

        // cardView에 click 리스너를 달아서 동작시킨다.
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.id);
                intent.putExtra("day", user.name); // 객체 밖에것을 참조할때 변경사항이 있으면 안된다.

                context.startActivity(intent);
            }
        });

        // cardView 애니메이션
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.cardView.setAnimation(animation);

    }

    /*
    // listView에서의 getView를 대체하는 함수
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    */

    // 데이터 총 갯수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    // Recycler 뷰에서 사용하는 뷰홀더
    // 이 뷰홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtname, txtage;
        CardView cardView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            txtid = (TextView) itemView.findViewById(R.id.txtId);
            txtname = (TextView) itemView.findViewById(R.id.txtName);
            txtage = (TextView) itemView.findViewById(R.id.txtAge);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
