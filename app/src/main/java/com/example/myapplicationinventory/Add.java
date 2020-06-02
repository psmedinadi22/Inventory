package com.example.myapplicationinventory;

import android.content.Context;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Add extends AppCompatActivity {

  /*  EditText ed1, ed2, ed3;
    ArrayList<String> data;
    ArrayList<String> data1;
    ArrayList<String> data2;

    public EditText get() {
        return ed1;}

    public void set(EditText ed1) {
        this.ed1 = ed1;}*/

    public add(EditText ed1, EditText ed2,EditText ed3,ArrayList<String> data,ArrayList<String> data1,ArrayList<String> data2){

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

        for(int i = 0; i<data.size(); i++){
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
