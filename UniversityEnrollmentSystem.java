import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    String name;
    int capacity;
    int enrolled;
    String prerequisite;

    public Course(String name, int capacity, String prerequisite) {
        this.name = name;
        this.capacity = capacity;
        this.prerequisite = prerequisite;
        this.enrolled = 0;
    }

    public void enrollStudent(String completedCourse) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolled >= capacity) {
            throw new CourseFullException("Course is full.");
        }
        if (!prerequisite.isEmpty() && !prerequisite.equalsIgnoreCase(completedCourse)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name + ".");
        }

        enrolled++;
        System.out.println("Enrollment successful in " + name + ".");
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        System.out.print("Enroll in Course: " + advancedJava.name + "\nHave you completed prerequisite (" + advancedJava.prerequisite + ")? (yes/no): ");
        String status = sc.nextLine();

        String completedCourse = status.equalsIgnoreCase("yes") ? "Core Java" : "";

        try {
            advancedJava.enrollStudent(completedCourse);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
