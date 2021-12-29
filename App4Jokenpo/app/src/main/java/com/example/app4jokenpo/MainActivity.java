package com.example.app4jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        System.out.println("Selecionado "+opcaoSelecionada);
        ImageView imgOpcaoApp = findViewById(R.id.opcaoAppImage);
        TextView txtResultado = findViewById(R.id.textResultado);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];
        switch (opcaoApp){
            case "pedra":
                imgOpcaoApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgOpcaoApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgOpcaoApp.setImageResource(R.drawable.tesoura);
                break;
            default:
                imgOpcaoApp.setImageResource(R.drawable.padrao);
                break;
        }
        if(
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){ //App ganhador
            txtResultado.setText("Você perdeu!");
        }else if(
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
        ){ //Usuario ganhador
            txtResultado.setText("Você ganhou!");
        }else{ //Empate
            if(opcaoApp == opcaoSelecionada){
                txtResultado.setText("Empate!");
            }
        }
    }
}
