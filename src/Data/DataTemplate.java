package Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import Data.StoredData.Budget.BaseData;
import Data.StoredData.Budget.SpendingData;

public abstract class DataTemplate {
    public File spendingDataFile = new File("src/Data/StoredData/SpendingData.json");
    public File baseDataFile = new File("src/Data/StoredData/BaseData.json");

    protected List<SpendingData> dataList;
    protected List<SpendingData> newDataList;
    protected List<SpendingData> tempDataList;
    protected List<BaseData> baseDataList;

    protected SpendingData newData;

    public static String spendingName;
    public static double spendingCost;
    public static int spendingValue;

    public static String removeSpendingName;

    public static double baseSalary;
    public static double baseDebt;
    public static double baseSavings;
    public static double baseAPY;

    public abstract void path();

    protected abstract void listOrders(int i);

    protected abstract void getPlayerInput(int i);

    protected static ArrayList<SpendingData> spendingArrayList;
    protected static List<SpendingData> savedList;
    protected static List<BaseData> baseData;

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
        return new SpendingData(spendingName, spendingCost, spendingValue);
    }

    protected SpendingData createBaseObject() {
        return new SpendingData(spendingName, spendingCost, spendingValue);
    }
}
