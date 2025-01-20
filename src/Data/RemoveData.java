package Data;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import Data.StoredData.Budget.SpendingData;

public class RemoveData extends DataTemplate {
    public void path() {
        objectMapper = getObjectMapper();
        savedList = getSpendingArrayList();
        List<SpendingData> exsistingData = getExistingData();
        managePlayerInput();
        savedList = getRemoved(exsistingData);
        new CreateData().genData(savedList);
    }

    private List<SpendingData> getRemoved(List<SpendingData> currentData) {
        Iterator<SpendingData> iterator = currentData.iterator();
        savedList = getSpendingArrayList();
        while (iterator.hasNext()) {
            SpendingData willRemove = iterator.next();
            // if
            // ((willRemove.getName().toUpperCase()).equals(removeSpendingName.toUpperCase()))
            // {
            // iterator.remove();
            // }
            if (!(willRemove.getName().toUpperCase()).equals(removeSpendingName.toUpperCase())) {
                savedList.add(willRemove);
            }
        }
        return savedList;
    }

    protected void getPlayerInput(int i) {
        scanner = getScanner();
        removeSpendingName = scanner.nextLine();
    }

    private List<SpendingData> getExistingData() {
        List<SpendingData> dataList = getSpendingArrayList();
        objectMapper = getObjectMapper();
        try {
            dataList = objectMapper.readValue(spendingDataFile, new TypeReference<List<SpendingData>>() {
            });
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(dataList.get(0).name);
        return dataList;
    }

    protected void managePlayerInput() {
        listOrders(0);
        getPlayerInput(0);
    }

    protected void listOrders(int i) {
        System.out.println("Please Enter the name of the spending being removed: ");
    }
}
