package com.float85.dialogmenu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.float85.dialogmenu.databinding.SaveFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class SaveFragment extends Fragment {

    SaveFragmentBinding binding;
    List<String> stringList;

    public static SaveFragment newInstance() {

        Bundle args = new Bundle();

        SaveFragment fragment = new SaveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.save_fragment, container, false);
        stringList = new ArrayList<>();


        ArrayAdapter<CharSequence> stringArrayAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.array_list, android.R.layout.simple_spinner_item);

        binding.spList.setAdapter(stringArrayAdapter);

        binding.btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogSHow();
            }
        });
        return binding.getRoot();
    }

    private void onDialogSHow() {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("Select Alert Dialog")
                //.setMessage("Bạn có đồng ý thoát ra hay không")
                .setSingleChoiceItems(R.array.array_list, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"aaaa",Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Đồng ý", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Không Đồng ý", Toast.LENGTH_LONG).show();

                    }
                })
                .create();

        alertDialog.show();


    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(getContext(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_home, popup.getMenu());
        popup.show();
    }


}
