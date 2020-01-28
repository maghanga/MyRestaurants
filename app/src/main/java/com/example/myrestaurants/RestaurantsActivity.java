package com.example.myrestaurants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] restaurants = new String[] {"The Collective", "Brew Bistro", "Burrito Bar", "Petma", "Ranalo's foods", "Kaldis", "Kilimanjaro", "Mama Rocks", "Nyama Mama", "Subway","KFC", "Chicken Inn", "Pepino's", "Teriyaki", "Charlie's Bisto"};
    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Burritos",
            "Kenyan food", "Fish and Ugali", "Coffee", "Pilau", "Burgers and fries", "Nyamchom",
            "Subs", "Fried chicken", "Fried chicken", "Fast food", "Teriyaki chicken", "Breakfast"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }


}



