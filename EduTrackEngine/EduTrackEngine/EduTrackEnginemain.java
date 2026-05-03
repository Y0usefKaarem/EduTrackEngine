/**
 * EduTrackEngine.java
 * Task 2: Core Computational Engine for EduTrack System
 * This class provides static utility methods for calculating averages,
 * converting grades to letters, and determining pass/fail status.
 */
public class EduTrackEngine {

    /**
     * Method 1: Calculates the average of an array of grades.
     * @param grades An array of double values representing student's subject grades (size: 10).
     * @return The calculated average as a double.
     *         Returns 0.0 if the array is null or empty to prevent division by zero.
     */
    
    public static double calculateAverage(double[] grades) {
        if (grades == null || grades.length == 0) {
            return 0.0;
        }

        double total = 0.0;
        for (int i = 0; i < grades.length; i++) {
            total += grades[i];
        }
        return total / grades.length;
    }

    /**
     * Method 2: Converts a numerical average to a letter grade.
     * Grading Scale: A >= 90, B >= 80, C >= 70, D >= 60, F < 60.
     * Justification: if-else-if is used because we are checking ranges of values,
     * not discrete values, making it more suitable than a switch statement.
     *
     * @param average The numerical average to convert.
     * @return The corresponding letter grade (A, B, C, D, or F).
     */
    public static String convertToLetterGrade(double average) {
        if (average >= 90.0) {
            return "A";
        } else if (average >= 80.0) {
            return "B";
        } else if (average >= 70.0) {
            return "C";
        } else if (average >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Method 3: Determines if a student is passing or failing.
     * A student is considered passing if their average is 60 or above.
     *
     * @param average The student's average grade.
     * @return true if passing (average >= 60.0), false otherwise.
     */
    public static boolean isPassing(double average) {
        return average >= 60.0;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("       EduTrack Engine - Test Cases      ");
        System.out.println("=========================================\n");

        // Test Case 1: High Performing Student
        System.out.println("--- Test Case 1: High Performer ---");
        double[] grades1 = {95.0, 88.0, 92.0, 100.0, 97.0, 85.0, 91.0, 89.0, 96.0, 90.0};
        testAndPrint(grades1);

        // Test Case 2: Average Student
        System.out.println("--- Test Case 2: Average Student ---");
        double[] grades2 = {72.0, 68.0, 75.0, 70.0, 74.0, 71.0, 73.0, 69.0, 76.0, 70.0};
        testAndPrint(grades2);

        // Test Case 3: Failing Student
        System.out.println("--- Test Case 3: Failing Student ---");
        double[] grades3 = {55.0, 48.0, 52.0, 45.0, 58.0, 50.0, 42.0, 47.0, 53.0, 40.0};
        testAndPrint(grades3);

        // Test Case 4: Borderline Pass (exactly 60)
        System.out.println("--- Test Case 4: Borderline Pass (60.0) ---");
        double[] grades4 = {60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0};
        testAndPrint(grades4);

        // Test Case 5: Borderline Fail (59.9)
        System.out.println("--- Test Case 5: Borderline Fail (59.9) ---");
        double[] grades5 = {59.9, 59.9, 59.9, 59.9, 59.9, 59.9, 59.9, 59.9, 59.9, 59.9};
        testAndPrint(grades5);

        // Test Case 6: Empty Array (Edge Case)
        System.out.println("--- Test Case 6: Empty Array (Edge Case) ---");
        double[] grades6 = {};
        testAndPrint(grades6);

        System.out.println("=========================================");
        System.out.println("         All Test Cases Completed        ");
        System.out.println("=========================================");
    }

    /**
     * Helper method to test and display results for a given set of grades.
     */
    public static void testAndPrint(double[] grades) {
        double avg = calculateAverage(grades);
        String letter = convertToLetterGrade(avg);
        boolean pass = isPassing(avg);

        System.out.println("Number of subjects: " + (grades != null ? grades.length : 0));
        System.out.println("Average: " + avg);
        System.out.println("Letter Grade: " + letter);
        System.out.println("Passing Status: " + (pass ? "PASS" : "FAIL"));
        System.out.println();
    }

}
