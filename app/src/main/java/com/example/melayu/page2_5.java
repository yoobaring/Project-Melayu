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

public class page2_5 extends AppCompatActivity {

    private EditText editText5;
    private ListView listView5;
    private ArrayList<String> listv5;
    private ArrayAdapter<String> adapter5;
    String data[]={"  พนักงานดับเพลิง   Ahli bomba  อะฮ์ลีโบมบา",
            "  ทหาร   Askar  อัซการ์",
            "  หมอหรือแพทย์   Doctor  ดอกโตร",
            "  นางพยาบาล   Jururawat  จูรูราวัต",
            "  พ่อค้าหรือแม่ค้า   Jurujual  จูรูจูวัล",
            "  นักถ่ายภาพ   Jurugambar  จูรูฆัมบัร",
            "  ล่าม  Jurubahasa  จูรูบาฮาซา",
            "  นักการเงิน   Juruwang  จูรูวัง",
            "  อาจารย์   Pensyarah  เปินชาระฮ์",
            "  ข้าราชการ   Pengawai kerajaan  เปอฆาวัย เกอร์ราจาอัน",
            "  นักวาดภาพ   Pelukis  เปอลูกิส",
            "  เกษตรกร  Petani  เปอตานี",
            "  ชาวนา   Pesawah  เปอซาวะห์",
            "  ชาวสวน   Pekebun  เปอเกอบูน",
            "  คนกรีดยาง   Penoreh getah  เปอนูเระฮ์ เฆอตะห์",
            "  พนักงานบริการ   Pelayan  เปอลายัน",
            "  นักร้อง   Penyanyi  เปอญาญี",
            "  ทนาย   Peguam  เปอฆูวัม",
            "  ตำรวจ   Polis  โปลิซ",
            "  บุรุษไปรษณีย์   Posmen  โปสเมน",
            "  ช ่างยนต์   Mekanik  เมกานิก",
            "  ชาวประมง   Nelayan  เนอลายัน",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_5);
        listView5 = (ListView)findViewById(R.id.lstSeartch5);
        editText5 = (EditText)findViewById(R.id.edtSeartch5);
        initList1();
        editText5.addTextChangedListener(new TextWatcher() {
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
                listv5.remove(namews);
            }
        }
        adapter5.notifyDataSetChanged();
    }
    public void initList1(){
        listv5 = new ArrayList<>(Arrays.asList(data));
        adapter5 = new ArrayAdapter<String>(this,R.layout.layoutcareer,R.id.listtext,listv5);
        listView5.setAdapter(adapter5);

    }
}