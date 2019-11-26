import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100_000;

    private static double amount1 = 1; //Если безубиточности
    private static double amount2 = minInvestmentsAmount + 1; //Если найти точку с которой можна инвестировать

    public static void main(String[] args)
    {
        amount1 = formula(amount1);
        amount2 = formula(amount2);

        while(true)
        {
            //Запрос на ввод сумми доходов
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();

            //Проверяется вводимая сума дохода согласно требованиям
            if(!checkIncomeRange(income)) {
                continue;
            }

            //Вичесляется зарплата менеджера
            double managerSalary = income * managerPercent;

            //Чистий доход
            double pureIncome = income - managerSalary - calculateFixedCharges();

            //Сумма налога
            double taxAmount = mainTaxPercent * pureIncome;

            //Чистий доход после оплати налога
            double pureIncomeAfterTax = pureIncome - taxAmount;

            //Может ли фирма инвестировать
            boolean canMakeInvestments = pureIncomeAfterTax >= minInvestmentsAmount;

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }

            System.out.println("Точка с которой можна инвестировать: " + amount2);
            System.out.println("Точка безубиточности: " + amount1);
        }
    }

    private static int formula(double amount){
        return (int)((amount / 0.76 + calculateFixedCharges()) / 0.85);
    }

    private static boolean checkIncomeRange(int income)
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges()
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
