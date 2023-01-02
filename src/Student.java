public class Student {

    //COMPLETE THIS CLASS BEFORE MathStudent and ScienceStudent classes as they will be sub-classes of Student class


    //HERE! Create a 5 args constructor
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String className;

    public Student(String firstName, String lastName, int age, String gender, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.className = className;
    }

/*
    HERE!
    Create private instance variables as below
    firstName
    lastName
    age
    gender
    className
    NOTE: only age will be int and others are String
     */



    /*
    HERE!
    Provide public getter method for className only
     */

    public String getClassName() {
        return className;
    }
/*
        HERE!
        Override toString() method that returns Student object information
        It should be dynamic considering child classes that inherits
     */

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
