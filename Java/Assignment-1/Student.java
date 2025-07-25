import java.util.*;

public class Student {
    String name;
    String classLevel;
    String[] subjects;
    int[] marks;

    public Student(String name, String classLevel, String[] subjects) {
        this.name = name;
        this.classLevel = classLevel;
        this.subjects = subjects;
        this.marks = new int[subjects.length];
    }

    public void enterMarks(Scanner sc) {
        for (int i = 0; i < subjects.length; i++) {
            int mark;
            while (true) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) break;
                System.out.println("Invalid marks. Try again.");
            }
            marks[i] = mark;
        }
    }

    public void editMarks(Scanner sc) {
        System.out.println("Select subject to edit:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%d. %s (%d)\n", i + 1, subjects[i], marks[i]);
        }
        int choice = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        if (choice >= 0 && choice < subjects.length) {
            int newMark;
            while (true) {
                System.out.print("Enter new marks for " + subjects[choice] + ": ");
                newMark = sc.nextInt();
                if (newMark >= 0 && newMark <= 100) break;
                System.out.println("Invalid marks. Try again.");
            }
            marks[choice] = newMark;
        } else {
            System.out.println("Invalid selection.");
        }
    }

    public void printReport() {
        System.out.println("\nStudent Name: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.printf("Average Marks: %.2f\n", getAverage());
        System.out.println("Highest Marks: " + getMax());
        System.out.println("Lowest Marks: " + getMin());
        System.out.println("Grade: " + getGrade());
        System.out.println("Result: " + (isPass() ? "Pass" : "Fail"));
    }

    public String getReportAsText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\n");
        for (int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i]).append(": ").append(marks[i]).append("\n");
        }
        sb.append(String.format("Average: %.2f\n", getAverage()));
        sb.append("Grade: ").append(getGrade()).append("\n");
        sb.append("Max: ").append(getMax()).append(", Min: ").append(getMin()).append("\n");
        sb.append("Result: ").append(isPass() ? "Pass" : "Fail").append("\n");
        sb.append("----------------------------\n");
        return sb.toString();
    }

    public double getAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public int getMax() {
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) max = mark;
        }
        return max;
    }

    public int getMin() {
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) min = mark;
        }
        return min;
    }

    public boolean isPass() {
        for (int mark : marks) {
            if (mark < 40) return false;
        }
        return true;
    }

    public String getGrade() {
        double avg = getAverage();
        int gradeBucket = (int) avg / 10;
        switch (gradeBucket) {
            case 10:
            case 9: return "A+";
            case 8: return "A";
            case 7: return "B";
            case 6: return "C";
            case 5:
            case 4: return "D";
            default: return "F";
        }
    }

    public String getName() {
        return name;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public double getAvgMarks(){
        return getAverage();
    }


}