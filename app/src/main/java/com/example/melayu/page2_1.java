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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class page2_1 extends AppCompatActivity {

    private EditText editText1;
    private ListView listView1;
    private ArrayList<String> listv1;
    private ArrayAdapter<String> adapter1;
    String data[]={"  A  เอ  อา/อะ/อา",
            "  B  บี  บ",
            "  C  ซี  จ ",
            "  D  ดี  ด",
            "  E  อี  เออ/เอ",
            "  F  เอฟ  ฟ",
            "  G  จี  ฆ",
            "  H  เฮช  ฮ",
            "  I  ไอ  อี/อิ/อี",
            "  J  เญ  ญ",
            "  K  เค  ก",
            "  L  แอล  ล",
            "  M  เอ็ม  ม",
            "  N  เอ็น  น",
            "  O  โอ  โอ/โอ",
            "  P  พี  ป",
            "  Q  คิว  ก",
            "  R  อาร์  ร",
            "  S  เอส  ซ",
            "  T  ที  ต",
            "  U  ยู  อู/อุ/อู",
            "  V  วี  ว",
            "  W  ดับเบิลยู  ว",
            "  X  เอ็กซ์  ซ",
            "  Y  วาย  ย",
            "  Z  แซ็ด  ซ",
            "  Gh  เฆอ  ฆ",
            "  Kh  เคอ  ค",
            "  Ng  เงอ  ง",
            "  Ny  เยอ  ย(เสียง นาสิก)",
            "  Sy  เชอ  ช",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_1);
        listView1 = (ListView)findViewById(R.id.lstSeartch1);
        editText1 = (EditText)findViewById(R.id.edtSeartch1);
        initList1();
        editText1.addTextChangedListener(new TextWatcher() {
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
                listv1.remove(namews);
            }
        }
        adapter1.notifyDataSetChanged();
    }
    public void initList1(){
        listv1 = new ArrayList<>(Arrays.asList(data));
        adapter1 = new ArrayAdapter<String>(this,R.layout.layoutabc,R.id.listtext,listv1);
        listView1.setAdapter(adapter1);
    }
}