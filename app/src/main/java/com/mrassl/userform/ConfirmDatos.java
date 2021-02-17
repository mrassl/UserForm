package com.mrassl.userform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ConfirmDatos extends AppCompatActivity {

    TextView tvTitNombre;
    TextView tvTitTelefono;
    TextView tvTitEmail;
    TextView tvTitDescripcion;
    TextView tvTitCumple;
    MaterialButton btnEditar;

    String nombre;
    String telefono;
    String email;
    String descripcion;
    int dia;
    int mes;
    int anho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_datos);
        Bundle params = getIntent().getExtras();
        iniciar(params);
    }

    private void iniciar(Bundle params) {
        tvTitNombre = findViewById(R.id.tv_tit_nombre);
        tvTitTelefono = findViewById(R.id.tv_tit_telefono);
        tvTitEmail = findViewById(R.id.tv_tit_email);
        tvTitDescripcion = findViewById(R.id.tv_tit_descripcion);
        tvTitCumple = findViewById(R.id.tv_tit_cumple);

        nombre = params.getString(getResources().getString(R.string.tit_nombre));
        telefono = params.getString(getResources().getString(R.string.tit_telefono));
        email = params.getString(getResources().getString(R.string.tit_email));
        descripcion = params.getString(getResources().getString(R.string.tit_descripcion));
        dia = params.getInt(getResources().getString(R.string.fecha_dia));
        mes = params.getInt(getResources().getString(R.string.fecha_mes));
        anho = params.getInt(getResources().getString(R.string.fecha_anho));

        tvTitNombre.setText(nombre);
        tvTitCumple.setText(tvTitCumple.getText().toString()
                .concat(" ")
                .concat(String.valueOf(dia))
                .concat("/")
                .concat(String.valueOf(mes))
                .concat("/")
                .concat(String.valueOf(anho)));
        tvTitTelefono.setText(tvTitTelefono.getText().toString().concat(" " + telefono));
        tvTitEmail.setText(tvTitEmail.getText().toString().concat(" " + email));
        tvTitDescripcion.setText(tvTitDescripcion.getText().toString().concat(" " + descripcion));
    }

    public void editar(View view) {
        MaterialButton btnEditar = findViewById(R.id.buttonEdit);
        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmDatos.this, MainActivity.class);
            intent.putExtra(getResources().getString(R.string.tit_nombre), nombre);
            intent.putExtra(getResources().getString(R.string.tit_telefono), telefono);
            intent.putExtra(getResources().getString(R.string.tit_email), email);
            intent.putExtra(getResources().getString(R.string.tit_descripcion), descripcion);
            intent.putExtra(getResources().getString(R.string.fecha_dia), dia);
            intent.putExtra(getResources().getString(R.string.fecha_mes), mes);
            intent.putExtra(getResources().getString(R.string.fecha_anho), anho);
            startActivity(intent);
        });
    }
}

