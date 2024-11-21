import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private final String fileName = "students.dat";

    public StudentManagementSystem() {
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveStudentsToFile();
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found; ignore as it will be created later.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }

    public void updateStudent(int rollNumber, String newName, String newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            saveStudentsToFile();
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class Task5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(sms);
                    break;
                case 2:
                    removeStudent(sms);
                    break;
                case 3:
                    searchStudent(sms);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    editStudent(sms);
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(StudentManagementSystem sms) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Name and grade cannot be empty.");
        } else {
            sms.addStudent(new Student(name, rollNumber, grade));
            System.out.println("Student added successfully!");
        }
    }

    private static void removeStudent(StudentManagementSystem sms) {
        System.out.print("Enter roll number to remove: ");
        int rollNumber = scanner.nextInt();
        sms.removeStudent(rollNumber);
        System.out.println("Student removed successfully (if existed).");
    }

    private static void searchStudent(StudentManagementSystem sms) {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void editStudent(StudentManagementSystem sms) {
        System.out.print("Enter roll number to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new grade: ");
        String newGrade = scanner.nextLine();

        if (newName.isEmpty() || newGrade.isEmpty()) {
            System.out.println("Name and grade cannot be empty.");
        } else {
            sms.updateStudent(rollNumber, newName, newGrade);
            System.out.println("Student updated successfully (if existed).");
        }
    }
}
