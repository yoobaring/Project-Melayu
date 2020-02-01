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

public class page2_8 extends AppCompatActivity {

    private EditText editText8;
    private ListView listView8;
    private ArrayList<String> listv8;
    private ArrayAdapter<String> adapter8;
    String data[]={" เสื้อผ้า  Pakaian ปาไกอัน",
            "  เสื้อ  Baju บายู",
            "  เสื้อสำหรับผู้ชายที่เป็นชุดประจำชาติมาเลเซีย  Baju Melayu บายูมลายู",
            "  เสื้อสำหรับผู้หญิงที่เป็นชุดประจำชาติมาเลเซีย  Baju kurung บายูกูรง",
            "  เสื้อกันฝน  Baju hujan บายูฮูยัน",
            "  เสื้อกันหนาว  Baju sejuk บายูเซอยุก",
            "  เสื้อคลุมยาว  Jubah ยูบะห์",
            "  เสื้อเชิ้ต  Kemeja เกอเมยา",
            "  เสื้อยืด  Kemeja-T เกอเมยา-ที",
            "  เสื้อกล้าม  Singlet ซิงเลต",
            "  เสื้อฟุตบอล  Jersi เยอซี่",
            "  กางเกงขาสั้น  Seluarpendek เซอลัวร์เปนดิก",
            "  กางเกงขายาว  Seluarpanjang เซอลัวร์ปันยัง",
            "  กางเกงใน  Seluardalam เซอลัวร์ดาลัม",
            "  ผ ้าโสร่ง  Kainsarung ไกน์ซารง",
            "  ผ้าคลุมผมของผู้หญิงอิสลาม  Hijab ฮิญาบ",
            "  หมวก  Topi โตปี",
            "  หมวกหนีบอินโดนีเซีย  Songkok ซงโกก",
            "  หมวกที่ใส่ละหมาด  Kopiah โกเปียะห์",
            "  รองเท้า  Kasut กาซูต",
            "  รองเท้าแตะ  Selipar เซอลีปัร",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_8);
        listView8 = (ListView)findViewById(R.id.lstSeartch8);
        editText8 = (EditText)findViewById(R.id.edtSeartch8);
        initList1();
        editText8.addTextChangedListener(new TextWatcher() {
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
                listv8.remove(namews);
            }
        }
        adapter8.notifyDataSetChanged();
    }
    public void initList1(){
        listv8 = new ArrayList<>(Arrays.asList(data));
        adapter8 = new ArrayAdapter<String>(this,R.layout.layoutclot,R.id.listtext,listv8);
        listView8.setAdapter(adapter8);

    }
}