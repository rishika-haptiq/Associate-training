# 📚 Student Performance Tracker and Report Generator 

This is a Java-based command-line application that allows instructors to manage and review academic performance data for students in grades 10th, 11th, and 12th.
It offers a clean menu driven interface for :
adding student records,
calculating grades,
sorting by average,
editing marks, and 
exporting reports.

--------------------
The application is developed for the convinience of the Instructor considered as he wants it onlt for 10th 11th & 12th grade students, developer can further modify it as per the instructor's need.

---

## 💡 Features

-  Instructor chooses class level: `10th`, `11th`, or `12th`
-  Predefined subjects for each class for the sake of instructor, so that he/she should not write the name of subjects again and again
-  Add students and their subject-wise marks
-  Calculates:
  - Average, Highest, Lowest marks
  - Grade (A+ to F)
  - Pass/Fail status
-   Search by student name
-  Sort students by average marks (High to Low)
-  Save class-specific reports to `.txt` files
- ✏️ Review and edit student marks
-  Input validation for safe data entry 

---

## 🏫 Class Structure and Subjects

| Class | Subjects                        |
|-------|---------------------------------|
| 10th  | Math, Science, English          |
| 11th  | Physics, Chemistry, Math        |
| 12th  | Accounts, BusinessStudies, Economics |

---

## 📦 File Output

Reports are saved in separate files based on class:

- `report_class10th.txt`
- `report_class11th.txt`
- `report_class12th.txt`

Each report includes all students' data from that class with a breakdown of performance.

---

## 🚀 How to Run

1. Compile the Java files:
   ```bash
   javac StudentPerformanceApp.java Student.java
