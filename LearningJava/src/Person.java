package LearningJava.src;

public class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public void sayHello() {
    System.out.println(name + ": Hello");
  }

  public void sayMessage(String message) {
    System.out.println(name + ": " + message);
  }

  public String getName() {
    return name;
  }
}
