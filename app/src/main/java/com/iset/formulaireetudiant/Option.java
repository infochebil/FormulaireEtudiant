package com.iset.formulaireetudiant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Option extends AppCompatActivity {
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private Button btnSuiv3;
    private RadioGroup radioG ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        lien();
        afficher();
        ajouterEcouteur();

    }
    private void lien() {
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        btnSuiv3=(Button)findViewById(R.id.btnSuiv3);
        radioG=(RadioGroup) findViewById(R.id.radioG);
    }
    private void afficher() {
        // Récupérer l'objet Bundle envoyé par la 1ère activité
        Bundle bundle = this.getIntent().getExtras();
        String nom = bundle.getString("nom");
        String prenom = bundle.getString("prenom");
        String datNaissance = bundle.getString("date");
        Toast t = Toast.makeText(getApplicationContext(), nom +"\n" + prenom +"\n" + datNaissance,Toast.LENGTH_LONG);
        t.show();
    }
    private void ajouterEcouteur() {
        btnSuiv3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                suivant();
            }
        });
    }
    private void suivant() {
        Bundle bundle = this.getIntent().getExtras();
        if (radioG.getCheckedRadioButtonId() == R.id.r1) bundle.putString("option","DSI");
        else if (radioG.getCheckedRadioButtonId() == R.id.r2) bundle.putString("option","RSI");
        else bundle.putString("option","SEM");
        Intent intent = new Intent(Option.this, Formulaire.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}