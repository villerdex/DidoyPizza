package com.example.didoy.didoypizza;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.didoy.didoypizza.Model.Pizza;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class OrderActivity extends ListActivity {


    private ListView pizzaList;
    ArrayList<Pizza> pizzaMenu;
    @BindView(R.id.confirm) Button confrimbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

       pizzaMenu = new ArrayList<>();
        pizzaMenu.add( new Pizza("Classic",R.drawable.pizza_peperroni, "Classic Pizza for the the best experience", 20 ));
        pizzaMenu.add( new Pizza("Cheezy Pizza",R.drawable.pizza_cheese, "Cheessy for Cheesy People", 35 ));
        pizzaMenu.add( new Pizza("Combination",R.drawable.pizza_combination, "Combination iwas Umay", 20 ));
        pizzaMenu.add( new Pizza("White Cheese",R.drawable.pizza_whitecheeses, "White for Creammy Cheese", 20 ));


        final PizzaArrayAdapter arrayAdapter = new PizzaArrayAdapter(this, pizzaMenu);
        final AdapterItemListener adapterItemListener = arrayAdapter.getAdapterItemListener();

        pizzaList = getListView();
        pizzaList.setAdapter(arrayAdapter);
        pizzaList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        pizzaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                CheckBox cb = (CheckBox)view.findViewById(R.id.buy);
                              cb.setChecked(!cb.isChecked());
            }
        });
    }

    @OnClick(R.id.confirm) void confirm(){
        ArrayList<Pizza> pizzalistOrder = new ArrayList<Pizza>();

        SparseBooleanArray check =  pizzaList.getCheckedItemPositions();

        for (int i = 0; i < pizzaList.getAdapter().getCount(); i++) {

            if (check.valueAt(i)) {
                // Do whatever you need to in here to get data from
                // the item at index i in the ListView
                Pizza pizza = (Pizza) pizzaList.getItemAtPosition(check.keyAt(i));

                pizzalistOrder.add(pizza);
            }

        }
        Intent intent = new Intent(this, Payment.class);
        intent.putExtra("listOrder", pizzalistOrder);
        startActivity(intent);
    }


}
