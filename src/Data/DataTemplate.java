package Data;

import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import Data.StoredData.Budget;
import Data.StoredData.Budget.BaseData;
import Data.StoredData.Budget.SpendingData;

public abstract class DataTemplate {
    public static String spendingName;
    public static double spendingCost;
    public static int spendingValue;

    public abstract void path();

    protected abstract void listOrders(int i);

    protected abstract void getPlayerInput(int i);

    protected ArrayList<SpendingData> spendingArrayList;
    protected ArrayList<SpendingData> BaseData;

    protected ObjectMapper objectMapper;
    protected Scanner scanner;

    protected ArrayList<BaseData> getBaseArrayList() {
        return new ArrayList<BaseData>();
    }

    protected ArrayList<SpendingData> getSpendingArrayList() {
        return new ArrayList<SpendingData>();
    }

    protected ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    protected Scanner getScanner() {
        return new Scanner(System.in);
    }

    protected SpendingData createSpendingObject() {
        return (new Budget()).new SpendingData(spendingName, spendingCost, spendingValue);
    }

    protected SpendingData createBaseObject() {
        return (new Budget()).new SpendingData(spendingName, spendingCost, spendingValue);
    }
}
