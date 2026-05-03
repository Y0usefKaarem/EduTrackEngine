import java.util.Arrays;

/**
 * Project: EduTrackEngine
 * Finalized Version with all required methods and answers.
 */
public class EduTrackEngine {

    // 1. Calculate Average
    public double calculateAverage(double[] grades) {
        if (grades == null || grades.length == 0) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // 2. Convert to Grade (A, B, C...)
    public String convertToGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    // 3. Pass/Fail
    public boolean isPassing(double average) {
        return average >= 50; 
    }

    // 4. Print Report
    public void printReport(String studentName, double[] grades) {
        double avg = calculateAverage(grades);
        String grade = convertToGrade(avg);
        String status = isPassing(avg) ? "Passed" : "Failed";

        System.out.println("\n--- EduTrack Student Report ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.println("Average: " + String.format("%.2f", avg));
        System.out.println("Letter Grade: " + grade);
        System.out.println("Final Status: " + status);
        System.out.println("-------------------------------");
    }

    // 5. Highest Average
    public double getHighestAverage(double[] averages) {
        if (averages == null || averages.length == 0) return 0;
        double max = averages[0];
        for (double avg : averages) {
            if (avg > max) max = avg;
        }
        return max;
    }

    // 6. Count Grades
    public int countGrades(String[] studentGrades, String targetGrade) {
        int count = 0;
        for (String g : studentGrades) {
            if (g != null && g.equalsIgnoreCase(targetGrade)) count++;
        }
        return count;
    }

    // Main Method for Testing
    public static void main(String[] args) {
        EduTrackEngine engine = new EduTrackEngine();

        double[] userGrades = {88.5, 94.0, 79.5, 91.0};
        engine.printReport("Yousef", userGrades);

        double[] allAverages = {85.0, 92.5, 60.0, 45.0};
        String[] allGrades = {"B", "A", "D", "F"};
        
        System.out.println("Highest average in class: " + engine.getHighestAverage(allAverages));
        System.out.println("Number of students with 'A': " + engine.countGrades(allGrades, "A"));

        displayProjectQuestions();
    }

    private static void displayProjectQuestions() {
        System.out.println("\n--- Required Project Questions ---");
        System.out.println("Q1: What is the primary function of this engine?");
        System.out.println("A1: It automates the calculation and categorization of student academic performance.");

        System.out.println("Q2: Why are these operations encapsulated in methods?");
        System.out.println("A2: To allow the logic to be reused across different parts of the application without duplication.");

        System.out.println("Q3: How is the 'Pass/Fail' threshold determined?");
        System.out.println("A3: It is based on a conditional check in the isPassing method, currently set to 50%.");

        System.out.println("Q4: How can we expand this for multiple subjects?");
        System.out.println("A4: By using multi-dimensional arrays or Objects to store scores for different subjects per student.");
    }
}
