import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Student {
    String name;
    String[] subjects;
    int[] marks;

    Student(String name, int subjectCount) {
        this.name = name;
        subjects = new String[subjectCount];
        marks = new int[subjectCount];
    }

    void enterMarks(Scanner sc) {
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            subjects[i] = sc.next();

            int mark;
            while (true) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter between 0 and 100.");
                }
            }
            marks[i] = mark;
        }
    }

    double getAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    int getMax() {
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    int getMin() {
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }

    boolean isPass() {
        for (int mark : marks) {
            if (mark < 40) {
                return false;
            }
        }
        return true;
    }

    void printReport() {
        System.out.println("\nStudent Name: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.printf("Average Marks: %.2f\n", getAverage());
        System.out.println("Highest Marks: " + getMax());
        System.out.println("Lowest Marks: " + getMin());
        System.out.println("Result: " + (isPass() ? "Pass" : "Fail"));
        System.out.println();
    }

    String getReportAsText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\n");
        for (int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i]).append(": ").append(marks[i]).append("\n");
        }
        sb.append(String.format("Average: %.2f\n", getAverage()));
        sb.append("Max: ").append(getMax()).append(", Min: ").append(getMin()).append("\n");
        sb.append("Result: ").append(isPass() ? "Pass" : "Fail").append("\n");
        sb.append("--------------------------\n");
        return sb.toString();
    }
}

public class StudentPerformanceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100]; // You can handle up to 100 students
        int studentCount = 0;

        while (true) {
            System.out.println("==== Student Performance Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Save Report to File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.next();
                    System.out.print("Enter number of subjects: ");
                    int count = sc.nextInt();
                    Student student = new Student(name, count);
                    student.enterMarks(sc);
                    students[studentCount++] = student;
                    System.out.println("Student data added successfully!\n");
                    break;

                case 2:
                    if (studentCount == 0) {
                        System.out.println("No student data available.\n");
                    } else {
                        for (int i = 0; i < studentCount; i++) {
                            students[i].printReport();
                        }
                    }
                    break;

                case 3:
                    if (studentCount == 0) {
                        System.out.println("No student data to save.\n");
                    } else {
                        try {
                            FileWriter writer = new FileWriter("student_report.txt");
                            for (int i = 0; i < studentCount; i++) {
                                writer.write(students[i].getReportAsText());
                            }
                            writer.close();
                            System.out.println("Report saved to 'student_report.txt'.\n");
                        } catch (IOException e) {
                            System.out.println("Error saving report: " + e.getMessage());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
