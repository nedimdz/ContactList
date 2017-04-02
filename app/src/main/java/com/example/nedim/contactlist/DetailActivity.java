package com.example.nedim.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvLastName = (TextView) findViewById(R.id.tvLastName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        tvName.setText(b.getString(MainActivity.extraName));
        tvLastName.setText(b.getString(MainActivity.extraLastName));
        tvEmail.setText(b.getString(MainActivity.extraEmail));
        tvPhone.setText(b.getString(MainActivity.extraPhone));
    }
}
