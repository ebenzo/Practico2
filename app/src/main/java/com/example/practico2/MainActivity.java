package com.example.practico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rdDolaresAEuros;
    private RadioButton rdEurosADolares;
    private EditText etdolares;
    private EditText etEuros;
    private TextView tvTotal;
    private double dolaresAEuros = 0.91; //1 dólar estadounidense Es igual a 0.91 euro
    private double eurosADolares = 1.1; //1 euro Es igual a 1.10 dólar estadounidense
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etdolares = findViewById(R.id.etdolares);
        etEuros = findViewById(R.id.etEuros);
        rdDolaresAEuros = findViewById(R.id.rdDoAEu);
        rdEurosADolares = findViewById(R.id.rbEuADo);
        tvTotal = findViewById(R.id.labelTotal);
    }

    //Evento del boton btConvertir
    public void convertir(View view) {
        if (rdDolaresAEuros.isChecked() && !etdolares.getText().toString().equals("") && Double.parseDouble(etdolares.getText().toString()) != 0) {
            double dolares = Double.parseDouble(etdolares.getText().toString());
            double total = dolares * dolaresAEuros;
            tvTotal.setText(String.valueOf(total));
        }
        else if (rdEurosADolares.isChecked() && !etEuros.getText().toString().equals("") && Double.parseDouble(etEuros.getText().toString()) != 0) {
            double euros = Double.parseDouble(etEuros.getText().toString());
            double total = euros * eurosADolares;
            tvTotal.setText(String.valueOf(total));
        }
    }

    public void changeRadio(View view) {
        etdolares.setText("");
        etEuros.setText("");
        tvTotal.setText("");

        if (rdDolaresAEuros.isChecked()) {
            etdolares.setEnabled(true);
            etEuros.setEnabled(false);
        }
        if (rdEurosADolares.isChecked()) {
            etdolares.setEnabled(false);
            etEuros.setEnabled(true);
        }
    }
}
