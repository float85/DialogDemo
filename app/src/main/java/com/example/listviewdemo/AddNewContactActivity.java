package com.example.listviewdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddNewContactActivity extends AppCompatActivity {

    Spinner spPhoneType;
    Button btnGroup, btnTune, btnSend;
    ArrayList<String> phoneType;

    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        setTitle("Add New Contact");

        Intent intent =getIntent();

        contact=(Contact) intent.getSerializableExtra("contact");

        spPhoneType = findViewById(R.id.spPhoneType);
        btnTune = findViewById(R.id.btnTune);
        btnGroup = findViewById(R.id.btnGroup);
        btnSend = findViewById(R.id.btnSend);

        phoneType = new ArrayList<>();
        phoneType.add("Phone");
        phoneType.add("Word");
        phoneType.add("Home");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, phoneType);
        spPhoneType.setAdapter(arrayAdapter);


        //SingleChoice chỉ chọn 1
        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] tunes = {"Anh phải làm sao", "Hãy trao cho anh", "Về nhà đi con"};
                AlertDialog alertDialog = new AlertDialog.Builder(AddNewContactActivity.this)
                        .setTitle("Set RingTune")
//                        .setMessage("SetMessenger")
                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();

                alertDialog.show();
            }
        });


        //Chọn nhiều sự kiện
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] group = {"Bạn bè", "Facebook", "Zalo", "Gia đình"};
                boolean[] isChecks = {false, true, false, true};

                AlertDialog alertDialog = new AlertDialog.Builder(AddNewContactActivity.this)
                        .setTitle("Select Group")
                        .setMultiChoiceItems(group, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create();

                alertDialog.show();
            }
        });

        //popupMenu
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.new_contact_menu,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnItemSave:
                                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mnItemCancel:
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contact, menu);
        return super.onCreateOptionsMenu(menu);
    }








    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnItemSave:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnItemCancel:
                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
