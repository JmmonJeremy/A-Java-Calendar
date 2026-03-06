# A Java Calendar for Tasks and Events

This a Java program for scheduling, prioritizing, and tracking tasks by date and time on a calendar-type setup.

## Instructions for Build and Use

[Software Demo](https://youtu.be/mWVzVVO07hI)

Steps to build and/or run the software:

1. Go to the website https://adoptium.net/ and install JDK 21 LTS
2. Install the Extension Pack for Java from the EXTENSIONS: MARKETPLACE in VS Code
3. Create a folder to hold the project
4. In VS Code press Ctrl + Shift + P & type in and then select Java: Create Java Project
5. Select No Build Tools and choose the folder you created for the project to be in
6. Enter name for the Project
7. Right click on the src folder and Select New Java File > Class to add the classes & code
8. Click run to run the code

Instructions for using the software:

1. Open the JavaCalendar folder with VS Code
2. Click on the Run in the App.java class file above the main method or the play arrow at the top right
3. Alternatively in the powershell terminal enter the command "javac JavaCalendar/src/App.java" to compile the code & create class extension files
4. In the powershell terminal enter the command "java JavaCalendar/src/App.java" to run the main method in the App.java file
5. User the terminal to enter selections of Add task, View all tasks, View tasks by date, Change task status, Save changes, and Exit

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Development Environment

To recreate the development environment, you need the following software and/or libraries with the specified versions:

* Visual Studio Code
* JDK 21 LTS
* ANSI Escape Sequences
* Git / GitHub

## Useful Websites to Learn More

I found these websites useful in developing this software:

### Visual Studio Code :
* [Visual Studio Code & GitHub](https://code.visualstudio.com/docs/sourcecontrol/overview)
* [Installing the Extension Pack for Java](https://code.visualstudio.com/docs/languages/java)
* [Creating a Java Project in VS Code](https://se-education.org/guides/tutorials/vscCreatingNewJavaProject.html)
* [Managing Java Projects in VS Code](https://code.visualstudio.com/docs/java/java-project)

### Java :
* [Java Tutorial](https://www.w3schools.com/java/default.asp)
* [Java ArrayList](https://beginnersbook.com/java-collections-tutorials/)
* [Java Comparable Interface](https://www.geeksforgeeks.org/java/comparable-interface-in-java-with-examples/)
* [Java Comparable Multiple Factors](https://jenkov.com/tutorials/java-collections/comparable.html)
* [Java sort(null)](https://stackoverflow.com/questions/49436291/what-does-arraylistname-sortnull-do)
* [Java toString() & Overriding](https://www.baeldung.com/java-tostring)
* [Java Split String Using Regex](https://www.geeksforgeeks.org/java/java-split-string-using-regex/)
* [Java Array indexing](https://www.javaspring.net/blog/index-of-array-java/)
* [Java ArrayList Methods](https://www.w3schools.com/java/java_ref_arraylist.asp)
* [Java ArrayList isEmpty()](https://www.geeksforgeeks.org/java/arraylist-isempty-java-example/)
* [Java Date and Time](https://www.w3schools.com/java/java_date.asp)
* [Java LocalDate](https://beginnersbook.com/2017/10/java-localdate/)
* [Java LocalDate – equals()](https://beginnersbook.com/2017/10/java-localdate-equals/)
* [Java LocalTime](https://beginnersbook.com/2017/10/java-localtime/)
* [Java LocalTime plusMinutes()](https://www.geeksforgeeks.org/java/localtime-plusminutes-method-in-java-with-examples/)
* [Java DateTimeFormatter](https://beginnersbook.com/2017/11/java-datetimeformatter/)
* [Java BufferedWriter](https://www.w3schools.com/JAVA/java_bufferedwriter.asp)
* [Java BufferedReader](https://www.w3schools.com/java/java_bufferedreader.asp)
* [Java Switch](https://www.w3schools.com/java/java_switch.asp)
* [Java Output / Print](https://www.w3schools.com/java/java_output.asp)
* [Java Colored Console Text](https://www.geeksforgeeks.org/java/how-to-print-colored-text-in-java-console/)
* [Java ANSI Code Constants](https://www.tutorialspoint.com/how-to-print-colored-text-in-java-console)
* [ANSI Escape Sequences](https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797)

## Future Work

The following items I plan to fix, improve, and/or add to this project in the future:

* [ ] I will add a try catch while loop to catch false date formats and entries for selecting tasks by date
* [ ] I want to make it so default year, month, and day are available - so they don't have to be typed in
* [ ] I want to make it to the output is grouped by month, week, and day
* [ ] I want to add a class for Events
* [ ] I want to add a monthly grid JavaFX GUI
