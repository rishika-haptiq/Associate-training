import java.util.*;
import java.util.stream.Collectors;

public class EmployeeUtils {

    // As per the requirements
    // Filter employees earning > ₹50K
    public static List<Employee> filterHighEarners(List<Employee> list) {
        return list.stream()
                   .filter(e -> e.getSalary() > 50000)
                   .collect(Collectors.toList());
    }

    // Group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> list) {
        return list.stream()
                   .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    // Get average salary per department
    public static Map<String, Double> averageSalaryByDepartment(List<Employee> list) {
        return list.stream()
                   .collect(Collectors.groupingBy(
                       Employee::getDepartment,
                       Collectors.averagingDouble(Employee::getSalary)
                   ));
    }

    // Sort employees by calculated experience and salary
    public static List<Employee> sortByExperienceThenSalary(List<Employee> list) {
        return list.stream()
                   .sorted(Comparator.comparingInt(Employee::getExperienceInYears)
                                     .thenComparingDouble(Employee::getSalary))
                   .collect(Collectors.toList());
    }
}
