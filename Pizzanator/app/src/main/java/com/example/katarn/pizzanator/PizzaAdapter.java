package com.example.katarn.pizzanator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Alex Marshall
 */
public class PizzaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PizzaStore> data;

    //constructor
    public PizzaAdapter(Context context, ArrayList<PizzaStore> data) {
        this.data = data;
        this.context = context;
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        PizzaStore pizzaToDisplay = data.get(position);

        if (convertView == null) {
            // create the layout
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_pizza_list, parent, false);
        }

        // populate the views with the data from story
        TextView storeName = (TextView)convertView.findViewById(R.id.storeName);
        storeName.setText(pizzaToDisplay.getStoreName());

        return convertView;
    }
}
