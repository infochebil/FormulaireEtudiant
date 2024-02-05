package com.iset.formulaireetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Formulaire extends AppCompatActivity {
    private TextView nom ;
    private TextView pren ;
    private TextView dateNaiss ;
    private TextView option ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        lien();
        afficher();

    }
    private void lien() {
        nom=(TextView) findViewById(R.id.nom);
        pren=(TextView) findViewById(R.id.pren);
        dateNaiss=(TextView) findViewById(R.id.dateNaiss);
        option=(TextView) findViewById(R.id.option);
    }
    private void afficher() {
        Bundle bundle = this.getIntent().getExtras();
        String nom1 = bundle.getString("nom");
        String prenom = bundle.getString("prenom");
        String datNaissance = bundle.getString("date");
        String option1 = bundle.getString("option");
        nom.setText(nom1);
        pren.setText(prenom);
        dateNaiss.setText(datNaissance);
        option.setText(option1);
    }

}