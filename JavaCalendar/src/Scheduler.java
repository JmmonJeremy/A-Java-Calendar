package JavaCalendar.src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Scheduler {
  private ArrayList<Task> tasks = new ArrayList<>();
  private final String FILE_NAME = "tasks.txt";

  public void addTask(String label, String description, Integer priority, LocalDate date, LocalTime startTime, Integer duration) {
    tasks.add(new Task(label, description, priority, date, startTime, duration));
  }

  public void listAllTasks() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks found.");
      return;
    }

    for (Task task : tasks) {
      System.out.println(task);
    }
  }

  public void listTasksByDate(LocalDate date) {
    boolean found = false;

    for (Task task : tasks) {
      if (task.getTaskDate().equals(date)) {
        System.out.println(task);
        found = true;
      }
    }

    if (!found) {
      System.out.println("No tasks on this date.");
    }
  }

  public void saveToFile() throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
      for (Task task : tasks) {
        writer.write(task.toFileString());
        writer.newLine();
      }
    }
  }

  public void loadFromFile() throws IOException {
    File file = new File(FILE_NAME);
    if (!file.exists()) return;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      tasks.clear();
      while ((line = reader.readLine()) != null) {
        tasks.add(Task.fromFileString(line));
      }
    }
  }
}
