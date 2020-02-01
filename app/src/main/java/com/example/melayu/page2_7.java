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

public class page2_7 extends AppCompatActivity {

    private EditText editText7;
    private ListView listView7;
    private ArrayList<String> listv7;
    private ArrayAdapter<String> adapter7;
    String data[]={"  ยานพาหนะ   Kenderaan    เกินเดอราอัน",
            "  จักรยาน    Basikal    บาซีกัล",
            "  จักรยานสามล้อ    Beca    เบจา",
            "  มอเตอร์ไซค์    Motosikal   โมโตซิกัล",
            "  รถยนต์    Kereta    เกอเรตา",
            "  รถบัส   Bas   บัส",
            "  รถบรรทุก   Lori   โลรี",
            "  รถดับเพลิง   Kereta bomba   เกอเรตา บมบา",
            "  รถพยาบาล   Ambolans   อัมโบลันส์",
            "  รถแท็กซี่   Teksi   เท็กซี่",
            "  รถไฟ   Kereta api   เกอเรตา อาปี",
            "  เครื่องบิน   Kapal terbang/Pesawat   กาปัล เติรบัง/เปอซาวัต",
            "  เรือเล็ก   Perahu   เปอราฮู",
            "  เรือเดินทะเล   Kapal   กาปัล",
            "  เรือบรรทุกน้ำมัน   Kapal tangki   กาปัล ตังกี",
            "  เรือดำน้ำ  Kapal selam   กาปัล เซอลัม",
            "  แพ   Rakit   ราเก็ต",
            "  ลดความเร็ว   Kurangkan laju   กูรังกัน ลายู",
            "  เดินทางเดียว (ทางวันเวย์)   Jalan sehala   ยาลัน เซอฮาลา",
            "  ป้ายหยุดรถบัส(ป้ายรถเมล์)   Perhentian bas  เปิรเฮินเตียน  บัส",
            "  สนามบิน   Lapangan terbang  ลาปางัน เติรบัง",
            "  สถานีรถไฟ   Stesen kereta api  สเตเซ็น เกอเรตา อาปี",
            "  สถานีขนส่งรถบัส   Hentian bas  เฮินเตียน บัส",
            "  ปั๊มน้ำมัน   Stesen petrol  สเตเซ็น เปโตรล",
            "  ท่าเรือ   Pelabuhan  เปอลาบูฮัน",
            "  สัญญาณไฟ   Lampu isyarat  ลัมปู อีชารัต",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_7);
        listView7 = (ListView)findViewById(R.id.lstSeartch7);
        editText7 = (EditText)findViewById(R.id.edtSeartch7);
        initList1();
        editText7.addTextChangedListener(new TextWatcher() {
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
                listv7.remove(namews);
            }
        }
        adapter7.notifyDataSetChanged();
    }
    public void initList1(){
        listv7 = new ArrayList<>(Arrays.asList(data));
        adapter7 = new ArrayAdapter<String>(this,R.layout.layoutcar,R.id.listtext,listv7);
        listView7.setAdapter(adapter7);

    }
}