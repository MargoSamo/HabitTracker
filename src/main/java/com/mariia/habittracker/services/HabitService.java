package com.mariia.habittracker.services;

import com.mariia.habittracker.domain.Habit;
import com.mariia.habittracker.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit saveOrUpdateHabit(Habit habit) {
        habit.setName(habit.getName());
        return habitRepository.save(habit);
    }

    public Habit findByName(String nameId) {
        Habit habit = habitRepository.findByName(nameId);
        return habit;
    }

    public Iterable<Habit> findAllHabits() {
        return habitRepository.findAll();
    }

    public void deleteHabitByName(String nameId) {
        Habit habit = habitRepository.findByName(nameId);

        if(habit == null) {
            throw new RuntimeException();
        }
        habitRepository.delete(habit);
    }

}
