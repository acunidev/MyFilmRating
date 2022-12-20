package com.example.myfilmrating.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Film")
public class Film {

  @ColumnInfo(name = "movieTitle")
  public String movieTitle;
  @ColumnInfo(name = "directorName")
  public String directorName;
  @ColumnInfo(name = "year")
  public int year;
  @ColumnInfo(name = "rating")
  public long rating;
  @PrimaryKey(autoGenerate = true)
  private int idFilm;

  //<editor-fold desc="Getter/Setters">
  public String getDirectorName() {
    return directorName;
  }

  public void setDirectorName(String directorName) {
    this.directorName = directorName;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public long getRating() {
    return rating;
  }

  public void setRating(long rating) {
    this.rating = rating;
  }

  public int getIdFilm() {
    return idFilm;
  }

  public void setIdFilm(int idFilm) {
    this.idFilm = idFilm;
  }

  public String getMovieTitle() {
    return movieTitle;
  }

  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }
  //</editor-fold>

}
