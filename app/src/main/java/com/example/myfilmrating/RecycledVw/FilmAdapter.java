package com.example.myfilmrating.RecycledVw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.myfilmrating.R;
import com.example.myfilmrating.database.Entity.Film;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolderFilm> {

  List<Film> filmsList;

  public FilmAdapter(List<Film> filmsList) {
    this.filmsList = filmsList;
  }

  @NonNull
  @NotNull
  @Override
  public ViewHolderFilm onCreateViewHolder(@NonNull @NotNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recicle_structure, null, false);
    return new ViewHolderFilm(view);
  }

  @Override
  public void onBindViewHolder(@NonNull @NotNull ViewHolderFilm holder, int position) {
    holder.setValuesFilms(filmsList.get(position));
  }

  @Override
  public int getItemCount() {
    return filmsList.size();
  }

  public class ViewHolderFilm extends ViewHolder {

    RatingBar ratingBar;
    TextView textView;
    TextView movieName;
    TextView movieDirector;
    TextView movieYear;

    public ViewHolderFilm(@NonNull @NotNull View itemView) {
      super(itemView);
      ratingBar = itemView.findViewById(R.id.ratingMovie);
      movieName = itemView.findViewById(R.id.movieNameList);
      movieDirector = itemView.findViewById(R.id.movieDirectorList);
      movieYear = itemView.findViewById(R.id.movieYearList);
    }

    public void setValuesFilms(Film film) {
      ratingBar.setRating(film.getRating());
      movieName.setText(film.getMovieTitle());
      movieDirector.setText(film.getDirectorName());
      movieYear.setText(String.valueOf(film.getYear()));
    }
  }
}
