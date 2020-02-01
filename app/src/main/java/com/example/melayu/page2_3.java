package com.example.melayu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class page2_3 extends AppCompatActivity {

    private EditText editText3;
    private ListView listView3;
    private ArrayList<String> listv3;
    private ArrayAdapter<String> adapter3;
    String data[]={"  ผลไม้   Buah  บูวะฮ์",
            "  เชอร์รี่   Ceri  เชอรี",
            "  สตรอเบอร์รี่   Strawberi  สตรอเบอร์รี่",
            "  กล้วย   Pisang  ปิงสัง",
            "  มะนาว   Lemon  เลมอน",
            "  องุ่น   Anggur  อังกุร",
            "  ส้มโอ   Limau gedang  ลีมา กีดัง",
            "  แตงโม   Tembikai  ติมบีไก",
            "  สับปะรด   Nanas  นานัส",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_3);
        listView3 = (ListView)findViewById(R.id.lstSeartch3);
        editText3 = (EditText)findViewById(R.id.edtSeartch3);
        initList1();
        editText3.addTextChangedListener(new TextWatcher() {
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
                listv3.remove(namews);
            }
        }
        adapter3.notifyDataSetChanged();
    }
    public void initList1(){
        listv3 = new ArrayList<>(Arrays.asList(data));
        adapter3 = new ArrayAdapter<String>(this,R.layout.layoutfrt,R.id.listtext,listv3);
        listView3.setAdapter(adapter3);

    }
}