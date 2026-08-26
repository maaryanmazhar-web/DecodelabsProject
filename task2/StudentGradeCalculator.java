import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfSubjects;

        // Ask the user for the number of subjects
        while (true) {
            try {
                System.out.print("Enter the number of subjects: ");
                numberOfSubjects = Integer.parseInt(sc.nextLine());

                if (numberOfSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }

        int totalMarks = 0;

        // Take marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {

            int marks;

            while (true) {
                try {
                    System.out.print("Enter marks for subject " + i + " (0-100): ");
                    marks = Integer.parseInt(sc.nextLine());

                    // Validate marks
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid marks. Marks must be between 0 and 100.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                }
            }

            // Add the marks to total
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Assign grade
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display final results
        System.out.println("\n===== STUDENT GRADE REPORT =====");
        System.out.println("Number of Subjects: " + numberOfSubjects);
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}