package com.dev.android.idictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textView_word,textView_meaning;
    RecyclerView recycler_phonetics,recycler_meanings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view=findViewById(R.id.search_view);
        textView_word=findViewById(R.id.textView_word);
        textView_meaning=findViewById(R.id.textView_meanings);
        recycler_phonetics=findViewById(R.id.recycler_phonetics);
        recycler_meanings=findViewById(R.id.recycler_meanings);

    }
}