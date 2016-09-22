package com.example.didoy.didoypizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.didoy.didoypizza.Model.Pizza;

import java.util.ArrayList;

/**
 * Created by Didoy on 9/20/2016.
 */
public class PizzaArrayAdapter extends ArrayAdapter {

   private ImageView pizzaImg;
   private TextView pizzaName;
   private TextView priceText;
   private CheckBox cb;
    private View view;

    final AdapterItemListener adapterItemListener = new AdapterItemListener() {
        @Override
        public void check(boolean isCheck) {
        }
    };

    public PizzaArrayAdapter(Context context, ArrayList list) {
        super(context, android.R.layout.simple_list_item_1, list);
    }

    public AdapterItemListener getAdapterItemListener() {
        return adapterItemListener;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        view  =  layoutInflater.inflate(R.layout.custom_row, parent, false);

        pizzaImg = (ImageView) view.findViewById(R.id.pizzaimage);
        pizzaName = (TextView) view.findViewById(R.id.pizzaname);
        priceText = (TextView) view.findViewById(R.id.price);
        cb = (CheckBox) view.findViewById(R.id.buy);

        Pizza pizza = (Pizza) getItem(position);

        final String pizzaname = pizza.getName();
        String pizzaDesc = pizza.getDesc();

        pizzaImg.setImageResource(pizza.getImgId());
        pizzaName.setText(pizzaname);
        priceText.setText("$" + String.valueOf(pizza.getPrice()));

        return view;
    }




}
