package com.example.pr5;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.Button;

import android.widget.EditText;

import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;

public class Fragment3 extends Fragment {

    public Fragment3() {

        super(R.layout.activity_fragment3);

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        android.view.View rootView = inflater.inflate(R.layout.activity_fragment3, container, false);

        Button btn1 = rootView.findViewById(R.id.button_1);

        EditText editText = rootView.findViewById(R.id.edit_text);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("text", editText.getText().toString());

                Navigation.findNavController(view).navigate(R.id.fr3_fr1, bundle);

            }

        });

        return rootView;

    }

}