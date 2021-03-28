package com.bhola.bhola_kr_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fBtn;


    RecyclerView recyclerView;
    ArrayList<String> arrayList;
    LinearLayoutManager layoutManager;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fBtn=findViewById(R.id.f_btn);

        recyclerView=findViewById(R.id.rv_data);

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.fbtn_item);
                dialog.show();


                EditText et_title1=dialog.findViewById(R.id.et_title);
                Button btn_ok=dialog.findViewById(R.id.btn_ok);
                Button btn_cancel=dialog.findViewById(R.id.btn_cancel);

                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // final Dialog dialog1=new Dialog(MainActivity.this);
                        // dialog1.setContentView(R.layout.title_and_img);
                        //dialog1.show();
                        // title sending to the recycler
                        String  et_title=et_title1.getText().toString();
                         setRecycler();
                          dialog.dismiss();

                    }
                });

                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

            }
        });
    }

    public void setRecycler(){
        arrayList =new ArrayList<>();
        for (int i=0;i<=10; i++){
            arrayList.add("Group"+i);

        }
        imageAdapter=new ImageAdapter(MainActivity.this,arrayList);

        layoutManager =new LinearLayoutManager(this);

        // set layout manager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageAdapter);
    }
}