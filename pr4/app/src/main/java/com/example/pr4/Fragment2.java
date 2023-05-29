package com.example.pr4;

import android.content.ClipData;

import android.os.Bundle;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.Adapter;

import android.widget.AdapterView;

import android.widget.Button;

import android.widget.ListAdapter;

import android.widget.ListView;

import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import java.util.List;

public class Fragment2 extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public void createToast(String text) {

        Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);

        toast.show();

    }

    public Fragment2() {

        super(R.layout.activity_fragment2);

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        android.view.View rootView = inflater.inflate(R.layout.activity_fragment2, container, false);

        ListView itemsList = rootView.findViewById(R.id.list_view);

        List<ClipData.Item> items = new ArrayList<>();

        for (int i = 0; i < 200; i++) {

            String text = "Элемент " + (i + 1);

            items.add(new ClipData.Item(text));

        }

        ListAdapter adapter = new ListViewAdapter(getContext(),

                R.layout.activity_list_view_adapter, items);

        itemsList.setAdapter(adapter);

        itemsList.setOnItemClickListener(new

                                                 AdapterView.OnItemClickListener() {

                                                     @Override

                                                     public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                                                         String s = items.get(position).getText().toString();

                                                         Log.i(TAG, s);

                                                         createToast(s);

                                                     }

                                                 });

        Button button = rootView.findViewById(R.id.button_back);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                getParentFragmentManager().beginTransaction()

                        .setReorderingAllowed(true)

                        .replace(R.id.fragment_container_view_1,

                                Fragment1.class, null)

                        .commit();

            }

        });

        return rootView;

    }

}