import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displaySummary();
                case 3 -> System.out.println("Exiting the program.");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 3);
    }

    private static void showMenu() {
        System.out.println("\n===== Student Grade Tracker =====");
        System.out.println("1. Add Student and Grade");
        System.out.println("2. Display Summary Report");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade (0 - 100): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            return;
        }

        students.add(new Student(name, grade));
        System.out.println("Student added successfully.");
    }

    private static void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        System.out.println("\n---- Student Grades ----");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();
        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + topStudent + " (" + highest + ")");
        System.out.println("Lowest Grade: " + lowStudent + " (" + lowest + ")");
    }
}