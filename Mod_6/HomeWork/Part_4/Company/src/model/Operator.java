package model;

public class Operator implements Employee {
    private static double salary;

    public static void setSalary(double salary) {
        Operator.salary = salary;
    }

    public double getMonthSalary() {
        return salary;
    }
}
