package com.mariia.habittracker.web;

import com.mariia.habittracker.domain.Habit;
import com.mariia.habittracker.domain.HabitRecord;
import com.mariia.habittracker.repositories.FileBasedHabitRepository;
import com.mariia.habittracker.services.HabitService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/record")
public class HabitRecordController {
  @Autowired
  private FileBasedHabitRepository repository;

  @PostMapping()
  public ResponseEntity<?> createNewHabit(@Valid @RequestBody HabitRecord habit, BindingResult result) {
    repository.save(habit);
    return new ResponseEntity<Iterable<HabitRecord>>(repository.getAll(), HttpStatus.CREATED);
  }


  @GetMapping()
  public Iterable<HabitRecord> getAllHabits() {
    return repository.getAll();
  }
}
