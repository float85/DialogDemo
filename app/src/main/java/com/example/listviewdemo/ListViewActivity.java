package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    Contact contact1, contact2, contact3, contact4;

    ListView listView;
    AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        contacts = new ArrayList<>();
        listView = findViewById(R.id.lvContact);


        contact1 = new Contact("Mr A", 123456789, true);
        contact2 = new Contact("Mr B", 1266666, false);
        contact3 = new Contact("Mr C", 12345999, true);
        contact4 = new Contact("Mr D", 12345555, false);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);

        adapterContact=new AdapterContact(contacts);
        listView.setAdapter(adapterContact);

    }
}
