import model.Student;
import service.StudentManager;
import exception.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Data Entry System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter PRN: ");
                        String prn = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter DoB: ");
                        String dob = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        float marks = sc.nextFloat();
                        sc.nextLine();
                        manager.addStudent(new Student(prn, name, dob, marks));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        List<Student> all = manager.getAllStudents();
                        all.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter PRN to search: ");
                        String searchPrn = sc.nextLine();
                        System.out.println(manager.searchByPRN(searchPrn));
                        break;

                    case 4:
                        System.out.print("Enter Name to search: ");
                        String searchName = sc.nextLine();
                        manager.searchByName(searchName).forEach(System.out::println);
                        break;

                    case 5:
                        System.out.print("Enter index to search: ");
                        int index = sc.nextInt();
                        System.out.println(manager.searchByPosition(index));
                        break;

                    case 6:
                        System.out.print("Enter PRN to update: ");
                        String updatePrn = sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter New DoB: ");
                        String newDob = sc.nextLine();
                        System.out.print("Enter New Marks: ");
                        float newMarks = sc.nextFloat();
                        manager.updateStudent(updatePrn, newName, newDob, newMarks);
                        System.out.println("Student updated.");
                        break;

                    case 7:
                        System.out.print("Enter PRN to delete: ");
                        String deletePrn = sc.nextLine();
                        manager.deleteStudent(deletePrn);
                        System.out.println("Student deleted.");
                        break;

                    case 0:
                        System.out.println("Exiting. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}
