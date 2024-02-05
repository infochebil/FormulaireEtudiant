package com.iset.formulaireetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNom;
    private EditText edPren;
    private Button btnSuiv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lien();
        ajouterEcouteur();


    }

    private void lien() {
        edNom = (EditText) findViewById(R.id.edNom);
        edPren = (EditText) findViewById(R.id.edPren);
        btnSuiv1 = (Button) findViewById(R.id.btnSuiv1);
    }
    private void ajouterEcouteur() {
        btnSuiv1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                suivant();
            }
            private void suivant() {
                // Créer un objet Bundle qui va contenir les données à transmettre à l'activité suivante.
                Bundle bundle = new Bundle();
                bundle.putString("nom", edNom.getText().toString());
                bundle.putString("prenom", edPren.getText().toString());
                Intent intent = new Intent(MainActivity.this,DateNaissance.class);
                // Affecter à l'Intent le Bundle créé
                intent.putExtras(bundle);
                // Démarrer l'autre Activité
                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
    }
}