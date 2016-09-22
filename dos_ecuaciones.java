package com.primera.carlos.sistemasecuaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class dos_ecuaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_ecuaciones);
        Toast.makeText(this, "Estas en dos ecuaciones", Toast.LENGTH_SHORT).show();
    }

    public void obtenerMatrices(){
        EditText matriz1     = (EditText)findViewById(R.id.editMatrizUno);
        Editable prueba      = matriz1.getText();
        String prueba1       = prueba.toString();
        if(prueba1.equals("")){
            prueba1="0 0 0";
        }
        String [] matriz1A   = prueba1.split(" ");
        matriz1B             = new float[3];

        for (int i=0;i<matriz1A.length;i++){
            if (matriz1A[i].equals("")){
                matriz1A[i]="0";
            }
            matriz1B[i]=Float.parseFloat(matriz1A[i]);

        }

        EditText matriz2      = (EditText)findViewById(R.id.editMatrizDos);
        Editable prueba2B     = matriz2.getText();
        String prueba2        = prueba2B.toString();
        if(prueba2.equals("")){
            prueba2="0 0 0";
        }
        String [] matriz2A    = prueba2.split(" ");
        matriz2B              = new float[3];


        for (int i=0;i<matriz2A.length;i++){
            if (matriz2A[i].equals("")){
                matriz2A[i]="0";
            }
            matriz2B[i]= Float.parseFloat(matriz2A[i]);
        }

    }

   public void matematicaDosEcuaciones(){
        float divisor = matriz1B[0]*matriz2B[1]-(matriz2B[0]*matriz1B[1]);
        float dividendox = matriz1B[2]*matriz2B[1]-(matriz2B[2]*matriz1B[1]);
        float dividendoy = matriz1B[0]*matriz2B[2]-(matriz2B[0]*matriz1B[2]);
        resultadox = dividendox/divisor;
        resultadoy =dividendoy/divisor;

    }

    public void resultadoDosEcuaciones(View vista){
        Toast.makeText(dos_ecuaciones.this, "Llega hasta aqui?", Toast.LENGTH_SHORT).show();
        obtenerMatrices();
        matematicaDosEcuaciones();
        EditText resultado = (EditText)findViewById(R.id.editResultado);
        double resultadoxd = (double)resultadox;
        double resultadoyd = (double)resultadoy;
        double Sresultadox = Math.rint(resultadoxd*1000)/1000;
        double Sresultadoy = Math.rint(resultadoyd*1000)/1000;
        resultado.setText("X = "+Sresultadox+" "+"Y = "+Sresultadoy);

    }

    public void limpiarEdit(View vista){
        EditText resultado = (EditText)findViewById(R.id.editResultado);
        resultado.setText("");
        EditText matriz1 = (EditText)findViewById(R.id.editMatrizUno);
        matriz1.setText("");
        EditText matriz2 = (EditText)findViewById(R.id.editMatrizDos);
        matriz2.setText("");

    }

    private float[] matriz1B;
    private float[] matriz2B;
    private float resultadox,resultadoy;


}

//-------------esperemos---------

