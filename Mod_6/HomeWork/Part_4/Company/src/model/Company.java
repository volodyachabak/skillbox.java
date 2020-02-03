package model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private double income;
    private List<Employee> staff = new ArrayList<>();

    public Company() {
    }

    public Company(double income) {
        this.income = income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        staff.sort((e1, e2) -> {
            if (e1.getMonthSalary() > e2.getMonthSalary()) {
                return -1;
            } else {
                return e1.getMonthSalary() < e2.getMonthSalary() ? 1 : 0;
            }
        });
        return staff.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        staff.sort((e1, e2) -> {
            if (e1.getMonthSalary() < e2.getMonthSalary()) {
                return -1;
            } else {
                return e1.getMonthSalary() > e2.getMonthSalary() ? 1 : 0;
            }
        });
        return staff.subList(0, count);
    }

    public void hire(Employee employee) {
        staff.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        staff.addAll(employees);
    }

    public void fire(int count) {
        for(int i = 0; i < count; ++i) {
            int index = (int)(Math.random() * (staff.size() - 1));
            staff.remove(index);
        }

    }

    public double getIncome() {
        double summ = 0;

        for (Employee employee : staff){
            if (employee instanceof Manager){
                summ += ((Manager) employee).getMadeMoney();
            }
        }
        income = summ;
        return income;
    }
}
