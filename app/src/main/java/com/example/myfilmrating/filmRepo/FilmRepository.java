package com.example.myfilmrating.filmRepo;

import com.example.myfilmrating.database.Entity.Film;
import java.util.List;

public interface FilmRepository {

  List<Film> getAll();

  List<Film> loadAllByIds(int[] userIds);

  List<Film> getAllOrderByMovieTitle();

  List<Film> getAllOrderByYear();

  List<Film> getAllOrderByRating();

  Film findByName(String movieTitle, String dirName);

  void insertAll(Film film);

  void delete(Film film);

}
