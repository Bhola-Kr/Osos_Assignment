package com.bhola.bhola_kr_assignment;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Activity activity;
    ArrayList<String> arrayList;

    public ImageAdapter(Activity activity, ArrayList<String> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_list,parent,false);

        return new ImageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // name setup

        holder.tv_title_card.setText(arrayList.get(position));

        // adding multiple member

        ArrayList<String> arrayList=new ArrayList<>();
        for (int i=1; i<=4; i++){
            arrayList.add("Member"+i);
        }
        MemberAdapter memberAdapter=new MemberAdapter(arrayList);
        LinearLayoutManager layoutManagerMember=new LinearLayoutManager(activity);
        // set layout manager

        holder.rv_card.setLayoutManager(layoutManagerMember);

        // set Adapter

        holder.rv_card.setAdapter(memberAdapter);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title_card;
        ImageView iv_card;
        RecyclerView rv_card;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title_card=itemView.findViewById(R.id.tv_card);
            iv_card=itemView.findViewById(R.id.iv_card);
            rv_card=itemView.findViewById(R.id.rv_card);



        }

    }

}
