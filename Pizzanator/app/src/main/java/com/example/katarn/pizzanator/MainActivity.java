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
