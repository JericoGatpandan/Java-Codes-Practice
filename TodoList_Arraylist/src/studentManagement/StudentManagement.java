package studentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Create a class Student with attributes such as name, age and major. Create a console menu to add, update, delete items in the list and sort the students by age.
public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<Student>();
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;
            while (!exit) {
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student Information");
                System.out.println("3. Delete Student");
                System.out.println("4. Sort Student by Age");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: addStudent(scanner);break;
                    case 2: editStudent(scanner); break;
                    case 3: deleteStudent(scanner); break;
                    case 4: sortStudent(scanner); break;
                    case 5: exit = true; break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        students.add(new Student(name, age, major));
        System.out.println("Student added successfully!");

    }

    private static void editStudent(Scanner scanner) {
        System.out.println("Enter the index of the student you want to edit ");
        int chgIdx = Integer.parseInt(scanner.nextLine());


        if (chgIdx > (students.size() - 1)) {
            System.out.println("There is no such index position in the list");
        } else {
            System.out.print("Enter new Name (press Enter to retain): ");
            String updatedName = scanner.nextLine();
            if(!updatedName.isEmpty()) {
                students.get(chgIdx).setName(updatedName);
            }

            System.out.print("Enter new Age (press Enter to retain): ");
            String ageInput = scanner.nextLine();
            if(!ageInput.isEmpty()) {
                try {
                    int updatedAge = Integer.parseInt(ageInput);
                    students.get(chgIdx).setName(updatedName);
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid age input. Age unchanged.");
                }

            }

            System.out.print("Enter new Major (press Enter to retain): ");
            String updatedMajor = scanner.nextLine();
            if(!updatedMajor.isEmpty()) {
                students.get(chgIdx).setMajor(updatedMajor);
            }

            System.out.println("\nStudent updated successfully!");

        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("Enter the index of the student you want to delete ");
        int rmvIdx = Integer.parseInt(scanner.nextLine());

        if (rmvIdx > (students.size() -1)) {
            System.out.println("There is no such index position in the list");
        } else {
            students.remove(rmvIdx);
            System.out.println("The student has been removed from the list");
        }
    }

    private static void sortStudent(Scanner scanner) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        });
        System.out.println("Student sorted by age:");
        students.forEach(student -> System.out.println(student.showInfo()));
    }
}
