import java.time.LocalDate;
import java.util.*;

public class HRAnalyticsTool {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "HR", 60000, LocalDate.of(2018, 4, 12)),
            new Employee("Sneha", "IT", 45000, LocalDate.of(2021, 9, 5)),
            new Employee("Raj", "Finance", 70000, LocalDate.of(2016, 3, 20)),
            new Employee("Priya", "HR", 52000, LocalDate.of(2020, 11, 10)),
            new Employee("Dev", "IT", 85000, LocalDate.of(2015, 7, 1))
        );

        System.out.println(" High Earners:");
        EmployeeUtils.filterHighEarners(employees).forEach(System.out::println);

        System.out.println("\n Grouped by Department:");
        EmployeeUtils.groupByDepartment(employees).forEach((dept, list) -> {
            System.out.println(dept + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n Average Salary per Department:");
        EmployeeUtils.averageSalaryByDepartment(employees).forEach((dept, avg) ->
            System.out.printf("%s ➤ ₹%.2f%n", dept, avg));

        System.out.println("\n Sorted by Experience then Salary:");
        EmployeeUtils.sortByExperienceThenSalary(employees).forEach(System.out::println);
    }
}
