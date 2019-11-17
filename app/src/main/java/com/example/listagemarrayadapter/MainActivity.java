package com.example.listagemarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView = findViewById(R.id.listFrutas);
        String[] arrayCidades = {"gaspar", "blumenau", "pomerode", "indaial", "timbo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, arrayCidades);

        Frutas frutas = new Frutas();
        final ArrayList<Fruta> listaFrutas = new ArrayList<>();
        for (Fruta f : frutas.FRUTAS) {
            listaFrutas.add(f);
        }

        FrutaAdapter adapterFruta = new FrutaAdapter(this,
                R.layout.template_listagem,
                listaFrutas);

        listView.setAdapter(adapterFruta);
    }


}
