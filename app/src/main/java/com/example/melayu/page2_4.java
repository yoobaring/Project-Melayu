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

public class page2_4 extends AppCompatActivity {

    private EditText editText4;
    private ListView listView4;
    private ArrayList<String> listv4;
    private ArrayAdapter<String> adapter4;
    String data[]={"  สิงโต   Singa  ซิงา",
                   "  เสือ   Harimau  ฮารีเมา",
                   "  กวาง   Rusa  รูซา",
                   "  ช้าง   Gajah  ฆายะฮ์",
                   "  กระจง   Kencil  เกินจีล",
                   "  ควาย   Kerbau  เกิรเบา",
                   "  วัว   Lembu  เลิมบู",
                   "  ม้า   Kuda  กูดา",
                   "  แพะ   Kambing  กัมบิง",
                   "  แกะ   Biri-biri  บีรี-บีรี",
                   "  ห่าน   Angsa  อังซา",
                   "  ไก่   Ayam  อายัม",
                   "  เป็ด  Itik  อีติก",
                   "  กระต่าย   Arnab  อัรนับ",
                   "  ลา   Keldai  เกิลได",
                   "  จระเข้   Buaya  บัวยา",
                   "  เต่า   Kura  กูรา",
                   "  หมา   Anjing  อันยิง",
                   "  หมู   Babi  บาบี",
                   "  แมว   Kucing  กูจิง",
                   "  หนู  Tikus  ตีกุส",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_4);
        listView4 = (ListView)findViewById(R.id.lstSeartch4);
        editText4 = (EditText)findViewById(R.id.edtSeartch4);
        initList1();
        editText4.addTextChangedListener(new TextWatcher() {
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
                listv4.remove(namews);
            }
        }
        adapter4.notifyDataSetChanged();
    }
    public void initList1(){
        listv4 = new ArrayList<>(Arrays.asList(data));
        adapter4 = new ArrayAdapter<String>(this,R.layout.layoutanm,R.id.listtext,listv4);
        listView4.setAdapter(adapter4);

    }
}