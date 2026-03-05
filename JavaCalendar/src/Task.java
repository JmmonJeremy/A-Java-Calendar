package JavaCalendar.src;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.management.timer.Timer;

public class Task {
  private String taskLabel;
  private String taskDescription;
  private Integer taskPriority;
  private LocalDate taskDate;
  private LocalTime taskTime;
  private Integer taskDuration; // In minutes
  private boolean completed;

  public Task(String task, String description, Integer priority, LocalDate date, LocalTime startTime, Integer duration) {
    taskLabel = task;
    taskDescription = description;
    taskPriority = priority;
    taskDate = date;
    taskTime = startTime;
    taskDuration = duration; // In minutes
    this.completed = false;
  }

  public String getTaskLabel() {
    return taskLabel;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public Integer getTaskPriority() {
    return taskPriority;
  }

  public LocalDate getTaskDate() {
    return taskDate;
  }

  public LocalTime getTaskTime() {
    return taskTime;
  }

  // In minutes
  public Integer getTaskDuration() {
    return taskDuration;
  }
  
  public String getFormattedDuration() {
    int hours = taskDuration / 60;
    int minutes = taskDuration % 60;

    if (hours == 1 && minutes == 1) {
      return hours + " hour " + minutes + " minute";
    } else if(hours == 1 && minutes > 1) {
      return hours + " hour " + minutes + " minutes";
    } else if(hours > 1 && minutes == 1) {
      return hours + " hours " + minutes + " minute";
    } else if(hours > 1 && minutes > 1) {
      return hours + " hours " + minutes + " minutes";
    } else if (hours == 1) {
      return hours + " hour";
    } else if (hours > 1) {
      return hours + " hours";
    } else if (minutes == 1) {
      return minutes + " minute";
    } else {
      return minutes + " minutes";
    }
  }

  public LocalTime getTaskEndTime() {
    return taskTime.plusMinutes(taskDuration);
  }

  public boolean isCompleted() {
    return completed;
  }

  public void markCompleted() {
    completed = true;
  }

  // Controls how the Task object prints as a string
  @Override
  public String toString() {  
    return taskLabel + " (Priority Level: " + taskPriority + ") | " + taskDate + " (" + taskTime + " - " + getTaskEndTime() + ") | " + (completed ? "Done" : "Pending" + "\nDescription: " + taskDescription + "\nExpected Duration: " + getFormattedDuration());
  }

  // Converts the object into a comma-separated string for saving to a file (like CSV format)
  public String toFileString() {
    return taskLabel + "," + taskDescription + "," + taskPriority + "," + taskDate + "," + taskTime + "," + taskDuration + "," + completed;
  }

  // Takes a line from a file and converts it back into a Task object
  public static Task fromFileString(String line) {
    String[] parts = line.split(",");
    Task task = new Task(parts[0], parts[1], Integer.parseInt(parts[2]), LocalDate.parse(parts[3]), LocalTime.parse(parts[4]), Integer.parseInt(parts[5]));
    if (Boolean.parseBoolean(parts[6])) {
      task.markCompleted();
    }
    return task;
  }

}
