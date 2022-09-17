package com.mariia.habittracker.repositories;


import com.mariia.habittracker.domain.HabitRecord;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FileBasedHabitRepository {
  private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

  private final String FILE_PATH = "storage";
  private LinkedList<HabitRecord> records = new LinkedList<>();

  @PostConstruct
  public void setup() {
    log.info("Setup");
    readFromFile();
  }

  public void save(HabitRecord record) {
    log.info("Save record {}", record);
    records.add(record);
    saveAll();
    log.info("Save record success");
  }

  public LinkedList<HabitRecord> getAll() {
    log.info("Get all");
    readFromFile();
    return records;
  }

  private void saveAll() {
    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
      out.writeObject(records);
    } catch (IOException e) {
      log.error("Can't save", e);
    }
  }

  private void readFromFile() {
    if (!new File(FILE_PATH).exists()) {
      log.info("File doesn't exist, try to create one");
      saveAll();
    }
    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
      records = (LinkedList<HabitRecord>) in.readObject();
      log.info("Get all {} success", records);
    } catch (IOException | ClassNotFoundException e) {
      log.error("Can't read", e);
      saveAll();
    }
  }
}
