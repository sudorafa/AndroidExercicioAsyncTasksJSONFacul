package com.example.orafa.androidexercicioasynctasksjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewPokemon = (ListView)findViewById(R.id.list_view_pokemon);

        PokemonTask pokemonTask = new PokemonTask(this, listViewPokemon);
        pokemonTask.execute();
    }
}
