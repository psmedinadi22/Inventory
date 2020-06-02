package com.example.myapplicationinventory;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.myapplicationinventory.R.layout.inventory;
import static com.example.myapplicationinventory.R.layout.delete;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<String>();
    ArrayList<String> data1 = new ArrayList<String>();
    ArrayList<String> data2 = new ArrayList<String>();
    TableLayout table;
    EditText ed1, ed2, ed3;
    Button b1, ba, be, deleteButton;
    ImageButton previous, previous2;
    Spinner spinnerProduct, spinnerQuantity;


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
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        add();

                    }
                });

            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(delete);
                delete();

            }
        });

    }

 public  void add(){
        String prodname = ed1.getText().toString();
        int price = Integer.parseInt(ed2.getText().toString());
        int qty = Integer.parseInt(ed3.getText().toString());

        data.add(prodname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(qty));


        TableLayout table = (TableLayout) findViewById(R.id.tb1);

        TableRow row = new TableRow(this);
        TextView t1= new TextView(this);
        TextView t2= new TextView(this);
        TextView t3= new TextView(this);

        for(int i =0; i<data.size(); i++){
            String pname = data.get(i);
            String prc = data1.get(i);
            String qtyy = data2.get(i);
            t1.setText(pname);
            t2.setText(prc);
            t3.setText(qtyy);
        }

        row.addView(t1);
        row.addView(t2);
        row.addView(t3);

        table.addView(row);
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed1.requestFocus();
    }


    public void delete(){
        spinnerProduct = findViewById(R.id.spinnerProduct);
        spinnerQuantity= findViewById(R.id.spinnerQuantity);

        final ArrayList<String> productsArray = new ArrayList<>();
        ArrayList<String> quantityArray = new ArrayList<>();
        productsArray.add("hello");
        /*for(int i =0; i<data.size(); i++){
            productsArray.add(data.get(i));

        }
        for(int i =0; i<data2.g; i++){
         int numEntero = Integer.parseInt(numCadena);
            quantityArray.add(i+1);
        }*/
        quantityArray.add("4");

        ArrayAdapter adpProducts = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,productsArray);
        spinnerProduct.setAdapter(adpProducts);

        spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemenProductArray = (String) spinnerProduct.getAdapter().getItem(position);

                Toast.makeText(MainActivity.this, "Producto: "+elemenProductArray, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adpQuantity = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,quantityArray);
        spinnerQuantity.setAdapter(adpQuantity);

        spinnerQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemenQuantityArray = (String) spinnerQuantity.getAdapter().getItem(position);

                Toast.makeText(MainActivity.this, "Cantidad: "+elemenQuantityArray, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Borrar el precio y cantidad mostradas
            }
        });

    }

}
