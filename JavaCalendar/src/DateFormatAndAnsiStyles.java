package JavaCalendar.src;

import java.time.format.DateTimeFormatter;

public class DateFormatAndAnsiStyles {
  // Constants for Formatting Date and Time
  public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("(EEEE) MMM d, yyyy");
  public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("h:mm a");
  // Constants for ANSI text styles output in terminal
  public static final String BOLD = "\u001B[1m";
  public static final String UNDERLINE = "\u001B[4m";
  public static final String GREEN = "\u001B[32m";
  public static final String PURPLE = "\u001B[35m";
  public static final String RED = "\u001B[31m";
  public static final String COLOR_RESET = "\u001B[39m";
  public static final String RESET = "\u001B[0m";
}
