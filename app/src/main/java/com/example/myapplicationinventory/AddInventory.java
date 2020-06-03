package com.example.myapplicationinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.myapplicationinventory.R.layout.inventory;

public class AddInventory extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<String>();
    ArrayList<String> data1 = new ArrayList<String>();
    ArrayList<String> data2 = new ArrayList<String>();
    EditText ed1, ed2, ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Agregar al inventario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(inventory);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();

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
}
