package com.example.nedim.contactlist;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText etName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etPhone;

    public static String extraName = "contactName";
    public static String extraLastName = "contactLastName";
    public static String extraEmail = "contactEmail";
    public static String extraPhone = "contactPhone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindFields();
    }

    private void bindFields() {
        etName = (EditText) findViewById(R.id.etName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);

        Button button = (Button) findViewById(R.id.btn_create_contact);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String last_name = etLastName.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();

                Integer phoneNumber = parsePhoneNumber(phone);
                if(phoneNumber != null) {
                    createContact(name, last_name, email, phoneNumber);
                }
            }
        });
    }

    private Integer parsePhoneNumber(String phone) {
        try {
            return  Integer.parseInt(phone);
        } catch (NumberFormatException ex) {
            return null;
        }

    }

    private void createContact(String name, String last_name, String email, int phone) {
        Contact contact = new Contact(name, last_name, email, phone);
        Log.d(TAG, "New contact created: " + contact.toString());
        clearEditText();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(extraName, name);
        intent.putExtra(extraLastName, last_name);
        intent.putExtra(extraEmail, email);
        intent.putExtra(extraPhone, phone);
        startActivity(intent);
    }

    private void clearEditText() {
        etName.setText("");
        etLastName.setText("");
        etEmail.setText("");
        etPhone.setText("");
    }
}
