package com.example.orafa.androidexercicioasynctasksjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by oRafa on 13/11/2017.
 */

public class PokemonTask extends AsyncTask<Void, Void, List<Pokemon>> {

    private final ListView mListViewPokemons;
    Context mContext;
    private ProgressDialog dialag;

    public PokemonTask(Context context, ListView listViewPokemons) {
        mContext = context;
        mListViewPokemons = listViewPokemons;
    }

    @Override
    protected void onPreExecute() {
        dialag = ProgressDialog.show(mContext,"Pokemons","Carregando...");
    }

    @Override
    protected List<Pokemon> doInBackground(Void... voids) {
        List<Pokemon> pokemons = null;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            Gson gson = new Gson();

            Type type = new TypeToken<List<Pokemon>>(){}.getType();
            pokemons = gson.fromJson(jsonString, type);

            return pokemons;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Pokemon> pokemons) {
        // Desfazer o progressDialog
        dialag.dismiss();
        // Carregar ListView da Activity
        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<Pokemon>(mContext,android.R.layout.simple_list_item_1,pokemons);
        mListViewPokemons.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
