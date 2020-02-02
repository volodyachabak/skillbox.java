package model;

public class TopManager implements Employee {
    private static double salary;
    private static double bonus;
    private static double incomeCompany;

    public static void setBonus(double bonus) {
        TopManager.bonus = bonus;
    }

    public static void setIncomeCompany(double incomeCompany) {
        TopManager.incomeCompany = incomeCompany;
    }

    public static void setSalary(double salary) {
        TopManager.salary = salary;
    }

    public double getMonthSalary() {
        return (incomeCompany > 10_000_000) ? salary + salary * bonus : salary;
    }
}