package com.example.katarn.pizzanator;

/**
 * Dylan Crawford
 * Alex Marshall
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remove saved values from database
        PizzaDB pdb = new PizzaDB(this);
        pdb.deleteAllProducts();
        //add database entries
        pdb.addProduct("Pizza Pizza", "300 Taunton Rd E, Oshawa, ON L1G 7T4", "pizzapizza.ca", "905-427-1111");
        pdb.addProduct("Pizza Nova", "1288 Ritson Rd N, Oshawa, ON L1G 6Z6", "pizzanova.com", "905-310-3300");
        pdb.addProduct("Pizza Hut", "1206 Simcoe St N, Oshawa, ON L1G 4X2", "pizzahut.ca", "905-571-1300");
        pdb.addProduct("Domino's Pizza", "1383 Wilson Rd N, Oshawa, ON L1K 2Z5", "dominos.ca", "905-434-2777");
        pdb.addProduct("La Pizza & Pasta", "30 Taunton Rd E, Oshawa, ON L1G 3T7", "lapizzaandpasta.com", "905-725-5100");
        pdb.addProduct("Beeno's Pizza", "100 Nonquon Rd #2, Oshawa, ON L1G", "beenospizza.ca", "905-448-0664");
        pdb.addProduct("Double Double Pizza and Chicken", "1335 Simcoe St N, Oshawa, ON L1G 4X1", "doubledouble.ca", "905-728-0000");
        pdb.addProduct("Pizzaville", "1100 Simcoe St N, Oshawa, ON L1G 4W6", "pizzaville.ca", "905-743-0404");
        pdb.addProduct("Little Caesars Pizza", "1128 Simcoe St N, Oshawa, ON L1G 4W9", "littlecaesars.ca", "905-576-4401");
        pdb.addProduct("Boston Pizza", "951 Taunton Rd E, Oshawa, ON L1H 7K5", "bostonpizza.com", "905-720-2900");
        pdb.addProduct("Pizza Xpress Plus", "1812 Simcoe St N, Oshawa, ON L1G", "pizza-xpress.ca", "905-576-2626");
        pdb.addProduct("Square Boy Pizza", "555 Rossland Rd E, Oshawa, ON L1K 1N9", "squareboypizza.ca", "905-725-5853");
        pdb.addProduct("Regino's Pizza", "15 Bond St W, Oshawa, ON L1G 1A1", "reginospizza.com", "905-438-9500");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //on click for find pizza button
    public void findPizza(View V) {
        Intent intent = new Intent(this, PizzaList.class);
        startActivity(intent);
    }

    //on click for tutorial button
    public void tutorial(View V) {
        Intent intent = new Intent(this,VideoActivity.class);
        startActivity(intent);
    }
}
