package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nilai1, nilai2;
    Button persegi, segitiga, lingkaran, clear;
    TextView hasil1, hasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai1 = (EditText) findViewById(R.id.nilai1);
        nilai2 = (EditText) findViewById(R.id.nilai2);

        persegi = (Button) findViewById(R.id.persegi);
        segitiga = (Button) findViewById(R.id.segitiga);
        lingkaran = (Button) findViewById(R.id.lingkaran);
        clear = (Button) findViewById(R.id.clear);

        hasil1 = (TextView) findViewById(R.id.hasil1);
        hasil2 = (TextView) findViewById(R.id.hasil2);

        persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((nilai1.getText().length()>0) && (nilai2.getText().length()>0)) {
                    double n1 = Double.parseDouble(nilai1.getText().toString());
                    double n2 = Double.parseDouble(nilai2.getText().toString());

                    double luasP = n1 * n2;
                    hasil1.setText(String.format("%.2f",luasP));
                    double KelilingP = 2 * (n1 + n2);
                    hasil2.setText(String.format("%.2f",KelilingP));

                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukan Nilai panjang & lebar", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((nilai1.getText().length()>0) && (nilai2.getText().length()>0)) {
                    double n1 = Double.parseDouble(nilai1.getText().toString());
                    double n2 = Double.parseDouble(nilai2.getText().toString());

                    double luasS = 0.5 * (n1 * n2);
                    hasil1.setText(String.format("%.2f",luasS));
                    double m = Math.sqrt(Math.pow(n1,2) + Math.pow(n2,2));
                    double kelilingS = m + n1 + n2;
                    hasil2.setText(String.format("%.2f",kelilingS));
                }else  {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukan Nilai alas & tinggi", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilai1.getText().length()>0) {
                    double n1 = Double.parseDouble(nilai1.getText().toString());
                    double r = n1/2;
                    double luasL = 3.14 * Math.pow(r, 2);
                    hasil1.setText(String.format("%.2f",luasL));
                    double kelilingL = 2 * 3.14  * r;
                    hasil2.setText(String.format("%.2f", kelilingL));
                } else  {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukan Nilai Diameter", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai1.setText("");
                nilai2.setText("");
                hasil1.setText("");
                hasil2.setText("");
                nilai1.requestFocus();
            }
        });


    }
}