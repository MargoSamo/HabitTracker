package com.mariia.habittracker.web;

import com.mariia.habittracker.domain.Habit;
import com.mariia.habittracker.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/habit")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping("")
    public ResponseEntity<?> createNewHabit(@Valid @RequestBody Habit habit, BindingResult result) {
        Habit habit1 = habitService.saveOrUpdateHabit(habit);
        return new ResponseEntity<Habit>(habit1, HttpStatus.CREATED);
    }

    @GetMapping("/{nameId}")
    public ResponseEntity<?> getHabitByName(@PathVariable String nameId) {
        Habit habit = habitService.findByName(nameId);
        return new ResponseEntity<Habit>(habit, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Habit> getAllHabits() {
        return habitService.findAllHabits();
    }

    @DeleteMapping("/{nameId}")
    public ResponseEntity<?> deleteHabit(@PathVariable String nameId) {
        habitService.deleteHabitByName(nameId);
        return new ResponseEntity<String >("Habit with name '" + nameId + "' was deleted", HttpStatus.OK);
    }
}
