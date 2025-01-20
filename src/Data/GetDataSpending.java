package Data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import Data.StoredData.Budget.SpendingData;
import Line.Output;

public class GetDataSpending extends DataTemplate {

    public void path() {
        objectMapper = getObjectMapper();
        List<SpendingData> exsistingData = getExistingData();
        baseData = new GetDataBase().getBaseData();
        if (exsistingData != null) {
            new Output().path(exsistingData, baseData);
        }
    }

    protected void getPlayerInput(int i) {

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

    protected SpendingData managePlayerInput() {
        for (int i = 0; i <= 4; i++) {
            listOrders(i);
            getPlayerInput(i);
        }
        return new SpendingData(spendingName, spendingCost, spendingValue);
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