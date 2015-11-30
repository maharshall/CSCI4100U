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
        lv.setAdapter(new PizzaAdapter(this, data));
    }

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

    //on click for list view entry, opens the detailed view of entry
    public void viewDetail(View v) {
        Intent detail = new Intent(this, PizzaDetail.class);

        PizzaDB pdb = new PizzaDB(this);
        ArrayList<PizzaStore> data = pdb.getAllProducts();

        TextView store = (TextView) findViewById(R.id.storeName);
        String name = store.getText().toString();

        //store the details in the intent
        for (int i = 0; i < data.size(); i++) {
            if(name.equals(data.get(i).getStoreName())) {
                detail.putExtra("store", data.get(i).getStoreName());
                detail.putExtra("addr", data.get(i).getAddress());
                detail.putExtra("web", data.get(i).getWebsite());
                detail.putExtra("num", data.get(i).getPhoneNumber());
                break;
            }
        }

        startActivity(detail);
    }
}
