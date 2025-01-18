package Data.StoredData;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

public class Budget {
    @JsonAppend
    public static class SpendingData {
        private String name;
        private double cost;
        private int value;

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

    public class BaseData {
        private double salary;
        private double debt;
        private double savings;
        private double insuranceCost;

        public BaseData(double salary, double debt, double savings, double insuranceCost) {
            this.salary = salary;
            this.debt = debt;
            this.savings = savings;
            this.insuranceCost = insuranceCost;
        }
    }
}
