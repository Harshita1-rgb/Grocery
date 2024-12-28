package com.example.grocery;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroceryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GroceryItem> groceryItems;

    public GroceryAdapter(Context context, ArrayList<GroceryItem> groceryItems) {
        this.context = context;
        this.groceryItems = groceryItems;
    }

    @Override
    public int getCount() {
        return groceryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return groceryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grocery_item, parent, false);
        }

        GroceryItem currentItem = (GroceryItem) getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.groceryName);
        ImageView imageView = convertView.findViewById(R.id.groceryImage);

        nameTextView.setText(currentItem.getName());
        imageView.setImageResource(currentItem.getImageResourceId());

        return convertView;
    }
}
