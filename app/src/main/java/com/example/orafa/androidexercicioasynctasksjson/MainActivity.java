package com.example.orafa.androidexercicioasynctasksjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view_pokemon)
    ListView mListViewPokemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    class PokemonTask extends AsyncTask<Void, Void, Pokemon> {


    }
}
