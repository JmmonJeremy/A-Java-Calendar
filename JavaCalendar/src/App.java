package JavaCalendar.src;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class App {
  private static Scanner scanner = new Scanner(System.in);
  private static Scheduler scheduler = new Scheduler();
  // Constants for ANSI
  private static final String BOLD = "\u001B[1m";
  private static final String UNDERLINE = "\u001B[4m";
  private static final String RESET = "\u001B[0m";

  public static void main(String[] args) throws Exception {
    try {
      scheduler.loadFromFile();
    } catch (Exception e) {
      System.out.println("Error: Saved tasks could not be loaded.");
    }

    boolean running = true;

    while (running) {
      printMenu();
      int choice = Integer.parseInt(scanner.nextLine());
      System.out.print(RESET + "\n"); // stop underline

      switch (choice) {
        case 1 -> addTask();
        case 2 -> listAllTasks();
        case 3 -> listTasksByDate();
        case 4 -> saveAndExit();
        case 5 -> running = false;
        default -> System.out.println("Invalid option.");
      }

    }
  }

  private static void printMenu() {
    System.out.println("\n" + BOLD + "=====================" + RESET);
    System.out.println(BOLD + UNDERLINE + "Task Scheduler       " + RESET);
    System.out.println("1) Add task");
    System.out.println("2) View all tasks");
    System.out.println("3) View tasks by date");
    System.out.println("4) Save tasks");
    System.out.println("5) Exit");
    System.out.println(BOLD + "=====================" + RESET);
    System.out.print(BOLD + "Option Selection:  " + RESET + UNDERLINE);
  }
    // label, description, priority, date, startTime, duration
    private static void addTask() {
      System.out.print("Enter task label: ");
      String label = scanner.nextLine();

      System.out.print("Enter task description: ");
      String description = scanner.nextLine();

      System.out.print("Enter task priority (1-5): ");
      Integer priority = Integer.parseInt(scanner.nextLine());

      System.out.print("Enter date (YYYY-MM-DD): ");
      LocalDate date = LocalDate.parse(scanner.nextLine());

      System.out.print("Enter task start time (HH:MM, 24-hour format; example 14:30 for 2:30 pm): ");
      LocalTime startTime = LocalTime.parse(scanner.nextLine());

      System.out.print("Enter task duration in minutes: ");
      Integer duration = Integer.parseInt(scanner.nextLine());

      scheduler.addTask(label, description, priority, date, startTime, duration);
      System.out.println("Task added.");
  }

  private static void listAllTasks() {
    scheduler.listAllTasks();
  }

  private static void listTasksByDate() {
    System.out.print("Enter date (YYYY-MM-DD): ");
    LocalDate date = LocalDate.parse(scanner.nextLine());
    scheduler.listTasksByDate(date);
  }

  private static void saveAndExit() {
    try {
      scheduler.saveToFile();
      System.out.println("Tasks saved.");
    } catch (Exception e) {
      System.out.println("Error saving tasks.");
    }
  }

}
