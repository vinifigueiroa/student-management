/**  This program provides administrators with the ability to manage student records.
*    It allows administrators to add new students, update student information,
*    and view student details.
*/

import java.util.*;

public class studentManagement {

    public static void main(String[] args) {

        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);

        // Load Default Students
        {
            new Student("John Smith", 18, 95.5);
            new Student("Alice Johnson", 19, 88.0);
            new Student("David Lee", 20, 92.5);
            new Student("Emily Davis", 21, 87.2);
            new Student("Michael Wilson", 19, 91.8);
            new Student("Sophia Brown", 20, 89.7);
            new Student("James Anderson", 22, 93.4);
            new Student("Olivia Garcia", 18, 94.1);
            new Student("William Martinez", 19, 86.9);
            new Student("Emma Rodriguez", 21, 90.3);
        }

        // Intro
        System.out.println("STUDENT MANAGEMENT SYSTEM. \n\nWELCOME.");

        // Menu
        boolean loop = true;
        while (loop) {

            System.out.println("\n\nMENU \n\nA - Add a New Student \nB - Update a Student's Information \nC - Get a Student's Information \nD - List all students \nE - Exit \n \nTYPE THE CORRESPONDING LETTER\n");
            String choice = scanner.nextLine().toLowerCase();
            System.out.println("\n");

            switch (choice) {
                case "a":
                    addStudent(scanner);
                    break;

                case "b":
                    updateStudent(scanner);
                    break;

                case "c":
                    getInformation(scanner);
                    break;

                case "d":
                    listAllStudents(scanner);
                    break;

                case "e":
                    loop = false;
                    break;

                default:
                    break;
            }
        }


        // Close Scanner
        scanner.close();
    }


    public static void addStudent(Scanner scanner) {

        // Adds a new student and generates an unique ID;

        // Get student's information
        System.out.println("\n \nType the name of the student:");
        String name = scanner.nextLine();

        System.out.println("\n \nType the age of the student:");
        int age = positiveIntegerInput(scanner);

        System.out.println("\n \nType the grade of the student:");
        double grade = positiveDoubleInput(scanner);

        // Confirmation
        Student student = new Student(name, age, grade);
        System.out.println("\n\n" + student.getName() + " Successfully Added!");
        student.summary();

        pressEnter(scanner);

    }

    public static void listAllStudents(Scanner scanner){

       // Lists all enrolled students on the screen sorted by ID number;

       // Sort ID's
        List<Integer> idlist = new ArrayList<>(Student.allStudents.keySet());
        Collections.sort(idlist);

        //Display Students
        for (Integer key : idlist) {
            Student.allStudents.get(key).summary();
        }

        // Display total amount
        System.out.println("You have " + Student.studentsCount + " enrolled students.");

        pressEnter(scanner);
    }

    public static void getInformation(Scanner scanner) {

        // Displays information about a single student based on their ID number

        Student student = Student.allStudents.get(IDInput(scanner));
        student.summary();

        pressEnter(scanner);

    }

    public static void updateStudent(Scanner scanner) {

        // Changes a student's information on the system

        // Get Student ID
        Student student = Student.allStudents.get(IDInput(scanner));

        // Display Menu
        System.out.println("Which property would you like to update?\n\nA - Age \nB - Name \nC- Grade\n \nTYPE THE CORRESPONDING LETTER\n");
        String choice = scanner.nextLine().toLowerCase();

        switch (choice) {
            case "a":
                System.out.println("Enter the new updated age \n\n");
                student.setAge(positiveIntegerInput(scanner));
                System.out.println("Age updated Successfully!\n\n");
                break;

            case "b":
                System.out.println("Enter the new updated name \n\n");
                student.setName(scanner.nextLine());
                System.out.println("Name updated Successfully!\n\n");
                break;

            case "c":
                System.out.println("Enter the new updated grade \n\n");
                student.setGrade(positiveDoubleInput(scanner));
                System.out.println("Grade updated Successfully!\n\n");

            default:
                break;
        }

        student.summary();
        pressEnter(scanner);

    }

    // Helper Functions

    public static void pressEnter(Scanner scanner) {

        // Prompts the user for confirmation to continue.

        System.out.println("\nPRESS ENTER TO CONTINUE \n");
        scanner.nextLine();
    }

    public static int positiveIntegerInput(Scanner scanner) {

        //Evaluates if a string input is a valid positive integer and returns the integer value.

        int integer = 0;
        boolean condition = true;

        while(condition) {

            String input = scanner.nextLine();

            try {
                integer = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.err.println("ERROR: Please enter a number.");
                continue;
            }

            if (integer < 0) {
                System.err.println("ERROR: Please enter a positive amount.");
                continue;

            } else if (integer == 0) {
                return 0;

            }

            condition = false;


        }
        System.out.println("\n");
        return integer;

    }

    public static double positiveDoubleInput(Scanner scanner) {

        //Evaluates if a string input is a valid positive double and returns the double value.

        double value = 0.0;
        boolean condition = true;

        while(condition) {

            String input = scanner.nextLine();

            try {
                value = Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.err.println("ERROR: Please enter a number in decimal format 0.0.");
                continue;
            }

            if (value < 0.0) {

                System.err.println("ERROR: Please enter a positive amount.");
                continue;

            } else if (value == 0.0) {
                return 0.0;

            }

            condition = false;


        }

        System.out.println("\n");
        return value;

    }

    public static int IDInput(Scanner scanner) {

        // Evaluates if the input value is a valid student ID number. Returns the ID number;

        System.out.println("Type the corresponding ID number for the student you would like to consult:");
        int ID = 0;
        boolean condition = true;

        while (condition) {

            ID = positiveIntegerInput(scanner);

            if (Student.allStudents.get(ID) == null) {

                System.out.println("ID not found. Try again.");
                continue;
            }

            condition = false;
        }

        return ID;
    }
}

public class Student {

    // These variables can be consulted publically and are commmon to all Student Objects
    public static Map<Integer, Student> allStudents = new HashMap<>();
    public static int studentsCount = 0;

    // These private variables can only be consulted and modified by using the appropriate getter and setter methods below
    private String name;
    private int ID;
    private int age;
    private double grade;


    // Constructor

    public Student(String name, int age, double grade) {

        this.name = name;
        this.ID = studentsCount + 101;
        this.age = age;
        this.grade = grade;

        // Add student to the list and update count
        allStudents.put(ID, this);
        studentsCount++;

    }


    // Getter Methods

    public String getName() {return name;}

    public double getGrade() {return grade;}

    public int getID() {return ID;}

    public int age() {return age;}

    public void summary() {
        System.out.println("ID: " + ID +" || Name: "+ name + " || Age: " + age + " || Grade: " + grade + "\n");

    }


    // Setter Methods

    public void setAge(int newage) {age = newage;}

    public void setGrade(double newgrade) {grade = newgrade;}

    public void setName(String newname) {name = newname;}
}
