package com.example.test.sqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetilProduit extends AppCompatActivity {

    EditText nom,prix;
    Button mod,sup;
    String id;
    Helper h = new Helper(DetilProduit.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_produit);

        nom =findViewById(R.id.nom3);
        prix = findViewById(R.id.prix3);

        mod = findViewById(R.id.mod);
        sup = findViewById(R.id.sup);

        id = getIntent().getStringExtra("id");

        Produit p = h.getOneProduct(Integer.parseInt(id));

        nom.setText(p.getNom());
        prix.setText(String.valueOf(p.getPrix()));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produit p = new Produit(Integer.parseInt(id),nom.getText().toString(),Double.parseDouble(prix.getText().toString()));

                h.updateProduct(p);
                Intent i = new Intent(DetilProduit.this,ListeProduit.class);
                startActivity(i);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.deletProduct(Integer.parseInt(id));
            }
        });
    }
}