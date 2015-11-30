package com.example.katarn.pizzanator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Dylan Crawford
 * Alex Marshall
 */
public class PizzaDB extends SQLiteOpenHelper{
    //database create and drop statements
    public static final int DATABASE_VERSION = 113;
    public static final String DATABASE_FILENAME = "pizza.db";
    public static final String TABLE_NAME = "PizzaDB";

    public static final String CREATE_STATEMENT = "CREATE TABLE " + TABLE_NAME + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " storeName TEXT NOT NULL, " +
            " address TEXT NOT NULL, " +
            " website TEXT NOT NULL, " +
            " phoneNumber REAL" +
            ")";
    public static final String DROP_STATEMENT = "DROP TABLE " + TABLE_NAME;

    public PizzaDB(Context context) {
        super(context, DATABASE_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DROP_STATEMENT);
        database.execSQL(CREATE_STATEMENT);
    }

    //create an object of the PizzaStore class adds it to the database
    public PizzaStore addProduct(String storeName, String address, String website, String phoneNumber) {
        PizzaStore pizza = new PizzaStore(storeName, address, website, phoneNumber);

        // obtain a database connection
        SQLiteDatabase database = this.getWritableDatabase();
        //add values to database
        ContentValues values = new ContentValues();
        values.put("storeName", pizza.getStoreName());
        values.put("address", pizza.getAddress());
        values.put("website", pizza.getWebsite());
        values.put("phoneNumber", pizza.getPhoneNumber());
        System.out.println(values);
        long id = database.insert(TABLE_NAME, null, values);

        pizza.setId(id);

        return pizza;
    }

    //returns array list of all Pizza places in the database
    public ArrayList<PizzaStore> getAllProducts() {
        ArrayList<PizzaStore> products = new ArrayList<PizzaStore>();
        SQLiteDatabase database = this.getWritableDatabase();

        String[] columns = new String[] { "_id", "storeName", "address", "website", "phoneNumber"};
        Cursor cursor = database.query(TABLE_NAME, columns, "", new String[]{}, "", "", "");
        cursor.moveToFirst();
        do {
            long id = Long.parseLong(cursor.getString(0));
            String storeName = cursor.getString(1);
            String address = cursor.getString(2);
            String website = cursor.getString(3);
            String number = cursor.getString(4);
            PizzaStore pizza = new PizzaStore(storeName, address, website, number);
            pizza.setId(id);
            products.add(pizza);
            cursor.moveToNext();
        } while (!cursor.isAfterLast());

        return products;
    }

    //delete all entries from the database
    public void deleteAllProducts() {
        // obtain a database connection
        SQLiteDatabase database = this.getWritableDatabase();

        int numRowsAffected = database.delete(TABLE_NAME, "", new String[] {});
    }
}
