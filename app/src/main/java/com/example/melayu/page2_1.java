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
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(page2_1.this,"List"+position,Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent w1=new Intent(page2_1.this,page2a_1.class);
                    startActivity(w1);
                }
                if(position==1){
                    Intent w1=new Intent(page2_1.this,page2b_1.class);
                    startActivity(w1);
                }
                if(position==2){
                    Intent w1=new Intent(page2_1.this,page2c_1.class);
                    startActivity(w1);
                }
                if(position==3){
                    Intent w1=new Intent(page2_1.this,page2d_1.class);
                    startActivity(w1);
                }
                if(position==4){
                    Intent w1=new Intent(page2_1.this,page2e_1.class);
                    startActivity(w1);
                }
                if(position==5){
                    Intent w1=new Intent(page2_1.this,page2f_1.class);
                    startActivity(w1);
                }
                if(position==6){
                    Intent w1=new Intent(page2_1.this,page2g_1.class);
                    startActivity(w1);
                }
                if(position==7){
                    Intent w1=new Intent(page2_1.this,page2h_1.class);
                    startActivity(w1);
                }
                if(position==8){
                    Intent w1=new Intent(page2_1.this,page2i_1.class);
                    startActivity(w1);
                }
                if(position==9){
                    Intent w1=new Intent(page2_1.this,page2j_1.class);
                    startActivity(w1);
                }
                if(position==10){
                    Intent w1=new Intent(page2_1.this,page2k_1.class);
                    startActivity(w1);
                }
                if(position==11){
                    Intent w1=new Intent(page2_1.this,page2l_1.class);
                    startActivity(w1);
                }
                if(position==12){
                    Intent w1=new Intent(page2_1.this,page2m_1.class);
                    startActivity(w1);
                }
                if(position==13){
                    Intent w1=new Intent(page2_1.this,page2n_1.class);
                    startActivity(w1);
                }
                if(position==14){
                    Intent w1=new Intent(page2_1.this,page2o_1.class);
                    startActivity(w1);
                }
                if(position==15){
                    Intent w1=new Intent(page2_1.this,page2p_1.class);
                    startActivity(w1);
                }
                if(position==16){
                    Intent w1=new Intent(page2_1.this,page2q_1.class);
                    startActivity(w1);
                }
                if(position==17){
                    Intent w1=new Intent(page2_1.this,page2r_1.class);
                    startActivity(w1);
                }
                if(position==18){
                    Intent w1=new Intent(page2_1.this,page2s_1.class);
                    startActivity(w1);
                }
                if(position==19){
                    Intent w1=new Intent(page2_1.this,page2t_1.class);
                    startActivity(w1);
                }
                if(position==20){
                    Intent w1=new Intent(page2_1.this,page2u_1.class);
                    startActivity(w1);
                }
                if(position==21){
                    Intent w1=new Intent(page2_1.this,page2v_1.class);
                    startActivity(w1);
                }
                if(position==22){
                    Intent w1=new Intent(page2_1.this,page2w_1.class);
                    startActivity(w1);
                }
                if(position==23){
                    Intent w1=new Intent(page2_1.this,page2x_1.class);
                    startActivity(w1);
                }
                if(position==24){
                    Intent w1=new Intent(page2_1.this,page2y_1.class);
                    startActivity(w1);
                }
                if(position==25){
                    Intent w1=new Intent(page2_1.this,page2z_1.class);
                    startActivity(w1);
                }
                if(position==26){
                    Intent w1=new Intent(page2_1.this,page2gh_1.class);
                    startActivity(w1);
                }
                if(position==27){
                    Intent w1=new Intent(page2_1.this,page2kh_1.class);
                    startActivity(w1);
                }
                if(position==28){
                    Intent w1=new Intent(page2_1.this,page2ng_1.class);
                    startActivity(w1);
                }
                if(position==29){
                    Intent w1=new Intent(page2_1.this,page2ny_1.class);
                    startActivity(w1);
                }
                if(position==30){
                    Intent w1=new Intent(page2_1.this,page2sy_1.class);
                    startActivity(w1);
                }

            }
        });
    }
}