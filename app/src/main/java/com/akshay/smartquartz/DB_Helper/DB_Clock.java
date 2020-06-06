package com.akshay.smartquartz.DB_Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.akshay.smartquartz.Bean.Bean_clock;
import com.akshay.smartquartz.Utility.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DB_Clock extends SQLiteAssetHelper {


    public DB_Clock (Context context) {
        super(context, Constant.DB_Name, null, Constant.DB_Version);
        setForcedUpgrade(Constant.DB_Version);

    }



    public ArrayList<Bean_clock> SelectAll(int id) {
        ArrayList<Bean_clock> arraylist = new ArrayList<Bean_clock>();
        SQLiteDatabase db = getReadableDatabase();
        String strQuery = "Select * from SMART_Type where CID="+id;

        Cursor cur = db.rawQuery(strQuery, null);

        if (cur.moveToFirst()) {

            do {
                Bean_clock bc = new Bean_clock();
                bc.setTID(cur.getInt(cur.getColumnIndex("TID")));
                bc.setCID(cur.getInt(cur.getColumnIndex("CID")));
                bc.setModel_No(cur.getString(cur.getColumnIndex("Model_No")));
                bc.setSize_l(cur.getInt(cur.getColumnIndex("Size_l")));
                bc.setSize_b(cur.getInt(cur.getColumnIndex("Size_b")));
                bc.setSize_h(cur.getInt(cur.getColumnIndex("Size_h")));
                bc.setImage(cur.getString(cur.getColumnIndex("Image")));

                arraylist.add(bc);
            } while (cur.moveToNext());
        }
        db.close();
        return arraylist;
    }

    public Bean_clock selectByID(int id) {

        Bean_clock bc = new Bean_clock();
        SQLiteDatabase db = getReadableDatabase();
        String query = "Select Model_No from SMART_Type where TID=" + id;
        Cursor cursor = db.rawQuery(query, null);
        String Model_No = "";
        if (cursor.moveToFirst())
            bc.setModel_No(cursor.getString(cursor.getColumnIndex("Model_No")));

        db.close();
        return bc;


    }

}
