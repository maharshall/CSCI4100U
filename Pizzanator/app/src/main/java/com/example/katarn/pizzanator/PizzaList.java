package com.example.katarn.pizzanator;

/**
 * Alex Marshall
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PizzaList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        PizzaDB pdb = new PizzaDB(this);
        ArrayList<PizzaStore> data = pdb.getAllProducts();

        final ListView lv = (ListView) findViewById(R.id.listView);
        // link database to list view
        lv.setAdapter(new PizzaAdapter(this, data));

        // set click listener
        lv.setOnItemClickListener(onListClick);
    }

    // on click for PizzaDetail map button
    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent detail = new Intent(PizzaList.this, PizzaDetail.class);

            PizzaDB pdb = new PizzaDB(PizzaList.this);
            ArrayList<PizzaStore> data = pdb.getAllProducts();

            detail.putExtra("store", data.get(position).getStoreName());
            detail.putExtra("addr", data.get(position).getAddress());
            detail.putExtra("web", data.get(position).getWebsite());
            detail.putExtra("num", data.get(position).getPhoneNumber());

            startActivity(detail);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pizza_list, menu);
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
}
