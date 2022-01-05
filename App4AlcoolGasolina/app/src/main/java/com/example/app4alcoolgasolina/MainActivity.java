package com.example.app4alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.zip.DeflaterOutputStream;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView txResultado;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCalcular = findViewById(R.id.buttonCalcular);
        editPrecoAlcool = findViewById(R.id.textInputAlcool);
        editPrecoGasolina = findViewById(R.id.textInputGasolina);
        txResultado = findViewById(R.id.textResultado);
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        if(pAlcool.isEmpty() || pGasolina.isEmpty()){
            return false;
        }
        return true;
    }
    public void calcular(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        if(!validarCampos(precoAlcool, precoGasolina)){
            txResultado.setText("Informe valores para ambos os campos!");
        }else{
            Double alcool = Double.parseDouble(precoAlcool);
            Double gasolina = Double.parseDouble(precoGasolina);
            if((alcool/gasolina) >= 0.7){
                txResultado.setText("Melhor utilizar gasolina!");
            }else{
                txResultado.setText("Melhor utilizar álcool!");
            }
        }

    }
}
