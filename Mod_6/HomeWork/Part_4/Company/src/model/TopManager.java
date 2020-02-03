package model;

public class TopManager implements Employee {
    private double salary;
    private double bonus;
    private int border = 10_000_000;
    private Company company;

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public TopManager(double salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMonthSalary() {

        return (company.getIncome() > border) ? salary + salary * bonus : salary;
    }
}