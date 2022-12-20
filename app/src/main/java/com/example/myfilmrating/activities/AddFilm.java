package com.example.myfilmrating.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfilmrating.R;
import com.example.myfilmrating.database.AppDatabaseFilms;
import com.example.myfilmrating.database.Entity.Film;
import com.example.myfilmrating.database.dao.FilmDao;
import com.example.myfilmrating.filmRepo.FilmRepository;
import com.example.myfilmrating.filmRepo.FilmeRepositoryImpl;

public class AddFilm extends AppCompatActivity implements OnClickListener {

  Film film;
  AppDatabaseFilms filmsDB;
  FilmDao daoFilm;
  EditText message;
  RatingBar ratingBar;
  EditText directorName;
  EditText movieName;
  EditText movieYear;
  Button btnAddFilm;
  AppDatabaseFilms databaseFilms;
  FilmDao filmDao;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_film);
    initElements();
//    TODO Tasca Activitat 4.3

//    message = findViewById(R.id.movieInputText);
//    Intent test = getIntent();
//    Uri uri = test.getData();
//    String actionName = test.getAction();

//    if (Intent.ACTION_VIEW.equals(actionName)) {
//      infoFile(uri);
//    }
  }

  private void addToSQLite() {
    filmsDB = AppDatabaseFilms.getInstance(this.getApplicationContext());
    daoFilm = filmsDB.filmDao();

    film = new Film();
    film.setMovieTitle(movieName.getText().toString());
    film.setDirectorName(directorName.getText().toString());
    film.setYear(Integer.parseInt(movieYear.getText().toString()));
    film.setRating((long) ratingBar.getRating());

    FilmRepository filmRepo = new FilmeRepositoryImpl(daoFilm);
    filmRepo.insertAll(film);
  }

  private void initElements() {
    movieName = findViewById(R.id.movieInputText);
    directorName = findViewById(R.id.directorInputText);
    movieYear = findViewById(R.id.yearInputText);
    ratingBar = findViewById(R.id.ratingBar);
    btnAddFilm = findViewById(R.id.btnAddFilm);
    btnAddFilm.setOnClickListener(this);
  }

  private void clearInputs() {
    movieName.setText("");
    directorName.setText("");
    movieYear.setText("");
    ratingBar.setRating(0);
  }


  public void openImplicitIntent(View view) {
    // Create the text message with a string
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
    sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
    if (sendIntent.resolveActivity(getPackageManager()) != null) {
      startActivity(sendIntent);
    }
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btnAddFilm:
        addToSQLite();
        Toast.makeText(getApplicationContext(),
                       "Movie: " + film.getMovieTitle() + " saved to the Database.",
                       Toast.LENGTH_SHORT).show();
        clearInputs();
    }
  }

/*
  public void infoFile(Uri uri) {

    Cursor cursor = getContentResolver().query(uri, null, null, null);
    int name = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
    int size = cursor.getColumnIndex(OpenableColumns.SIZE);
    cursor.moveToFirst();
    Log.i("Basic Info", cursor.getString(name));
    Log.i("Basic Info", Long.toString(cursor.getLong(size)));
    metadata(uri);

  }
*/

/*
  public void metadata(Uri returnUri) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    retriever.setDataSource(getApplicationContext(), returnUri);
    TextView titleView = (TextView) findViewById(R.id.movieInputText);
    String title = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
    String artist = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
    String year = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
    int time = Integer.parseInt(
        retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
    String codec = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
    String height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
    String width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
    int duration = time / 1000;
    int hours = duration / 3600;
    int minutes = ((duration - hours * 3600) / 60);
    int seconds = duration - (hours * 3600 + minutes * 60);
    titleView.setText(String.format(Locale.ENGLISH,
                                    "Title: %s \nArtist: %s \nYear: %s \nDuration: %d:%dm \nCodec: %s \nSize: %sx%s",
                                    title,
                                    artist, year, minutes, seconds, codec, height, width));
  }
*/
}