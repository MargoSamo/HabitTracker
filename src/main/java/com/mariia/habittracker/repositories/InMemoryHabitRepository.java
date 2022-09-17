package com.mariia.habittracker.repositories;


import com.mariia.habittracker.domain.Habit;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryHabitRepository implements HabitRepository {

  @Override
  public Habit findByName(String nameId) {
    return null;
  }

  @Override
  public <S extends Habit> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Habit> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Habit> findById(Long aLong) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Habit> findAll() {
    return null;
  }

  @Override
  public Iterable<Habit> findAllById(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Long aLong) {

  }

  @Override
  public void delete(Habit entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Long> longs) {

  }

  @Override
  public void deleteAll(Iterable<? extends Habit> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
