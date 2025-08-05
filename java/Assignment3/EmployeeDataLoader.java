package HR;

public class EmployeeDataLoader {
    public static List<Employee> loadSampleData() {
        return Arrays.asList(
            new Employee("Ravi", "HR", 55000, 5),
            new Employee("Meera", "IT", 75000, 3),
            new Employee("Anil", "HR", 40000, 2),
            new Employee("Sneha", "IT", 88000, 6),
            new Employee("Kiran", "Finance", 65000, 4)
        );
    }
}
