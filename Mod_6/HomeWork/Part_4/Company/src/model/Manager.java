package model;

public class Manager implements Employee {
    private double salary;
    private double bonus;
    private double madeMoney;

    public Manager(double salary) {
        this.salary = salary;
    }

    public void setMadeMoney(double madeMoney) {
        this.madeMoney = madeMoney;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMadeMoney() {
        return madeMoney;
    }

    public double getMonthSalary() {
        return salary + madeMoney * bonus;
    }
}