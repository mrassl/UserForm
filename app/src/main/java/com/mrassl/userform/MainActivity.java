package com.mrassl.userform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextInputEditText inputTitNombre;
    TextInputEditText inputTitTelefono;
    TextInputEditText inputTitEmail;
    TextInputEditText inputTitDescripcion;
    DatePicker dpTitCumple;
    MaterialButton btnSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle params = getIntent().getExtras();
        iniciar(params);
    }

    private void iniciar(Bundle params) {

        inputTitNombre = findViewById(R.id.input_tit_nombre);
        inputTitTelefono = findViewById(R.id.input_tit_telefono);
        inputTitEmail = findViewById(R.id.input_tit_email);
        inputTitDescripcion = findViewById(R.id.input_tit_descripcion);
        dpTitCumple = findViewById(R.id.dp_tit_cumple);

        if (params != null) {
            int mes = params.getInt(getResources().getString(R.string.fecha_mes));
            inputTitNombre.setText(params.getString(getResources().getString(R.string.tit_nombre)));
            dpTitCumple.updateDate(
                    params.getInt(getResources().getString(R.string.fecha_anho)),
                    mes,
                    params.getInt(getResources().getString(R.string.fecha_dia)));
            inputTitTelefono.setText(params.getString(getResources().getString(R.string.tit_telefono)));
            inputTitEmail.setText(params.getString(getResources().getString(R.string.tit_email)));
            inputTitDescripcion.setText(params.getString(getResources().getString(R.string.tit_descripcion)));
        }
    }

    public void avanzar(View view) {
        MaterialButton btnSig = findViewById(R.id.buttonSig);
        btnSig.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmDatos.class);
            intent.putExtra(getResources().getString(R.string.tit_nombre), Objects.requireNonNull(inputTitNombre.getText()).toString());
            intent.putExtra(getResources().getString(R.string.tit_telefono), Objects.requireNonNull(inputTitTelefono.getText()).toString());
            intent.putExtra(getResources().getString(R.string.tit_email), Objects.requireNonNull(inputTitEmail.getText()).toString());
            intent.putExtra(getResources().getString(R.string.tit_descripcion), Objects.requireNonNull(inputTitDescripcion.getText()).toString());
            intent.putExtra(getResources().getString(R.string.fecha_dia), dpTitCumple.getDayOfMonth());
            intent.putExtra(getResources().getString(R.string.fecha_mes), dpTitCumple.getMonth());
            intent.putExtra(getResources().getString(R.string.fecha_anho), dpTitCumple.getYear());
            startActivity(intent);
            finish();
        });
    }
}





