package com.mariia.habittracker.domain;


import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(toBuilder = true)
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class HabitRecord implements Serializable {
  @NotNull
  @NotBlank
  private String name;
  private LocalDate day;
  private boolean done;
  private Integer value;

  private HabitRecord(String name, LocalDate day, boolean done, Integer value) {
    this.name = name;
    if (day == null) {
      this.day = LocalDate.now();
    } else {
      this.day = day;
    }
    this.done = done;
    this.value = value;
  }
}
