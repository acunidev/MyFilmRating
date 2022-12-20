package com.example.myfilmrating.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myfilmrating.R;
import com.example.myfilmrating.RecycledVw.FilmAdapter;
import com.example.myfilmrating.database.AppDatabaseFilms;
import com.example.myfilmrating.database.Entity.Film;
import com.example.myfilmrating.database.dao.FilmDao;
import com.example.myfilmrating.filmRepo.FilmRepository;
import com.example.myfilmrating.filmRepo.FilmeRepositoryImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MyRates extends AppCompatActivity {

  private List<Film> films = new ArrayList<>();
  private RecyclerView recyclerView;
  private Spinner spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_rates);
    initElements();
    initSpinnerData();
    initGetAll();
  }

  @Override
  protected void onResume() {
    super.onResume();
    initGetAll();
  }

  private void initElements() {
    FloatingActionButton goToAddFilm = findViewById(R.id.goToAddFilm);
    goToAddFilm.setOnClickListener(view -> {
      Intent intent = new Intent(view.getContext(), AddFilm.class);
      startActivity(intent);
    });
  }

  private void initGetAll() {
    recyclerView = findViewById(R.id.recyVw);
    recyclerView.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    AppDatabaseFilms filmsDB = AppDatabaseFilms.getInstance(this.getApplicationContext());
    FilmDao daoFilm = filmsDB.filmDao();

    FilmRepository filmRepo = new FilmeRepositoryImpl(daoFilm);

//    spinner
    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
          case 0:
            if (spinner.getSelectedItem().equals("Order By Name")) {
              films = filmRepo.getAllOrderByMovieTitle();
              FilmAdapter adaptadorTitulo = new FilmAdapter(films);
              recyclerView.setAdapter(adaptadorTitulo);
            }
            break;
          case 1:
            if (spinner.getSelectedItem().equals("Order By Rating")) {
              films = filmRepo.getAllOrderByRating();
              FilmAdapter adaptadorTitulo = new FilmAdapter(films);
              recyclerView.setAdapter(adaptadorTitulo);
            }
            break;
          case 2:
            if (spinner.getSelectedItem().equals("Order By Year")) {
              films = filmRepo.getAllOrderByYear();
              FilmAdapter adaptadorTitulo = new FilmAdapter(films);
              recyclerView.setAdapter(adaptadorTitulo);
            }
            break;
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO document why this method is empty
      }
    });

  }

  private void initSpinnerData() {

    spinner = findViewById(R.id.spinnerFilterBy);

    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                                                                         R.array.films_filter_by,
                                                                         android.R.layout.simple_spinner_dropdown_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }
}