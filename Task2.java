import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks in each subject
        int[] marks = new int[numSubjects];

        // Input marks for each subject
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];  // Sum up the total marks
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine grade based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "O";
        } else if (averagePercentage >= 80) {
            grade = "A+";
        } else if (averagePercentage >= 70) {
            grade = "A";
        } else if (averagePercentage >= 60) {
            grade = "B+";
        } else if (averagePercentage >= 50) {
            grade = "B";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Close scanner to prevent resource leak
        scanner.close();
    }
}

