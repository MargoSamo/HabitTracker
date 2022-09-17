package com.mariia.habittracker.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.mariia.habittracker.domain.HabitRecord;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FileBasedHabitRepositoryTest {

  private FileBasedHabitRepository repository;

  @BeforeEach
  public void setup() {
    repository = new FileBasedHabitRepository();
  }

  @Test
  public void shouldSaveHabit() {
    // Given
    var record = HabitRecord.builder()
        .name("Run")
        .value(5)
        .done(true)
        .build();

    // When
    repository.save(record);

    // Then
    var savedRecords = repository.getAll();
    assertThat(savedRecords.getFirst()).isEqualTo(record);
  }

}
