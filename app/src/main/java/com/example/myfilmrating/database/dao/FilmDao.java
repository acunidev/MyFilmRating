package com.example.myfilmrating.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.myfilmrating.database.Entity.Film;
import java.util.List;

@Dao
public interface FilmDao {

  @Query("SELECT * FROM Film")
  List<Film> getAll();

  @Query("SELECT * FROM Film WHERE idFilm IN (:userIds)")
  List<Film> loadAllByIds(int[] userIds);

  @Query("SELECT * FROM Film WHERE movieTitle LIKE :movieTitle AND directorName LIKE :dirName LIMIT 1")
  Film findByName(String movieTitle, String dirName);

  @Insert
  void insertAll(Film... film);

  @Delete
  void delete(Film film);

}
