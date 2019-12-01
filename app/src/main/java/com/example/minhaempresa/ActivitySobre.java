package com.example.minhaempresa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class ActivitySobre extends AppCompatActivity {

    private Button buttonVoltarSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        carregar();
        buttons();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void buttons(){
        buttonVoltarSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sair();
            }
        });
    }

    private void sair(){
        finish();
    }

    private void carregar(){
        buttonVoltarSobre = findViewById(R.id.buttonVoltarSobre);
    }
}
