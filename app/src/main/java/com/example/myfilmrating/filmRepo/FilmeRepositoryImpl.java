package com.example.myfilmrating.filmRepo;

import com.example.myfilmrating.database.Entity.Film;
import com.example.myfilmrating.database.dao.FilmDao;
import java.util.List;

public class FilmeRepositoryImpl implements FilmRepository {

  FilmDao filmDao;

  public FilmeRepositoryImpl(FilmDao filmDao) {
    this.filmDao = filmDao;
  }

  @Override
  public List<Film> getAll() {
    return filmDao.getAll();
  }

  @Override
  public List<Film> loadAllByIds(int[] userIds) {
    return filmDao.loadAllByIds(userIds);
  }

  @Override
  public Film findByName(String movieTitle, String dirName) {
    return filmDao.findByName(movieTitle, dirName);
  }

  @Override
  public void insertAll(Film... film) {
  }

  @Override
  public void delete(Film... film) {
  }
}
