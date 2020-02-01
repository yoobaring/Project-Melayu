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

public class page2_10 extends AppCompatActivity {

    private EditText editText10;
    private ListView listView10;
    private ArrayList<String> listv10;
    private ArrayAdapter<String> adapter10;
    String data[]={"  สามี  Suami ซูอามี",
            "  ภรรยา  isteri อิสเตอรี",
            "  ลูก  anak อานะคฺ ",
            "  คนโต (ก่อน แรก เริ่ม)  Sulung ซูลุง ",
            "  คนกลาง(กลาง)  tengah เตองา",
            "  คนสุดท้าย  bongsu บงสุ ",
            "  ผู้ชาย(สุภาพบุรุษ)  Lelaki เลอลากี ",
            "  ผู้หญิง(สุภาพสตรี)  perempuan เปอเริมปวน",
            "  ลูกชาย  Anak lelagi อะนะคฺ เลอลากี",
            "  ลูกสาว  anak perempuan อะนะคฺ เปอเริมปวน",
            "  พ่อ  pak ปะคฺ",
            "  แม่  mak มะคฺ",
            "  พี่ชาย  Abang อะบัง ",
            "  พี่สาว  kakak กากะคฺ ",
            "  พี่,น้อง เขย สะใภ้  ipar อิปาร",
            "  ลูกเขย ลูกสะใภ้  Menantu เมอนันตู",
            "  ปู่,ตา  datuk ดาตุ๊คฺ",
            "  ย่า,ยาย  nenek เนเนคฺ",
            "  หลาน(ลูกของลูก)  Cucu  จูจู",
            "  หลาน  anak saudara อานะคฺ เซาดารา",
            "  หลาน(ภาษาปาก)  anak buah อานะคฺ บูวะฮ",
            "  ป้า,น้า,อา  Emak saudara เออมะคฺ เซาดารา",
            "  ลุง,น้า,อา  bapa saudara บาปา เซาดารา",
            "  แม่บ้าน(ภรรยา)  Suri rumahtangga ซูรี รูมะตังกะ",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_10);
        listView10 = (ListView)findViewById(R.id.lstSeartch10);
        editText10 = (EditText)findViewById(R.id.edtSeartch10);
        initList1();
        editText10.addTextChangedListener(new TextWatcher() {
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
                listv10.remove(namews);
            }
        }
        adapter10.notifyDataSetChanged();
    }
    public void initList1(){
        listv10 = new ArrayList<>(Arrays.asList(data));
        adapter10 = new ArrayAdapter<String>(this,R.layout.layoutfamly,R.id.listtext,listv10);
        listView10.setAdapter(adapter10);

    }
}