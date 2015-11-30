package com.example.katarn.pizzanator;

/**
 * Alex Marshall
 * Dylan Crawford
 */

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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
    private String web;
    private String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        Intent intent = getIntent();
        //get info from PizzaList
        storeName = intent.getStringExtra("store");
        addr = intent.getStringExtra("addr");
        web = intent.getStringExtra("web");
        num = intent.getStringExtra("num");

        //set detail text values
        TextView store = (TextView) findViewById(R.id.detailName);
        store.setText(storeName);

        TextView address = (TextView) findViewById(R.id.detailAddress);
        address.setText(addr);

        TextView website = (TextView) findViewById(R.id.detailWeb);
        SpannableString websiteContent = new SpannableString(web);
        //underline clickable values
        websiteContent.setSpan(new UnderlineSpan(), 0, websiteContent.length(), 0);
        website.setText(websiteContent);

        TextView phoneNumber = (TextView) findViewById(R.id.detailNumber);
        SpannableString phoneContent = new SpannableString(num);
        phoneContent.setSpan(new UnderlineSpan(), 0, phoneContent.length(), 0);
        phoneNumber.setText(phoneContent);
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

    //show map using address from database
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

    //on click for website text, opens web browser to the store website
    public void openWebsite(View V) {
        String url = "http://www." + web;
        Intent openUrl = new Intent(Intent.ACTION_VIEW);
        openUrl.setData(Uri.parse(url));
        startActivity(openUrl);
    }

    //on click for phone text, opens phone app with the number entered
    public void openPhone(View V) {
        String uri = "tel:" + num.trim() ;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
}