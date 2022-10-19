package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView obrazekImageView;
    EditText numberEditText;
    ArrayList <Integer> obrazki = new ArrayList<>();
    int indeksAktualny = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obrazki.add(R.drawable.rys1);
        obrazki.add(R.drawable.rys2);
        obrazki.add(R.drawable.rys3);
        obrazki.add(R.drawable.rys4);
        obrazekImageView =findViewById(R.id.imageView);
        numberEditText = findViewById(R.id.editTextNumber);
        numberEditText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence,
                                              int i, int i1, int i2) {
                        Toast.makeText(MainActivity.this,
                                charSequence, Toast.LENGTH_SHORT)
                                .show();
                        //charSequence przechowuje wartość
                        // zapisaną w edittekscie
                        if(charSequence.toString().length()>0) {
                            indeksAktualny = Integer.valueOf(charSequence.toString());
                            if (indeksAktualny < 0 || indeksAktualny >= obrazki.size()) {
                                indeksAktualny = 0;
                            }
                            obrazekImageView
                                    .setImageResource(obrazki.get(indeksAktualny));
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
    }
}