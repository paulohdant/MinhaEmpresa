package com.example.minhaempresa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSite;
    private Button buttonLocal;
    private Button buttonCompartilhar;
    private Button buttonLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarComponentes();
        setupBotoes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.buttonMenuVoltar){
            sair();
            return true;
        }else if(id == R.id.buttonMenuCompartilhar){
            compartilhar();
        }else if(id == R.id.buttonMenuLigar){
            ligar();
        }else if(id == R.id.buttonMenuLocal){
            local();
        }else if(id == R.id.buttonMenuSite){
            site();
        }else if(id == R.id.buttonMenuSobre){
            sobre();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Deseja realmente sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void carregarComponentes(){
        buttonSite = findViewById(R.id.buttonSite);
        buttonLocal = findViewById(R.id.buttonLocal);
        buttonCompartilhar = findViewById(R.id.buttonCompartilhar);
        buttonLigar = findViewById(R.id.buttonLigar);
    }

    private void setupBotoes(){
        buttonSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site();
            }
        });

        buttonLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligar();
            }
        });

        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                local();
            }
        });

        buttonCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartilhar();
            }
        });
    }

    private void site(){
        String site = getString(R.string.website);
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        startActivity(website);
    }

    private void ligar(){
        String numero = getString(R.string.ligando);
        Uri uri = Uri.parse("tel:" + numero);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    private void local(){
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    private void compartilhar(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.barraSubtitulo));
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.barraTitulo));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.nada)));
    }

    private void sobre(){
        Intent intent = new Intent(MainActivity.this, ActivitySobre.class);
        startActivity(intent);
    }

    private void sair(){
        finish();
    }
}