package com.example.xgaze.socialtech;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xgaze on 12/11/2017.
 */

public class AdapterContacto extends ArrayAdapter<Contacto>{
    public AdapterContacto(Context context, ArrayList<Contacto> users) {
        super(context, 0, users);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contacto aux = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.vista, parent, false);
        }


        TextView nombre = (TextView) convertView.findViewById(R.id.listViewNombre);
        TextView email = (TextView) convertView.findViewById(R.id.listViewEmail);

        nombre.setText(aux.getNombre());
        email.setText(aux.getEmail());

        return convertView;
    }

}
