package com.example.didoy.didoypizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.didoy.didoypizza.Model.Pizza;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Payment extends AppCompatActivity {

    @BindView(R.id.ordersList) ListView ordersList;
    @BindView(R.id.total) TextView totalTextView;
    @BindView(R.id.deliverbtn) Button deliveryBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();
        ArrayList<Pizza> orders = (ArrayList)  b.get("listOrder");

        ArrayAdapter orderAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orders);

        ordersList.setAdapter(orderAdapter);

        int total = 0;
        for (Pizza pizza : orders){
            total += pizza.getPrice();
        }

        totalTextView.setText(String.valueOf(total));

    }

    @OnClick(R.id.deliverbtn) void deliver(){
        Toast.makeText(this, "Order is now placed", Toast.LENGTH_SHORT).show();
    }

}
