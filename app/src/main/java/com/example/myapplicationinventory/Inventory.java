package com.example.myapplicationinventory;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.myapplicationinventory.R.layout.inventory;
import static com.example.myapplicationinventory.R.layout.delete;

public class Inventory extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    ArrayList<String> data1 = new ArrayList<String>();
    ArrayList<String> data2 = new ArrayList<String>();
    TableLayout table;
    EditText ed1, ed2, ed3;
    Button b1, ba, be;
    ImageButton previous;
    Spinner product, quantity;
    Add add;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ba = findViewById(R.id.ba);
        be = findViewById(R.id.be);

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(inventory);
                ed1 = findViewById(R.id.ed1);
                ed2 = findViewById(R.id.ed2);
                ed3 = findViewById(R.id.ed3);

                b1 = findViewById(R.id.btn1);
                previous = findViewById(R.id.previousBtn);

                previous.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        onBackPressed();

                    }
                });


                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //add();
                       // add.add(ed1,ed2,ed3,data,data1,data2);

                    }
                });

            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(delete);

            }
        });

    }




    public void delete(){
        product = findViewById(R.id.spinnerProduct);
        quantity = findViewById(R.id.spinnerQuantity);

        ArrayList<String> productsArray = new ArrayList<>();
        ArrayList<String> quantityArray = new ArrayList<>();
    }



}