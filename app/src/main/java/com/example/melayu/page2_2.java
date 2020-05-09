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
    int images[] = {R.drawable.icon,R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
    String data[]={"  A   อา/อะ", "  E   เออ/เอ", "  I   อี/อิ", "  O   โอ", "  U   อู/อุ", "  Ai  ไอ", "  Au  เอา", "  Ia  เอีย", "  Ua  อัว", "  Iau  เอียว", "  Oi  ออย",};
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

    }
}