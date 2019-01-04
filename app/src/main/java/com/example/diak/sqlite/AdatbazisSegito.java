package com.example.diak.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
        HASZNÁLHATÓ LINKEK:
        http://sqlitebrowser.org/
        https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
        https://developer.android.com/training/data-storage/sqlite.html
        https://developer.android.com/training/data-storage/room/index.html
 */

public class AdatbazisSegito extends SQLiteOpenHelper {

    //ADATBÁZIS FELÉPÍTÉSE

    public static final String DATABASE_NAME = "Tanulo.db";    //adatbázis file név
    public static final String TABLE_NAME = "Tanulo_tabla";    //tábla neve

    public static final String COL_1 = "ID";            //első oszlop neve
    public static final String COL_2 = "FELHASZNALO";    //második oszlop neve
    public static final String COL_3 = "JELSZO";   //harmadik oszlop neve
    public static final String COL_4 = "TELJES_NEV";   //harmadik oszlop neve
    public static final String COL_5 = "TELEFON";   //harmadik oszlop neve


    //konstruktor felvétele

    public AdatbazisSegito(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    //LÉTREHOZZUK A TÁBLÁT ÉS A BENNE LÉVŐ OSZLOPOKHOZ TÍPUST ADUNK
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FELHASZNALO TEXT, JELSZO TEXT,TELJES_NEV TEXT,TELEFON INTEGER)");
    }

    //DOBJA EL A TÁBLÁT HA MÁR ILYEN LÉTEZIK

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //adat felvétel

    public boolean adatRogzites(String felhasznalo, String jelszo,String teljesnev,Integer telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, felhasznalo);
        contentValues.put(COL_3, jelszo);
        contentValues.put(COL_4, teljesnev);
        contentValues.put(COL_5, telefon);

        long eredmeny = db.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1)
        {
            return false;           //sikertelen adatfelvétel
        }else
            return true;            //sikeres adatfelvétel
    }

    //adatlekérdezés

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("Select * from " + TABLE_NAME,null);
        return eredmeny;
    }

    public int Beengedes(String nev,String jelszoa)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("Select * from " + TABLE_NAME+"where felhasznalo='"+nev+"'and jelszo='"+jelszoa+"'",null);
        int szamolas=eredmeny.getCount();
        eredmeny.close();
        be_nev=nev;
        be_jelszo=jelszoa;
        return szamolas;
    }    public int Beengedes(String nev)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("Select * from " + TABLE_NAME+"where felhasznalo='"+nev+"'",null);
        int szamolas=eredmeny.getCount();
        eredmeny.close();
        be_nev=nev;
        return szamolas;
    }
    private String be_nev,be_jelszo;
    public Cursor Bejelentkez_Nev()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor eredmeny = db.rawQuery("Select * from " + TABLE_NAME+"where felhasznalo='"+be_nev+"' and jelszo='"+be_jelszo+"'",null);

        return eredmeny;
    }
}
