package com.iset.formulaireetudiant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DateNaissance extends AppCompatActivity {
    private Button btnSuiv2 ;
    private DatePicker dtNaissance ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_naissance);

        lien();
        afficher();
        ajouterEcouteur();

    }
    private void lien() {
        btnSuiv2= findViewById(R.id.btnSuiv2);
        dtNaissance= findViewById(R.id.dtNaissance); }
    private void afficher() {
        // Récupérer l'objet Bundle envoyé par la 1ère activité
        Bundle bundle = this.getIntent().getExtras();
        String nom = bundle.getString("nom");
        String prenom = bundle.getString("prenom");
        Toast t = Toast.makeText(getApplicationContext(), nom +"\n" + prenom,Toast.LENGTH_LONG); t.show();
    }
    private void ajouterEcouteur() {
        btnSuiv2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                suivant();
            }
        });
    }

    private void suivant() {
        // Récupérer l'objet Bundle qui va contenir en plus les
        // nouvelles données à envoyer à l’activité suivante
        Bundle bundle = this.getIntent().getExtras();
        bundle.putString("date", dtNaissance.getDayOfMonth()+"/" +(dtNaissance.getMonth()+1)+"/" +dtNaissance.getYear());
        Intent intent = new Intent(DateNaissance.this, Option.class);
        // Affecter à l'Intent le Bundle créé
        intent.putExtras(bundle);
        // Démarre l'autre Activité
        startActivity(intent);
    }
}


