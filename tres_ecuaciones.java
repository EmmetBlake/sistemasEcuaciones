package com.primera.carlos.sistemasecuaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tres_ecuaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_ecuaciones);
        Toast.makeText(this, "Estas en tres ecuaciones", Toast.LENGTH_SHORT).show();
    }

    public void obtenerMatrices(){

        EditText matriz1     = (EditText)findViewById(R.id.editMatrizUno);
        Editable prueba1     = matriz1.getText();
        String   prueba1A    =prueba1.toString();
        if(prueba1A.equals("")){
            prueba1A="0 0 0 0";
        }
        String [] matriz1A   = prueba1A.split(" ");
        matriz1B             = new float[4];


        for (int i=0;i<matriz1A.length;i++){
            if (matriz1A[i].equals("")){
                matriz1B[i]=0;
            }else{
                matriz1B[i]= Float.parseFloat(matriz1A[i]);
            }

        }
        
        EditText matriz2     = (EditText)findViewById(R.id.editMatrizDos);
        Editable prueba2     = matriz2.getText();
        String prueba2A      = prueba2.toString();
        if(prueba2A.equals("")){
            prueba2A="0 0 0 0";
        }
        String [] matriz2A   = prueba2A.split(" ");
        matriz2B             = new float[4];


        for (int i=0;i<matriz2A.length;i++){
            if (matriz2A[i].equals("")){
                matriz2B[i]=0;
            }else{
                matriz2B[i]= Float.parseFloat(matriz2A[i]);
            }

        }
        
        EditText matriz3     = (EditText)findViewById(R.id.editMatrizTres);
        Editable prueba3     = matriz3.getText();
        String prueba3A      = prueba3.toString();
        if(prueba3A.equals("")){
            prueba3A="0 0 0 0";
        }
        String [] matriz3A   = prueba3A.split(" ");
        matriz3B             = new float[4];


        for (int i=0;i<matriz3A.length;i++){
            if (matriz3A[i].equals("")){
                matriz3B[i]=0;
            }else{
                matriz3B[i]= Float.parseFloat(matriz3A[i]);
            }

        }
    }

    public void matematicaTresEcuaciones(){
        float divisor = matriz1B[0]*matriz2B[1]*matriz3B[2]+matriz2B[0]*matriz3B[1]*matriz1B[2]
                +matriz3B[0]*matriz1B[1]*matriz2B[2]
                -(matriz1B[2]*matriz2B[1]*matriz3B[0]+matriz2B[2]*matriz3B[1]*matriz1B[0]
                +matriz3B[2]*matriz1B[1]*matriz2B[0]);

        float dividendox = matriz1B[3]*matriz2B[1]*matriz3B[2]+matriz2B[3]*matriz3B[1]*matriz1B[2]
                +matriz3B[3]*matriz1B[1]*matriz2B[2]-(matriz1B[2]*matriz2B[1]*matriz3B[3]
                +matriz2B[2]*matriz3B[1]*matriz1B[3]
                +matriz3B[2]*matriz1B[1]*matriz2B[3]);

        float dividendoy = matriz1B[0]*matriz2B[3]*matriz3B[2]+matriz2B[0]*matriz3B[3]*matriz1B[2]
                +matriz3B[0]*matriz1B[3]*matriz2B[2]-(matriz1B[2]*matriz2B[3]*matriz3B[0]
                +matriz2B[2]*matriz3B[3]*matriz1B[0]
                +matriz3B[2]*matriz1B[3]*matriz2B[0]);

        float dividendoz = matriz1B[0]*matriz2B[1]*matriz3B[3]+matriz2B[0]*matriz3B[1]*matriz1B[3]
                +matriz3B[0]*matriz1B[1]*matriz2B[3]-(matriz1B[3]*matriz2B[1]*matriz3B[0]
                +matriz2B[3]*matriz3B[1]*matriz1B[0]
                +matriz3B[3]*matriz1B[1]*matriz2B[0]);

        resultadox = dividendox/divisor;
        resultadoy =dividendoy/divisor;
        resultadoz = dividendoz/divisor;

    }

    public void resultadoTresEcuaciones(View vista){
        Toast.makeText(tres_ecuaciones.this, "Llega hasta aqui?", Toast.LENGTH_SHORT).show();
        obtenerMatrices();
        matematicaTresEcuaciones();

        EditText resultado = (EditText)findViewById(R.id.editResultado);

        double resultadoxd = (double)resultadox;
        double resultadoyd = (double)resultadoy;
        double resultadozd = (double)resultadoz;
        double Sresultadox  = Math.rint(resultadoxd*1000)/1000;
        double Sresultadoy  = Math.rint(resultadoyd * 1000)/1000;
        double Sresultadoz  = Math.rint(resultadozd*1000)/1000;

        resultado.setText("X= "+Sresultadox+" "+"Y= "+Sresultadoy+" Z= "+Sresultadoz);

    }

    public void limpiarEdit(View vista){

        EditText resultado = (EditText)findViewById(R.id.editResultado);
        resultado.setText("");
        EditText matriz1 = (EditText)findViewById(R.id.editMatrizUno);
        matriz1.setText("");
        EditText matriz2 = (EditText)findViewById(R.id.editMatrizDos);
        matriz2.setText("");
        EditText matriz3 = (EditText)findViewById(R.id.editMatrizTres);
        matriz3.setText("");

    }


    private float[] matriz1B;
    private float[] matriz2B;
    private float[] matriz3B;
    float resultadox,resultadoy,resultadoz;
}
