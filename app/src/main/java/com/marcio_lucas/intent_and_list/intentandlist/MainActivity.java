package com.marcio_lucas.intent_and_list.intentandlist;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Camera;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] itens = new String[]{"Uma Activity",
                "Google.com", "Ligar pra mim mesmo", "Abrir contato mamãe", "Ir para o bosque",
                "Abrir as configurações", "Configuração de som", "Configuração de acessibilidade"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        ListView lv = (ListView) findViewById(R.id.lista);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
//
                        startActivity(new Intent(MainActivity.this, OutraActivity.class));
                        break;

                    case 1:
                        Uri url = Uri.parse("https://www.google.com");
                        startActivity(new Intent(Intent.ACTION_VIEW, url));
                        break;

                    case 2:
                        Uri cell = Uri.parse("tel:992658429");
                        startActivity(new Intent(Intent.ACTION_DIAL, cell));

                        break;
                    case 3:
                        Uri mamae = Uri.parse("content://com.android.contacts/contacts/1");
                        startActivity(new Intent(Intent.ACTION_VIEW, mamae));

                        break;

                    case 4:
                        Uri map = Uri.parse("geo:-17.8123505, -49.2039571");

                        startActivity(new Intent(Intent.ACTION_VIEW, map));

                        break;
                    case 5:
                        startActivity(new Intent(Settings.ACTION_SETTINGS));
                        break;

                    case 6:
                        startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS));
                        break;
                    case 7:
                        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                }
            }
        });
    }

}
