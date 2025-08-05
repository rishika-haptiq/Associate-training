package HR;

import java.util.List;

public class HRAnalyticsTool {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataLoader.loadSampleData();

        System.out.println("Employees earning more than ₹50K:");
        EmployeeUtils.filterBySalary(employees, 50000)
                .forEach(e -> System.out.println(e.getName()));

        System.out.println("\nGrouped by Department:");
        EmployeeUtils.groupByDepartment(employees)
                .forEach((dept, list) -> System.out.println(dept + " → " + list.size() + " employees"));

        System.out.println("\nAverage Salary by Department:");
        EmployeeUtils.averageSalaryPerDepartment(employees)
                .forEach((dept, avg) -> System.out.printf("%s: ₹%.2f%n", dept, avg));

        System.out.println("\nSorted by Experience then Salary:");
        EmployeeUtils.sortByExperienceThenSalary(employees)
                .forEach(e -> System.out.println(e.getName() + ": " + e.getExperience() + " yrs, ₹" + e.getSalary()));
    }
}
