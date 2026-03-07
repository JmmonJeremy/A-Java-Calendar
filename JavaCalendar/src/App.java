// I have Java 17 (LTS) & Java 21 (LTS) - from https://adoptium.net/ both are industry baseline LTS
// Java 25 (LTS) is available, but it is not industry baseline LTS when this was written 2/28/2026
/*  Project Outline of Requirement Fulfillments:
#1 Conditionals: Use of Switch for menu, if, try, and catch statements to prevent incorrect inputs
#2 Loops: While loops in menu to keep it running until exit and questions repeated until correct input given
   For loops used to cycle through tasks to print to the screen or the document
#3 Functions: getters() to get the parts of Task, compareTo() to order tasks by date, setCompleted() to change task status, 
   toString() to make string for terminal, toFileString() to make string for document, fromFileString() to convert document string to Task object
   All of the function in the Scheduler class to work with the tasks in an ArrayList & document - addTask, toggleCompleteStatus, listAllTasks, etc.
   The main method/function to run the program and the menu for the user to control the program
#4 Classes: App, Task, Scheduler, and DateFormatAndAnsiStyles 
#5 Data structure from Java Collection Framework: ArrayList<Task> tasks to hold the different Task Class objects
#6 Stretch Challenge: Used BufferedWriter and BufferedReader to modify the program to read and write to a file
*/
package JavaCalendar.src;
import static JavaCalendar.src.DateFormatAndAnsiStyles.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class App {
  private static Scanner scanner = new Scanner(System.in);
  private static Scheduler scheduler = new Scheduler();
  private static boolean calendarOpen;  

  public static void main(String[] args) throws Exception {
    try {
      scheduler.loadFromFile();
    } catch (Exception e) {
      System.out.println(RED + "Error: Saved tasks could not be loaded." + RESET);
    }

    calendarOpen = true;

    while (calendarOpen) {
      printMenu();
      int choice = Integer.parseInt(scanner.nextLine());
      System.out.print(RESET + "\n"); // stop underline

      switch (choice) {
        case 1 -> addTask();
        case 2 -> listAllTasks();
        case 3 -> listTasksByDate();
        case 4 -> changeCompleteStatus();
        case 5 -> saveTasks();
        case 6 -> closeCalendar();
        default -> System.out.println(RED + "Invalid option." + GREEN + "Please try again & enter option number 1-6 from the menu." + RESET);
      }

    }
  }

  private static void printMenu() {
    System.out.println("\n" + BOLD + "=====================" + RESET);
    System.out.println(BOLD + UNDERLINE + "Task Calendar        " + RESET);
    System.out.println("1) Add task");
    System.out.println("2) View all tasks");
    System.out.println("3) View tasks by date");
    System.out.println("4) Change task status");
    System.out.println("5) Save changes");
    System.out.println("6) Exit");
    System.out.println(BOLD + "=====================" + RESET);
    System.out.print(BOLD + "Option Selection:  " + RESET + UNDERLINE);
  }
    // Takes label, description, priority, date, startTime, duration
    private static void addTask() {
      // Label Entry from User
      System.out.print(GREEN + BOLD + "Enter task label: " + RESET);
      String label = scanner.nextLine();

      // Description Entry from User
      System.out.print(GREEN + BOLD + "Enter task description: " + RESET);
      String description = scanner.nextLine();

      // Priority Entry from User
      Integer priority = null;
      while (priority == null) {
          try {
              System.out.print(GREEN + BOLD + "Enter task priority " + COLOR_RESET + "(1-5)" + GREEN + ": " + RESET);
              priority = Integer.parseInt(scanner.nextLine());
              if (priority < 1 || priority > 5) {
                  System.out.println(RED + "Priority must be a whole number from 1 to 5." + RESET);
                  priority = null;
              }
          } catch (NumberFormatException e) {
              System.out.println(RED + "Invalid input. Please enter a whole number from 1 to 5." + RESET);
          }
      }

      // Date Entry from User
      LocalDate date = null;
      while (date == null) {
          try {
              System.out.print(GREEN + BOLD + "Enter date " + COLOR_RESET + "(YYYY-MM-DD)" + GREEN + ": " + RESET);
              date = LocalDate.parse(scanner.nextLine());
          } catch (Exception e) {
              System.out.println(RED + "Invalid date format. Please use YYYY-MM-DD." + RESET);
          }
      }

      // Start Time Entry from User
      LocalTime startTime = null;
      while (startTime == null) {
          try {
              System.out.print(GREEN + BOLD + "Enter task start time " + COLOR_RESET + "(HH:MM, 24-hour format; " + PURPLE + "Example 2:30 pm is 14:30)" + GREEN + ": " + RESET);
              startTime = LocalTime.parse(scanner.nextLine());
          } catch (Exception e) {
              System.out.println(RED + "Invalid time format. Please use HH:MM in 24-hour format." + RESET);
          }
      }

      // Duration Entry from User
      Integer duration = null;
      while (duration == null) {
          try {
              System.out.print(GREEN + BOLD + "Enter task duration in minutes: " + RESET);
              duration = Integer.parseInt(scanner.nextLine());
              if (duration <= 0) {
                  System.out.println(RED + "Duration must be greater than 0." + RESET);
                  duration = null;
              }
          } catch (NumberFormatException e) {
              System.out.println(RED + "Invalid input. Please enter a whole number for duration." + RESET);
          }
      }

      // Add Task & Communicate it to User
      scheduler.addTask(label, description, priority, date, startTime, duration);
      System.out.println("\n" + BOLD + "+ + + + + +");
      System.out.println(GREEN + "Task added." + COLOR_RESET);
      System.out.println("+ + + + + +" + RESET);
  }

  private static void listAllTasks() {
    scheduler.listAllTasks();
  }

  private static void listTasksByDate() {
    System.out.print(GREEN + BOLD + "Enter date you wish to view tasks for (YYYY-MM-DD): " + RESET);    
    LocalDate date = LocalDate.parse(scanner.nextLine());
    scheduler.listTasksByDate(date);
  }

  private static void changeCompleteStatus() {
    scheduler.listTaskSummary();
    System.out.println("______________________________________________________");
    System.out.print(GREEN + BOLD + "Enter number of task to change task completion status: " + RESET);
    int taskNumber = Integer.parseInt(scanner.nextLine());

    scheduler.toggleCompleteStatus(taskNumber - 1);
    System.out.println(BOLD + "\n.................................");
    System.out.println(GREEN + "Task status successfully updated." + RESET);
    System.out.println("*********************************");
}

  private static void saveTasks() {
    try {
      scheduler.saveToFile();
      System.out.println(BOLD + "~~~~~~~~~~~~~~~~~~~");
      System.out.println(GREEN + "Task changes saved." + COLOR_RESET);
      System.out.println("~~~~~~~~~~~~~~~~~~~" + RESET);
    } catch (Exception e) {
      System.out.println("Error saving tasks.");
    }
  }

  private static void closeCalendar() {
    System.out.println(BOLD + "---------------------------------------");
    System.out.println(RED + "Closing Calendar " + COLOR_RESET + "... " + GREEN + "see you next time!" + COLOR_RESET);
    System.out.println("---------------------------------------\n" + RESET);
    calendarOpen = false;
  }

}
