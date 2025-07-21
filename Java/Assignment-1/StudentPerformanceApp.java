
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class StudentPerformanceApp {
    static final Map<String, String[]> classSubjects = Map.of(
        "10th", new String[]{"Math", "Science", "English"},
        "11th", new String[]{"Physics", "Chemistry", "Math"},
        "12th", new String[]{"Accounts", "BusinessStudies", "Economics"}
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("Hey Instructor ! \n");
        System.out.print("Enter your class (10th, 11th, or 12th): ");
        String classLevel = sc.nextLine();
        String[] subjects = classSubjects.getOrDefault(classLevel, null);

        if (subjects == null) {
            System.out.println("Invalid class level selected.");
            return;
        }

        while (true) {
            System.out.println("\n--------- Academic Performance Tracker ---------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Reports");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Sort Students by Average");
            System.out.println("5. Save Report to File");
            System.out.println("6. Review and Edit Student Marks");
            System.out.println("7. Exit");
            System.out.print("Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    Student student = new Student(name, classLevel, subjects);
                    student.enterMarks(sc);
                    students.add(student);
                    System.out.println("Student added successfully.");
                }

                case 2 -> {
                    List<Student> filtered = students.stream()
                        .filter(s -> s.getClassLevel().equals(classLevel))
                        .toList();

                    if (filtered.isEmpty()) System.out.println("No data available.");
                    else filtered.forEach(Student::printReport);
                }

                case 3 -> {
                    System.out.print("Enter student name to search: ");
                    String query = sc.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.getClassLevel().equals(classLevel) &&
                            s.getName().equalsIgnoreCase(query)) {
                            s.printReport();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                }

                case 4 -> {
                    List<Student> filtered = students.stream()
                        .filter(s -> s.getClassLevel().equals(classLevel))
                        .sorted(Comparator.comparingDouble(Student::getAvgMarks).reversed())
                        .toList();

                    filtered.forEach(s -> System.out.printf("%s: %.2f (%s)\n",
                        s.getName(), s.getAvgMarks(), s.getGrade()));
                }

                case 5 -> {
                    List<Student> filtered = students.stream()
                        .filter(s -> s.getClassLevel().equals(classLevel))
                        .toList();

                    if (filtered.isEmpty()) {
                        System.out.println("No data to save.");
                    } else {
                        String filename = "report_class" + classLevel + ".txt";
                        try (FileWriter writer = new FileWriter(filename)) {
                            for (Student s : filtered) {
                                writer.write(s.getReportAsText());
                            }
                            System.out.println("Report saved to '" + filename + "'");
                        } catch (IOException e) {
                            System.out.println("Error writing file: " + e.getMessage());
                        }
                    }
                }

                case 6 -> {
                    List<Student> filtered = students.stream()
                        .filter(s -> s.getClassLevel().equals(classLevel))
                        .toList();

                    if (filtered.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }

                    System.out.print("Enter student name to edit: ");
                    String query = sc.nextLine();
                    boolean found = false;

                    for (Student s : filtered) {
                        if (s.getName().equalsIgnoreCase(query)) {
                            s.printReport();
                            s.editMarks(sc);
                            System.out.println("Marks updated.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) System.out.println("Student not found.");
                }

                case 7 -> {
                    System.out.println("Thank you, Instructor! Session ended.");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
