
package com.example.grocery;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSelectedDate;
    private ListView listViewGroceries;
    private GroceryAdapter adapter;
    private ArrayList<GroceryItem> groceriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSelectedDate = findViewById(R.id.textViewSelectedDate);
        listViewGroceries = findViewById(R.id.listViewGroceries);

        initArrayList();
        adapter = new GroceryAdapter(this, groceriesList);
        listViewGroceries.setAdapter(adapter);

        listViewGroceries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GroceryItem groceryItem = (GroceryItem) adapter.getItem(position);
                Toast.makeText(MainActivity.this, groceryItem.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initArrayList() {
        groceriesList.clear();
        groceriesList.add(new GroceryItem("Potato", R.drawable.potato));
        groceriesList.add(new GroceryItem("Onion", R.drawable.onion));
        groceriesList.add(new GroceryItem("Tomato", R.drawable.tomato));
        groceriesList.add(new GroceryItem("carrot", R.drawable.carrot));
        groceriesList.add(new GroceryItem("apple", R.drawable.apple));
        groceriesList.add(new GroceryItem("lettuce", R.drawable.lettuce));
        groceriesList.add(new GroceryItem("garlic", R.drawable.garlic));
        groceriesList.add(new GroceryItem("spinach", R.drawable.spinach));
    }

    public void showDatePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + " " + getMonthName(month) + " " + year;
                textViewSelectedDate.setText(selectedDate);
                // You can load specific groceries for this date if needed
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private String getMonthName(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }
}

