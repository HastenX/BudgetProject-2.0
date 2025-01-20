package Data.StoredData;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class Budget {
    @JsonAppend
    public static class SpendingData {
        public String name;
        public double cost;
        public int value;

        public SpendingData() {

        }

        public SpendingData(String name, double cost, int value) {
            this.name = name;
            this.cost = cost;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }

        public int getValue() {
            if (value > 3) {
                return 3;
            }
            if (value < 1) {
                return 1;
            }
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    @JsonAppend
    public static class BaseData {
        public double salary;
        public double debt;
        public double savings;
        public double APY;

        public BaseData() {

        }

        public BaseData(double salary, double debt, double savings, double APY) {
            this.salary = salary;
            this.debt = debt;
            this.savings = savings;
            this.APY = APY;
        }

        public double getSalary() {
            return salary;
        }

        public double getDebt() {
            return debt;
        }

        public double getSavings() {
            return savings;
        }

        public double getAPY() {
            return APY;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDebt(double debt) {
            this.debt = debt;
        }

        public void setSavings(double savings) {
            this.savings = savings;
        }

        public void setAPY(double APY) {
            this.APY = APY;
        }

    }
}
