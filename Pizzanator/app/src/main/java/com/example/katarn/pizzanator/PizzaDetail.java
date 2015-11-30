package com.example.katarn.pizzanator;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PizzaDetail extends Activity {
    private String addr;
    private String storeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        Intent intent = getIntent();
        storeName = intent.getStringExtra("store");
        addr = intent.getStringExtra("addr");
        String web = intent.getStringExtra("web");
        String num = intent.getStringExtra("num");

        TextView store = (TextView) findViewById(R.id.detailName);
        store.setText(storeName);

        TextView address = (TextView) findViewById(R.id.detailAddress);
        address.setText(addr);

        TextView website = (TextView) findViewById(R.id.detailWeb);
        website.setText(web);

        TextView phoneNumber = (TextView) findViewById(R.id.detailNumber);
        phoneNumber.setText(num);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pizza_detail, menu);
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

    private Address geocodeLookup(String address) {
        if (Geocoder.isPresent()) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());

            try {
                // forward geocode from the provided address
                List<Address> results = geocoder.getFromLocationName(address, 1);

                if (results.size() > 0) {
                    return results.get(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void showMap(View view) {
        Address address = geocodeLookup(addr);

        Intent showMapIntent = new Intent(this, MapsActivity.class);

        if (address != null) {
            showMapIntent.putExtra("latitude", address.getLatitude());
            showMapIntent.putExtra("longitude", address.getLongitude());
            showMapIntent.putExtra("address", (storeName +", " +addr));
        }

        startActivity(showMapIntent);
    }
}
