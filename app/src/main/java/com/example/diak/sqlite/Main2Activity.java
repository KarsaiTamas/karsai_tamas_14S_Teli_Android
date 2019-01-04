package com.example.diak.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText Edit_Text_Felhasznalo,Edit_Text_Jelszo;
    private Button Button_Bejelentkezes,Button_Registracio;
    private AdatbazisSegito db;
    public void Valtozok()
    {
        Button_Bejelentkezes=(Button)findViewById(R.id.Button_Bejelentkezes);
        Button_Registracio=(Button)findViewById(R.id.Button_Registracio);
        Edit_Text_Felhasznalo=(EditText) findViewById(R.id.Edit_Text_Felhasznalo);
        Edit_Text_Jelszo=(EditText) findViewById(R.id.Edit_Text_Jelszo);
        db = new AdatbazisSegito(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Valtozok();
        Button_Bejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Edit_Text_Felhasznalo!=null || Edit_Text_Jelszo!=null)
                {
                    if(db.Beengedes(Edit_Text_Felhasznalo.getText().toString(),Edit_Text_Jelszo.getText().toString())==1)
                    {
                    Intent oda = new Intent(Main2Activity.this,Registracio.class);
                    startActivity(oda);
                    finish();
                    }
                }else
                    {
                        Toast.makeText(Main2Activity.this, "Hibás jelszó/felhasználónév", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        Button_Registracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oda = new Intent(Main2Activity.this,Registracio.class);
                startActivity(oda);
                finish();
            }
        });


    }



}
