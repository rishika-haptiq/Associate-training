package HR;

import java.util.*;
import java.
public class EmployeeUtils {

    public static List<Employee> filterBySalary(List<Employee> employees, double threshold) {
        return employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .collect(Collectors.toList());
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static Map<String, Double> averageSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    public static List<Employee> sortByExperienceThenSalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getExperience)
                        .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }
}
