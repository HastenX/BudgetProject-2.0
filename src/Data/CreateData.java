package Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Data.StoredData.Budget.SpendingData;

public class CreateData extends DataTemplate {

    private String dataFile = "src/Data/StoredData/SpendingData.json";

    public void path() {
        genData(managePlayerInput());
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

    protected ArrayList<SpendingData> managePlayerInput() {
        for (int i = 0; i <= 3; i++) {
            listOrders(i);
            getPlayerInput(i);
        }
        spendingArrayList = getSpendingArrayList();
        spendingArrayList.add(createSpendingObject());
        spendingName = null;
        spendingCost = -1;
        spendingValue = -1;
        return spendingArrayList;
    }

    private void genData(ArrayList<SpendingData> arrayList) {
        objectMapper = getObjectMapper();
        try {
            objectMapper.writeValue(new File(dataFile), arrayList);
        } catch (IOException e) {
            System.out.println(e);
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
