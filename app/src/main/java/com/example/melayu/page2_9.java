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

public class page2_9 extends AppCompatActivity {

    private EditText editText9;
    private ListView listView9;
    private ArrayList<String> listv9;
    private ArrayAdapter<String> adapter9;
    String data[]={"  ดอกไม้  Bunga บูงา",
            "  ดอกชบา  Bunga raya บูงา รายา",
            "  ดอกกุหลาบ  Bunga mawar บูงามาวัร",
            "  ดอกทานตะวัน  Bunga matahari บูงามาตาฮารี",
            "  ดอกมะลิ  Bunga melur /Bunga Melati บูงาเมอลูร/บูงาเมอลาตี",
            "  ดอกกระดังงา  Bunga kenanga  บูงาเกอนางา",
            "  ดอกลิลลี่  Bunga bakung บูงาบากง",
            "  ดอกกระดาษ  Bunga kertas บูงาเกอตัส",
            "  ดอกเข็ม  Bunga jenjarum บูงาเยินยารม",
            "  ดอกบัว  Bunga teratai บูงาเตอราไต",
            "  ดอกหงอนไก่  Bunga balung ayam บูงา บาลงอายัม",
            "  ดอกลีลาวดี  Bunga kemboja บูงาเกิมโบยา",
            "  ดอกพิกุล  Bunga tanjung บูงาตันยง",
            "  ดอกจำปี  Bunga cempaka putih บูงาเจิมปากา ปูติฮ์",
            "  ดอกจำปา  Bunga cempaka บูงา เจิมปากา",
            "  ดอกราชพฤกษ์ ดอกคูน  Bunga kayu raja บูงากายู รายา",
            "  ดอกพลู  Bunga sirih บูงาซีริฮ์",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_9);
        listView9 = (ListView)findViewById(R.id.lstSeartch9);
        editText9 = (EditText)findViewById(R.id.edtSeartch9);
        initList1();
        editText9.addTextChangedListener(new TextWatcher() {
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
                listv9.remove(namews);
            }
        }
        adapter9.notifyDataSetChanged();
    }
    public void initList1(){
        listv9 = new ArrayList<>(Arrays.asList(data));
        adapter9 = new ArrayAdapter<String>(this,R.layout.layoutflw,R.id.listtext,listv9);
        listView9.setAdapter(adapter9);

    }
}