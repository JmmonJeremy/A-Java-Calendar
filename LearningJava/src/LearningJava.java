// I have Java 17 (LTS) & Java 21 (LTS) - from https://adoptium.net/ both are industry baseline LTS
// Java 25 (LTS) is available, but it is not industry baseline LTS when this was written 2/28/2026
/*  To start a "Java Project" in VS Code:
#1 Open VS Code & Press Ctrl + Shift + P 
#2 Type and then select Java: Create Java Project
#3 Select No Build Tools and choose an existing folder you want the project to be in
#4 Choose a name for the Project
#5 Right click on the src folder and Select New Java File > Class
#6 Create a  public static void main(String[] args) for a Run option to appear
#7 Click run to run the code
*/
package LearningJava.src;

public class LearningJava {

  public double areaCircle(double radius) {
  return Math.PI * radius * radius;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");

    int x = 10;
    if (x > 20) {
      System.out.println("Greater than 20");
    } else if (x > 10) {
      System.out.println("Greater than 10");
    } else {
      System.out.println("Something smaller");
    }

    for (int i=0; i<10; i++) {
      System.out.println(i);
    }

    LearningJava lj = new LearningJava();
    double area = lj.areaCircle(5);
    System.out.println(area);

    Person p1 = new Person("Bob");
    p1.sayHello();
    p1.sayMessage("Good Luck!");

    Group g = new Group("Coding Club", 5);
    g.addToGroup(p1);
    g.addToGroup(new Person("Tim"));
    g.addToGroup(new Person("Sue"));
    g.addToGroup(new Person("Ada"));
    g.addToGroup(new Person("Ed"));
    g.addToGroup(new Person("Frant"));

    g.groupSpeak("We love to code!");
  }
}
