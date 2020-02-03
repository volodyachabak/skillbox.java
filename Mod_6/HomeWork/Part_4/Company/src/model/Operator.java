package model;

public class Operator implements Employee {
    private double salary;

    public Operator(double salary) {
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMonthSalary() {
        return salary;
    }
}
