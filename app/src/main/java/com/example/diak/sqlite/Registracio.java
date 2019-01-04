package com.example.diak.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registracio extends AppCompatActivity {

    private EditText Edit_Text_Adat_Felhasznalo, Edit_Text_Adat_Jelszo,Edit_Text_Adat_Jelszo_Ismetles,Edit_Text_Adat_Teljes_Nev,Edit_Text_Adat_Telefon;
    private Button Button_Adatfelvetel;
    private AdatbazisSegito db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracio);
        init();

        Button_Adatfelvetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Edit_Text_Adat_Felhasznalo!=null)
                {
                    if(db.Beengedes(Edit_Text_Adat_Felhasznalo.getText().toString())==0 && Edit_Text_Adat_Jelszo.getText().toString().equals(Edit_Text_Adat_Jelszo_Ismetles.getText().toString()))
                    {
                        adatRogzites();
                        Intent vissza = new Intent(Registracio.this,Main2Activity.class);
                        startActivity(vissza);
                        finish();
                    }else
                        {
                            Toast.makeText(Registracio.this, "Hibás adatot adott meg.", Toast.LENGTH_SHORT).show();
                        }
                }else
                    {
                        Toast.makeText(Registracio.this, "Nem adott meg adatot/Hibás adatot adott meg.", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void init()
    {
        Edit_Text_Adat_Felhasznalo = (EditText) findViewById(R.id.Edit_Text_Felhasznalo);
        Edit_Text_Adat_Teljes_Nev = (EditText) findViewById(R.id.Edit_Text_Adat_Teljes_Nev);
        Edit_Text_Adat_Telefon = (EditText) findViewById(R.id.Edit_Text_Adat_Telefon);
        Edit_Text_Adat_Jelszo = (EditText) findViewById(R.id.Edit_Text_Jelszo);
        Edit_Text_Adat_Jelszo_Ismetles = (EditText) findViewById(R.id.Edit_Text_Adat_Jelszo_Ismetles);
        Button_Adatfelvetel = (Button) findViewById(R.id.Button_Adatfelvetel);
        db = new AdatbazisSegito(this);
    }

    public void adatRogzites()
    {
        String felhasznalo = Edit_Text_Adat_Felhasznalo.getText().toString();
        String jelszo = Edit_Text_Adat_Jelszo.getText().toString();
        String teljes_nev= Edit_Text_Adat_Teljes_Nev.getText().toString();
        Integer telefon=Integer.parseInt(Edit_Text_Adat_Telefon.getText().toString());

        boolean eredmeny = db.adatRogzites(felhasznalo,jelszo,teljes_nev,telefon);

        if (eredmeny)
        {
            Toast.makeText(this, "Sikeres adatrögzítés", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Sikertelen adatrögzítés", Toast.LENGTH_SHORT).show();
        }
    }
}
