package com.example.myapplicationinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.myapplicationinventory.R.layout.delete;

public class deleteInventory extends AppCompatActivity {
    Spinner spinnerProduct, spinnerQuantity;
    Button deleteButton;
    ArrayList<String> productsArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Eliminar del inventario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(delete);
        delete();
    }

    public void delete(){
        spinnerProduct = findViewById(R.id.spinnerProduct);
        spinnerQuantity= findViewById(R.id.spinnerQuantity);
        ArrayList<String> quantityArray = new ArrayList<>();

        AddInventory products_array = new AddInventory();


        // Aqui se llama el arreglo de productos


//de esta manera llenamos el arreglo de la cantidad del producto
        quantityArray.add("4");
        quantityArray.add("3");
        quantityArray.add("2");
        quantityArray.add("1");

        ArrayAdapter adpProducts = new ArrayAdapter(deleteInventory.this, android.R.layout.simple_spinner_dropdown_item,products_array.getArray());
        spinnerProduct.setAdapter(adpProducts);

        spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemenProductArray = (String) spinnerProduct.getAdapter().getItem(position);

                Toast.makeText(deleteInventory.this, "Producto: "+elemenProductArray, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //-----------------------------------------------------------------------------------------------
        //Cantidad de producto

        ArrayAdapter adpQuantity = new ArrayAdapter(deleteInventory.this, android.R.layout.simple_spinner_dropdown_item,quantityArray);
        spinnerQuantity.setAdapter(adpQuantity);

        spinnerQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemenQuantityArray = (String) spinnerQuantity.getAdapter().getItem(position);

                Toast.makeText(deleteInventory.this, "Cantidad: "+elemenQuantityArray, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Borrar el precio y cantidad mostradas, suerte!!


            }
        });

    }
}
