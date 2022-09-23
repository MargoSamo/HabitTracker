package com.mariia.habittracker.services;

import com.mariia.habittracker.domain.Habit;
import com.mariia.habittracker.exceptions.HabitNameException;
import com.mariia.habittracker.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit saveOrUpdateHabit(Habit habit) {
        try {
            habit.setName(habit.getName());
            return habitRepository.save(habit);
        } catch (Exception e) {
            throw new HabitNameException("Project name '" + habit.getName().toUpperCase() + "' already exists");
        }
    }

    public Habit findByName(String nameId) {
        Habit habit = habitRepository.findByName(nameId);

        if (habit==null) {
            throw new HabitNameException("Project name '" + nameId + "' does not exists");
        }
        return habit;
    }

    public Iterable<Habit> findAllHabits() {
        return habitRepository.findAll();
    }

    public void deleteHabitByName(String nameId) {
        Habit habit = habitRepository.findByName(nameId);

        if(habit == null) {
            throw new HabitNameException("Cannot Project with name '" + nameId + "' . This project does not exist");
        }
        habitRepository.delete(habit);
    }

}
