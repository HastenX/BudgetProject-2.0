package Data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import Data.StoredData.Budget.SpendingData;

public class CreateData extends DataTemplate {

    public void path() {
        objectMapper = getObjectMapper();
        List<SpendingData> newListData = managePlayerInput();
        List<SpendingData> exsistingData = getExistingData();
        if (exsistingData != null) {
            newListData.addAll(exsistingData);
        }
        genData(newListData);
    }

    protected void getPlayerInput(int i) {
        scanner = getScanner();
        switch (i) {
            case 1:
                spendingName = scanner.nextLine();
                break;
            case 2:
                spendingCost = scanner.nextDouble();
                break;
            case 3:
                spendingValue = scanner.nextInt();
                break;
            default:
                break;
        }
    }

    private List<SpendingData> getExistingData() {
        List<SpendingData> dataList = getSpendingArrayList();
        try {
            dataList = objectMapper.readValue(spendingDataFile, new TypeReference<List<SpendingData>>() {
            });
        } catch (IOException e) {
            System.out.println(e);
        }

        return dataList;
    }

    protected List<SpendingData> managePlayerInput() {
        tempDataList = getSpendingArrayList();
        for (int i = 0; i <= 4; i++) {
            listOrders(i);
            getPlayerInput(i);
        }
        SpendingData newData = new SpendingData(spendingName, spendingCost, spendingValue);
        tempDataList.add(newData);
        return tempDataList;
    }

    public void genData(List<SpendingData> list) {
        try {
            objectMapper = getObjectMapper();
            objectMapper.writeValue(spendingDataFile, list);
        } catch (IOException e) {
        }
    }

    protected void listOrders(int i) {
        switch (i) {
            case 1:
                System.out.println("Please Enter the name of the spending: ");
                break;
            case 2:
                System.out.println("Please Enter the cost: ");
                break;
            case 3:
                System.out.println("Please Enter the value(1-3, most to least important): ");
                break;
            default:
                break;
        }
    }
}