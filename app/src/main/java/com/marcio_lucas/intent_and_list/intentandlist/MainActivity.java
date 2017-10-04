package com.marcio_lucas.intent_and_list.intentandlist;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] itens = new String[]{"Uma Activity", "Google.com", "Ligar pra mim mesmo", "Abrir contato mamãe", "Ir para o bosque"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,itens);
        ListView lv = (ListView) findViewById(R.id.lista);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
//
                        Intent i0 = new Intent(MainActivity.this, OutraActivity.class);
                        startActivity(i0);
                        break;

                    case 1:
                        Uri url = Uri.parse("https://www.google.com");
                        Intent i1 = new Intent(Intent.ACTION_VIEW, url);
                        if(i1.resolveActivity(getPackageManager()) != null){
                            startActivity(i1);
                        }
                        break;

                    case 2:
                        Uri cell = Uri.parse("tel://992658429");
                        Intent i2 = new Intent(Intent.ACTION_CALL, cell);
                        if(i2.resolveActivity(getPackageManager()) != null){
                            startActivity(i2);
                        }
                        break;
                    case 3:
                        Uri mamae = Uri.parse("content://com.android.contacts/contacts/1");
                        Intent i3 = new Intent(Intent.ACTION_VIEW, mamae);
                        if(i3.resolveActivity(getPackageManager()) != null){
                            startActivity(i3);
                        }
                        break;

                    case 4:
                        Uri map = Uri.parse("geo:-17.8123505, -49.2039571");
                        Intent i4 = new Intent(Intent.ACTION_VIEW, map);
                        if(i4.resolveActivity(getPackageManager()) != null){
                            startActivity(i4);
                        }
                        break;
                }
            }
        });
    }
//
//    protected void onListItemClick(ListView listView, View v, int position, long id){
//        super.onListItemClick(listView, v, position, id);
//        Object o = this.getListAdapter().getItem(position);
//        String item = o.toString();
//        Toast.makeText(this,"Você selecionou: " + item, Toast.LENGTH_SHORT).show();
//    }
}
