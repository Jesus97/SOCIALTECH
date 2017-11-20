package com.example.xgaze.socialtech;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // atributos que tiene el layout
    private TextView textViewNombre;
    private TextView textViewApellidos;
    private TextView textViewTelefono;
    private TextView textViewEmail;
    private TextView textViewFormacion;
    private TextView textViewEdad;
    private TextView textViewProvincias;
    private TextView ContadorContactos;


    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextTelefono;
    private EditText editTextEmail;

    private Spinner spinner;
    private  Spinner spinnerProvincias;
    private SeekBar seekbar;
    private ListView lista;
    private MultiAutoCompleteTextView multiTexto;
    private RadioGroup rg;


    private Contacto contacto;
    private ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            listaContactos = (ArrayList<Contacto>) savedInstanceState.getSerializable("listaContactos");

        editTextNombre = (EditText) findViewById(R.id.editNombre);
        editTextApellidos = (EditText) findViewById(R.id.editApellido);
        editTextTelefono = (EditText) findViewById(R.id.editTelefono);
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        textViewEdad = (TextView) findViewById(R.id.textVSeekBAR);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        ContadorContactos = (TextView)findViewById(R.id.ContadorContactos);




        seekbar.setProgress(0);
        seekbar.incrementProgressBy(1);
        seekbar.setMax(100);
        textViewEdad = (TextView)findViewById(R.id.textVSeekBAR);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewEdad.setText(String.valueOf(progress));
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rellenarInformacionSpinner();



    }
    private void rellenarInformacionSpinner() {
        String[] listaFormaciones = {"SMR", "DAM", "DAW", "ASIR", "Ingenieria tecnica informatica",
                "Ingenieria Informatica", "Grado", "Otros"};

        spinner = (Spinner) findViewById(R.id.spinnerFormacion);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaFormaciones));



        spinnerProvincias = (Spinner) findViewById(R.id.spinnerProvincia);
        String[] listaProvincias = {"Jaen", "Granada", "Almeria", "Cordoba", "Sevilla",
                "Huelva", "Cadiz", "Malaga"};
        spinnerProvincias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProvincias));

        ArrayAdapter<String>adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,listaFormaciones);
        multiTexto=(MultiAutoCompleteTextView)findViewById(R.id.multi);
        multiTexto.setAdapter(adaptador);
        multiTexto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());




    }










    public void guardarContacto(View view) {
        String nombre = editTextNombre.getText().toString();
        String apellido = editTextApellidos.getText().toString();
        String telefono = editTextTelefono.getText().toString();
        String email = editTextEmail.getText().toString();
        String edad=textViewEdad.getText().toString();
        String formacion=multiTexto.getText().toString();
        String sexo;

        lista = (ListView) findViewById(R.id.lista);
        AdapterContacto adaptador = new AdapterContacto(this, listaContactos);
        lista.setAdapter(adaptador);
        //por defecto es mujer
        RadioButton radio = findViewById(R.id.hombre);
        if(radio.isChecked()){
            sexo="Hombre";
        }else{
            sexo="Mujer";
        }

       // String provincia=(String)spinnerProvincias.getSelectedItem();

        contacto = new Contacto(nombre, apellido, telefono, email, edad, formacion,sexo);
        listaContactos.add(contacto);
        System.out.println(contacto);

        for(int i=0; i<listaContactos.size(); i++){
            int numero = listaContactos.size();
            ContadorContactos.setText(""+numero);

        }
    }

    //mostrar listView



    public void selecionar(View view){



    }

     // persistencia de datos
        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putSerializable("listaContactos", listaContactos);
        }


}
