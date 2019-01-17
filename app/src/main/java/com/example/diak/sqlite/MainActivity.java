package com.example.diak.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button Button_Kijelentkezes;
    private TextView Text_View_eredmeny;

    private AdatbazisSegito db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adatLekeres();
        Button_Kijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent uj_adat = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(uj_adat);
                finish();
            }
        });


    }

    public void init()
    {

        Button_Kijelentkezes = (Button) findViewById(R.id.Button_Kijelentkezes);
        Text_View_eredmeny = (TextView) findViewById(R.id.Text_View_eredmeny);

        db = new AdatbazisSegito(this);
    }

    public void adatLekeres()
    {

        //stringbuffer = hosszú string amihez hozzá fűzzük (appendeljük) a változókat




                Text_View_eredmeny.setText("Üdvözöllek: "+AdatbazisSegito.be_nev);
           // Text_View_eredmeny.setText("sanyi");
                Toast.makeText(this, " Sikeresen beléptél", Toast.LENGTH_SHORT).show();


    }
}
