package LearningJava.src;
import java.util.ArrayList;

public class Group {

  private ArrayList<Person> people;

  private String name;

  private int maxSize;

  public Group(String name, int maxSize) {
    people = new ArrayList<>(); // don't need to use this because no other people variable in function
    this.name = name;
    this.maxSize = maxSize;
  }

  public void addToGroup(Person person) {
    if (people.size() == maxSize) {
      System.out.println("Sorry ... Group is full.");
      return;
    }
    people.add(person);
    System.out.println("Welcome " + person.getName() + " to the group.");
  }

  public void groupSpeak(String message) {
    for (Person p : people) {
      p.sayMessage(message);
    }
  }
}
