package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;
    private CheckBox checkboxVerde;
    private CheckBox checkboxVermelho;
    private CheckBox checkboxAmarelo;
    private RadioButton radiobuttonFeminino;
    private RadioButton radiobuttonMasculino;
    private RadioGroup opcaoGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);
        checkboxVerde = findViewById(R.id.cbVerde);
        checkboxVermelho = findViewById(R.id.cbVermelho);
        checkboxAmarelo = findViewById(R.id.cbAmarelo);
        radiobuttonFeminino = findViewById(R.id.rbFeminino);
        radiobuttonMasculino = findViewById(R.id.rbMasculino);
        opcaoGenero = findViewById(R.id.opcaoGenero);
    }

    public void radioGroup(){
        opcaoGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbFeminino){
                    textoResultado.setText(radiobuttonFeminino.getText().toString()+" ");
                }
                if(checkedId == R.id.rbMasculino){
                    textoResultado.setText(radiobuttonMasculino.getText().toString()+" ");
                }
            }
        });
    }

    public void radioButton(){
        String texto = "";
        if(radiobuttonFeminino.isChecked()){
            texto += radiobuttonFeminino.getText().toString()+" ";
        }
        if(radiobuttonMasculino.isChecked()){
            texto += radiobuttonMasculino.getText().toString()+" ";
        }
        textoResultado.setText(texto);
    }
    public void checkbox(){
        String texto = "";
        if(checkboxVerde.isChecked()){
            texto += checkboxVerde.getText().toString()+" ";
        }
        if(checkboxVermelho.isChecked()){
            texto += checkboxVermelho.getText().toString()+" ";
        }
        if(checkboxAmarelo.isChecked()){
            texto += checkboxAmarelo.getText().toString()+" ";
        }
        textoResultado.setText(texto);
    }

    public void enviar(View view){
        radioGroup();
        //radioButton();
        //checkbox();
        /*String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        textoResultado.setText("Nome: "+nome +" Email: "+email);*/
    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
        textoResultado.setText("");
        checkboxVerde.setChecked(false);
        checkboxVermelho.setChecked(false);
        checkboxAmarelo.setChecked(false);
    }
}
