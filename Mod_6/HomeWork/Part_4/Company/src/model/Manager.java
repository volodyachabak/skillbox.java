package model;

public class Manager implements Employee {
    private static double salary;
    private static double bonus;
    private double madeMoney;

    public Manager(double madeMoney) {
        this.madeMoney = madeMoney;
    }

    public static void setBonus(double bonus) {
        Manager.bonus = bonus;
    }

    public static void setSalary(double salary) {
        Manager.salary = salary;
    }

    public double getMonthSalary() {
        return salary + madeMoney * bonus;
    }
}