package com.example.listagemarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class FrutaAdapter extends ArrayAdapter<Fruta> {
    int myResource;
    NumberFormat numberFormat;

    public FrutaAdapter(Context context, int resource, ArrayList<Fruta> objects) {
        super(context, resource, objects);
        myResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(myResource, parent, false);

        TextView tvCodigo = convertView.findViewById(R.id.text1);
        TextView tvNome = convertView.findViewById(R.id.text2);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvPreco = convertView.findViewById(R.id.preco);
        TextView tvPrecoVenda = convertView.findViewById(R.id.preco_venda);

        Fruta fruta = getItem(position);

        tvCodigo.setText(Integer.toString(fruta.getCodigo()));
        tvNome.setText(fruta.getNome());
        imageView.setImageResource(fruta.getImagem());

        numberFormat = new DecimalFormat("#,##.00");
        tvPreco.setText(numberFormat.format(fruta.getPreco()));
        tvPrecoVenda.setText((fruta.getPreco_venda().toString()));
        return convertView;
    }
}
