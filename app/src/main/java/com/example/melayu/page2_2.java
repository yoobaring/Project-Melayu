package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Arrays;

public class page2_2 extends AppCompatActivity {

    private EditText editText2;
    private ListView listView2;
    private ArrayList<String> listv2;
    private ArrayAdapter<String> adapter2;
    String data[]={"  A   อา/อะ",
                   "  E   เออ/เอ",
                   "  I   อี/อิ",
                   "  O   โอ",
                   "  U   อู/อุ",
                   "  Ai  ไอ",
                   "  Au  เอา",
                   "  Ia  เอีย",
                   "  Ua  อัว",
                   "  Iau  เอียว",
                   "  Oi  ออย",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_2);
        listView2 = (ListView)findViewById(R.id.lstSeartch2);
        editText2 = (EditText)findViewById(R.id.edtSeartch2);
        initList1();
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    //reset listview
                    initList1();
                }
                else {
                    //perform search
                    searchItem1(s.toString());

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // perform search

            }
        });
    }

    public void searchItem1(String textToSearch){
        for (String namews:data){
            if(!namews.contains(textToSearch)){
                listv2.remove(namews);
            }
        }
        adapter2.notifyDataSetChanged();
    }
    public void initList1(){
        listv2 = new ArrayList<>(Arrays.asList(data));
        adapter2 = new ArrayAdapter<String>(this,R.layout.layoutabcd,R.id.listtext,listv2);
        listView2.setAdapter(adapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(page2_2.this,"List"+position,Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent w1=new Intent(page2_2.this,page2a_2.class);
                    startActivity(w1);
                }
                if(position==1){
                    Intent w1=new Intent(page2_2.this,page2e_2.class);
                    startActivity(w1);
                }
                if(position==2){
                    Intent w1=new Intent(page2_2.this, page2i_2.class);
                    startActivity(w1);
                }
                if(position==3){
                    Intent w1=new Intent(page2_2.this,page2o_2.class);
                    startActivity(w1);
                }
                if(position==4){
                    Intent w1=new Intent(page2_2.this, page2u_2.class);
                    startActivity(w1);
                }
                if(position==5){
                    Intent w1=new Intent(page2_2.this,page2ai_2.class);
                    startActivity(w1);
                }
                if(position==6){
                    Intent w1=new Intent(page2_2.this,page2au_2.class);
                    startActivity(w1);
                }
                if(position==7){
                    Intent w1=new Intent(page2_2.this, page2ia_2.class);
                    startActivity(w1);
                }
                if(position==8){
                    Intent w1=new Intent(page2_2.this, page2ua_2.class);
                    startActivity(w1);
                }
                if(position==9){
                    Intent w1=new Intent(page2_2.this,page2iau_2.class);
                    startActivity(w1);
                }
                if(position==10){
                    Intent w1=new Intent(page2_2.this,page2oi_2.class);
                    startActivity(w1);
                }
            }
        });

    }
}