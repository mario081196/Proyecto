package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SegundaActivity extends AppCompatActivity {
    private EditText monto;
    private EditText plazo;
    private Spinner interes;
    private TextView monto_a_pagar;
    private TextView monto_por_cuota;
    private TextView fecha_fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        EditText fecha=findViewById(R.id.editText3);
        monto=findViewById(R.id.editText5);
        plazo=findViewById(R.id.editText6);
        interes=findViewById(R.id.spinner);
        monto_a_pagar=findViewById(R.id.textView19);
        monto_por_cuota=findViewById(R.id.textView20);
        fecha_fin=findViewById(R.id.editText4);
        fecha_pago();
        monto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultado();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        plazo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              resultado();
              fecha_pago();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        interes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultado();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fecha.setText(date.toString());
    }
    public void resultado(){
        int aux=0;
        if(monto.getText().toString().length()!=0) {
            aux = Integer.valueOf(monto.getText().toString());

        }
        int interes2=Integer.valueOf(interes.getSelectedItem().toString());
        Double total=Double.valueOf(aux + ((aux*interes2)/100));
        String monto2=String.valueOf(total);
        monto_a_pagar.setText(monto2);
        Double plazo2=0.0;
        if(plazo.getText().toString().length()!=0){
            int plazo_aux=Integer.valueOf(plazo.getText().toString());
            plazo2=Double.valueOf((total)/(plazo_aux));
            monto_por_cuota.setText(String.valueOf(plazo2));
        }
        else{
            monto_por_cuota.setText(String.valueOf(total));
        }
    }
    public void fecha_pago(){
        Calendar calendario = Calendar.getInstance();
        String fecha_hoy;
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        mes++;
        int aux;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        if (plazo.getText().toString().isEmpty()){
            mes++;
            fecha_hoy = (String.valueOf(dia))+"/"+(String.valueOf(mes))+"/"+ (String.valueOf(año));
            fecha_fin.setText(fecha_hoy);
        }
        else {
            aux = Integer.valueOf(plazo.getText().toString());
            calendario.add(Calendar.MONTH, aux);
            año = calendario.get(Calendar.YEAR);
            mes = calendario.get(Calendar.MONTH);
            mes++;
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            fecha_hoy = (String.valueOf(dia)) + "/" + (String.valueOf(mes)) + "/" + (String.valueOf(año));
            fecha_fin.setText(fecha_hoy);
        }

    }


}
