package com.primera.carlos.sistemasecuaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Funcionara", Toast.LENGTH_SHORT).show();

    }
    public void prueba(View vista){
        Toast.makeText(MainActivity.this, "Esto funciona ", Toast.LENGTH_SHORT).show();
    }
    public void pantallaDos(View vista){
        Intent intent = new Intent(MainActivity.this, dos_ecuaciones.class);
        startActivity(intent);
    }
    public void pantallaTres(View vista){
        Intent intent = new Intent(MainActivity.this,tres_ecuaciones.class);
        startActivity(intent);
    }




}
