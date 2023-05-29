package com.example.pr5;

import android.os.Bundle;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.Button;

import android.widget.EditText;

import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;

import java.util.Objects;

public class Fragment1 extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public Fragment1() {

        super(R.layout.activity_fragment1);

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments()!=null && !Objects.equals(getArguments().getString("text"), ""))

            Log.i(TAG, getArguments().getString("text"));

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        android.view.View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);

        Button btn = rootView.findViewById(R.id.button_2);

        EditText editText = rootView.findViewById(R.id.edit_text);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("text", editText.getText().toString());

                Navigation.findNavController(view).navigate(R.id.fr1_fr2, bundle);

            }

        });

        return rootView;

    }

}