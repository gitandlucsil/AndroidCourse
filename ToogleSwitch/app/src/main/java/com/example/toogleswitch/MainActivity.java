package com.example.toogleswitch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toogleSenha;
    private Switch switchSenha;
    private TextView textResultado;
    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progresso = 0;
    private SeekBar seekBarEscala;
    private TextView textResultadoSeekBar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toogleSenha = findViewById(R.id.toggleSenha);
        switchSenha = findViewById(R.id.switchSenha);
        textResultado = findViewById(R.id.textResultado);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarCircular.setVisibility(View.GONE);
        seekBarEscala = findViewById(R.id.seekBarEscala);
        textResultadoSeekBar = findViewById(R.id.textResultadoSeekBar);
        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textResultadoSeekBar.setText("Progresso: "+progress+"/"+seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        adicionarListener();
    }

    public void adicionarListener(){
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textResultado.setText("Switch ligado!");
                }else{
                    textResultado.setText("Switch desligado!");
                }
            }
        });
    }

    public void Enviar(View view){
        if(switchSenha.isChecked()){
            textResultado.setText("Switch ligado!");
        }else{
            textResultado.setText("Switch desligado!");
        }
        if(toogleSenha.isChecked()){
            textResultado.setText("Toogle ligado!");
        }else{
            textResultado.setText("Toogle desligado!");
        }
    }

    public void mostrarToast(View view){
        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);
        Toast toast = new Toast(this); //this tambem recupera o Context
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        toast.show();
        //toast.setText("Nova ação realizada com sucesso!");
        /*Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!",
                Toast.LENGTH_LONG
        ).show();*/
    }

    public void mostrarAlertDialog(View view){
        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //Configurar titulo e mensagem
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");
        //Configurar cancelamento
        dialog.setCancelable(false);
        //Configurar icone
        dialog.setIcon(android.R.drawable.star_on);
        //Configurar acoes para sim e nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão sim",
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Executar ação ao clicar no botão não",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }

    public void carregarProgressBar(View view){
        //ProgressBar Horizontal
        this.progresso = this.progresso + 1;
        progressBarHorizontal.setProgress(this.progresso);
        //ProgressBar Circular
        progressBarCircular.setVisibility(View.VISIBLE);
        if(this.progresso == 10){
            progressBarCircular.setVisibility(View.GONE);
        }
    }

    public void limparSeekBar(View view){
        textResultadoSeekBar.setText("Escolhido: "+seekBarEscala.getProgress());
        //seekBarEscala.setProgress(0);
    }
}
