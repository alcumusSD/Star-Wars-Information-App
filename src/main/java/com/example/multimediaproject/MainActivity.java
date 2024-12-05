package com.example.multimediaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //ArrayList<String> names;
    Button rotate;
    TextView by;
    TextView prof;
    TextView lsc;
    TextView planet;
    ImageView imageView2;

    StarWarsCharacters Luke = new StarWarsCharacters("Luke Skywalker", "Brave Jedi on a quest to restore peace.", "19 BBY", "Jedi", "Blue", R.drawable.luke);
    StarWarsCharacters DarthVader = new StarWarsCharacters("Darth Vader", "Dark Sith Lord with a tragic past.", "41 BBY", "Sith Lord", "Red", R.drawable.darthvader);
    StarWarsCharacters Leia = new StarWarsCharacters("Leia Skywalker", "A Force-sensitive princess and fearless leader.", "19 BBY", "Jedi", "Blue", R.drawable.leia);
    StarWarsCharacters Palpatine = new StarWarsCharacters("Palpatine", "Evil Mastermind planning the rise of the Empire.", " 82 BBY", "Sith Lord", "Red", R.drawable.palpatine);
    StarWarsCharacters MaceWindu = new StarWarsCharacters("Mace Windu", "Skilled Jedi with a unique purple lightsaber.", "72 BBY", "Jedi", "Purple", R.drawable.macewindu);
    StarWarsCharacters Yoda = new StarWarsCharacters("Yoda", "Small yet Wise and powerful Jedi Master", "896 BBY", "Jedi", "Green", R.drawable.yoda);
    StarWarsCharacters HanSolo = new StarWarsCharacters("Han Solo", "Skilled pilot with a heart of gold.", "32 BBY", "Pilot", "N/A", R.drawable.hansolo);
    StarWarsCharacters ObiWan = new StarWarsCharacters("Obi Wan Kenobi", "Jedi mentor with amazing combat skills.", "57 BBY", "Jedi", "Blue", R.drawable.obiwan);
    ArrayList<StarWarsCharacters> names;// = new ArrayList<StarWarsCharacters>();

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("STARWARS", names);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        by = findViewById(R.id.textView4);
        prof = findViewById(R.id.textView5);
        lsc = findViewById(R.id.textView6);
        imageView2 = findViewById(R.id.imageView2);
        names = new ArrayList<>();

        if(savedInstanceState != null){
            names = savedInstanceState.getParcelableArrayList("STARWARS");
        }else {
            names.add(Luke);
            names.add(DarthVader);
            names.add(Leia);
            names.add(Palpatine);
            names.add(MaceWindu);
            names.add(Yoda);
            names.add(ObiWan);
            names.add(HanSolo);
        }

        listView = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, i+" ", Toast.LENGTH_LONG).show();
                Log.d("TAG", getResources().getConfiguration().orientation + "");

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Toast.makeText(MainActivity.this, "Your Favorite Star Wars Character is " + names.get(i).getName(), Toast.LENGTH_LONG).show();
                } else {
                    //imageView2.setImageResource(names.get(i).getImage());
                    by.setText("Birth year: " + names.get(i).getBirthYear());
                    prof.setText("Profession: " + names.get(i).getProfession());
                    lsc.setText("LightSaber Color: " + names.get(i).getLightSaberColor());
                }
            }
        });
    }
}

