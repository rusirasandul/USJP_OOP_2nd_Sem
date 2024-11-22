import java.util.Scanner;
import java.util.regex.*;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Student object
        Student student = new Student();

        // Input student details
        System.out.println("Enter student name:");
        student.setStudentName(scanner.nextLine());

        System.out.println("Enter student email:");
        try {
            student.setStudentEmail(scanner.nextLine());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Enter student gender (M/F):");
        char studentGender = scanner.next().charAt(0);

        try {
            student.setStudentGender(studentGender);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Display student details
        System.out.println("***************************************");
        System.out.println("             Student Details           ");
        System.out.println("***************************************");
        System.out.printf("Name   : %s%n", student.getStudentName());
        System.out.printf("Email  : %s%n", student.getStudentEmail());
        System.out.printf("Gender : %c%n", student.getStudentGender());
        System.out.println("***************************************");
    }
}
