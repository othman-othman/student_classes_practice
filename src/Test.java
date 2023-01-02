import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join
        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them
        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."
        Store all these 3 objects in a collection and print them
        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (students.size() < 3) {

            System.out.println(UserQuestions.askToJoin);
            String answer = input.nextLine();
            if (!answer.equalsIgnoreCase("y"))
                System.out.println("So, you will not be asked any other questions as you refused to part of programs!\n");
            else {
                System.out.println(UserQuestions.askFirstName);
                String firstName = input.nextLine();

                System.out.println(UserQuestions.askLastName);
                String lastName = input.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = input.nextInt();

                input.nextLine();

                System.out.println(UserQuestions.askGender);
                String gender = input.nextLine();
                String pronouns = "";
                if(gender.equalsIgnoreCase("m")) pronouns = "he";
                else if(gender.equalsIgnoreCase("f")) pronouns = "she";
                else pronouns = "they";

                System.out.println(UserQuestions.askClassName);
                String className = input.nextLine();

                try {
                    Permission.checkAge(age);
                } catch (Exception e) {
                    System.out.println("So, " + firstName + " will not be asked any other questions as " + pronouns + " is " + age + ", this age is not allowed to join\n");
                    continue;
                }

                try {
                    Permission.checkClassName(className);
                } catch (Exception e){
                    System.out.println("So, " + firstName + " will not be registered as " + pronouns + " did not select the programs available\n");
                    continue;
                }

                if (className.equalsIgnoreCase("math")) {
                    MathStudent mathStudent = new MathStudent(firstName, lastName, age, gender, className);
                    students.add(mathStudent);
                    System.out.println("Congratulations! You are registered for Math Class\n");
                } else if (className.equalsIgnoreCase("science")) {
                    ScienceStudent scienceStudent = new ScienceStudent(firstName, lastName, age, gender, className);
                    students.add(scienceStudent);
                    System.out.println("Congratulations! You are registered for Science Class\n");
                }
            }
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
        int numberOfMathStudents = 0;
        int numberOfScienceStudents = 0;

        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase("math")) numberOfMathStudents++;
            else numberOfScienceStudents++;
        }
        System.out.println("Math Students = " + numberOfMathStudents);
        System.out.println("Science Students = " + numberOfScienceStudents);
    }
}