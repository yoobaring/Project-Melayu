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

public class page2_6 extends AppCompatActivity {

    private EditText editText6;
    private ListView listView6;
    private ArrayList<String> listv6;
    private ArrayAdapter<String> adapter6;
    String data[]={"  0   kosong  โกซง",
            "  1   satu  ซาตู",
            "  2   dua ดูวา",
            "  3   tiga ตีกฺา",
            "  4   empat เอิมปัต",
            "  5   lima ลีมา",
            "  6   enam เออนัม",
            "  7   tujuh ตูจุฮ",
            "  8   lapan ลาปัน",
            "  9   sembilan เซิมบิลัน",
            "  10   sepuluh เซอปูลูห์",
            "  11   sebelas เซอเบอลัส",
            "  12   dua belas ดูวา เบอลัส",
            "  13   tiga belas ตีกฺา เบอลัส",
            "  14   empat belas เอิมปัต เบอลัส",
            "  15   lima belas ลีมา เบอลัส",
            "  16   enam belas เออนัม เบอลัส",
            "  17   tujuh   belas ตูจุฮ์ เบอลัส",
            "  18   lapan belas ลาปัน เบอลัส",
            "  19   sembilan  belas เซิมบิลัน เบอลัส",
            "  20   dua puluh ดูวา ปูลุฮ์",
            "  100  seratus เซอราตุส",
            "  1,000   seribu เซอรีบู",
            "  10,000   sepuluh ribu เซอปูลุห์ รีบู",
            "  100,000   seratus ribu เซอราตุส รีบู",
            "  1,000,000   sejuta เซอยฺตา",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_6);
        listView6 = (ListView)findViewById(R.id.lstSeartch6);
        editText6 = (EditText)findViewById(R.id.edtSeartch6);
        initList1();
        editText6.addTextChangedListener(new TextWatcher() {
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
                listv6.remove(namews);
            }
        }
        adapter6.notifyDataSetChanged();
    }
    public void initList1(){
        listv6 = new ArrayList<>(Arrays.asList(data));
        adapter6 = new ArrayAdapter<String>(this,R.layout.layoutnum,R.id.listtext,listv6);
        listView6.setAdapter(adapter6);

    }
}