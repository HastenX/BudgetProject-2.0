package Line;

import java.util.List;

import Data.StoredData.Budget.BaseData;
import Data.StoredData.Budget.SpendingData;

public class Output {
    private double valueCostOne;
    private double valueCostTwo;
    private double valueCostThree;

    private SpendingData tempData;
    private int i;
    private double totalCost;
    private BaseData baseData;
    private double netIncome;
    private double adjustedSavings;
    private double impulsiveSpending;

    public void path(List<SpendingData> spending, List<BaseData> baseList) {
        baseData = baseList.get(0);
        netIncome = baseData.salary * .855;
        adjustedSavings = baseData.savings + (netIncome * .125);
        impulsiveSpending = netIncome * .025;
        System.out.println("-\nTotal Spendings: ");
        outputTotal(spending, baseList);
        if (isInDebt()) {
            (baseList.get(0)).debt = debtOutput(baseList.get(0));
        }
        outputPercentages(baseList.get(0));
    }

    public void outputObjects(SpendingData tempData) {
        System.out.println("Spenidng #"
                + (i + 1)
                + "\nName: "
                + tempData.name
                + "\nCost: "
                + tempData.cost
                + "\nValue: "
                + tempData.value
                + "\n-");
    }

    public void addCost(SpendingData tempData) {
        totalCost += tempData.cost;
        switch (tempData.value) {
            case 1:
                valueCostOne += tempData.cost;
                break;
            case 2:
                valueCostTwo += tempData.cost;
                break;
            case 3:
                valueCostThree += tempData.cost;
                break;
            default:
                break;
        }
    }

    public void outputPercentages(BaseData baseData) {
        System.out.println("Net Income(Assuming 14.5% tax rate): " + netIncome);
        System.out.println("Total Spent:\n" + totalCost + "$\nSpendings per value:\n"
                + valueCostOne + "$/"
                + valueCostTwo + "$/"
                + valueCostThree + "$");
        System.out.println("-\nSpending percentages per value:\n"
                + ((valueCostOne / totalCost) * 100) + "%/"
                + ((valueCostTwo / totalCost) * 100) + "%/"
                + ((valueCostThree / totalCost) * 100) + "%");
        System.out.println("Amount reserved for Impulsive Spending:\n"
                + impulsiveSpending
                + "$");
        if (baseData.debt > 0) {
            System.out.println(
                    "Amount reserved for Savings and debt (You may decide how you wish to allocate spending): \n"
                            + adjustedSavings
                            + "$");
        } else {
            System.out.println(
                    "Amount reserved for Savings: \n"
                            + adjustedSavings
                            + "$");
        }
        System.out.println("-\nAssuming none of the above, your savings account will increase by ("
                + baseData.APY + "% APY):\n" + baseData.savings * (1 + (baseData.APY / 100))
                + "$");
        System.out.println("-\nTotal Leftover(After accounting spendings): \n" + ((netIncome * .85) - totalCost)
                + "$\n-\nThe Money above should be paired with the amount reserved for savings and debt\nToal of "
                + (adjustedSavings + ((netIncome * .85) - totalCost)
                        + "$ to savings and debt payment\n-"
                        + "\nTotal Percent spent: " + ((1 - (((netIncome * .85) - totalCost) / netIncome)) * 100)
                        + "%"));

    }

    public boolean isInDebt() {
        if (netIncome < totalCost) {
            return true;
        }
        return false;
    }

    public double debtOutput(BaseData baseData) {
        baseData.debt += baseData.salary - totalCost;
        System.out.println("You are in debt by "
                + (baseData.debt)
                + "!");
        return baseData.debt;
    }

    public void outputTotal(List<SpendingData> spending, List<BaseData> baseList) {
        System.out.println("-");
        for (SpendingData exmapleData : spending) {
            tempData = spending.get(i);
            outputObjects(tempData);
            addCost(tempData);
            i++;
        }
    }
}
