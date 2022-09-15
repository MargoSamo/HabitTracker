package com.mariia.habittracker.repositories;

import com.mariia.habittracker.domain.Habit;
import org.springframework.data.repository.CrudRepository;

public interface HabitRepository extends CrudRepository<Habit, Long> {

    Habit findByName(String nameId);

    @Override
    Iterable<Habit> findAll();


}
